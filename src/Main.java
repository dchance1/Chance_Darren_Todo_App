import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//        Write a simple to-do-item application in Java. It should support the following features,
//
//        Add a to-do item
//        Delete a to-do item
//        View the to-do items
//
//        Description:
//        Make sure to structure your program in a modular way. In this case, that means you would have a command-line
//        application which uses a class that holds the to-do items internally and provides public methods to add an
//        item, delete an item, and provide the list of to-do items.

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        String choice;
        String menu = "-".repeat(50) + "\n" +
                "Menu\n" +
                "-".repeat(50) + "\n" +
                "1. New list item " +
                "2. Delete list item " +
                "3. Save\n" +
                "4. View To Do List\n" +
                "-".repeat(50) + "\n";
        System.out.printf(menu);

        ToDoList toDoList = new ToDoList("To-do List");
        File file = new File("To-do list.txt");
        Path path = Paths.get(file.getName());
        if (file.exists()){
            System.out.println("Loading previously saved file from directory: " + path.toAbsolutePath());
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()){
                toDoList.add(new ToDoListItem(scan.nextLine()));
            }
        }

        System.out.printf("Select menu item [\'v\' for menu options]: ");
        choice = in.nextLine();
        while (true) {
            switch (choice) {
                case "1":
                    System.out.printf("Enter list item: ");
                    toDoList.add(new ToDoListItem(in.nextLine()));
                    break;
                case "2":
                    System.out.printf("Enter item number: ");

                    int num = 0;
                    try {
                        num = Integer.valueOf(in.nextLine());
                    } catch (NumberFormatException e) {
                        //throw new RuntimeException(e);
                        System.out.println("Invalid entry! Input must be a whole number.");
                        break;
                    }
                    toDoList.delete(num);
                    break;
                case "3":
                    Data.saveFile(toDoList);
                case "4":
                    System.out.println("-".repeat(40));
                    System.out.println("" + " ".repeat(3) +toDoList.getTitle());
                    System.out.println("-".repeat(40));
                    for (ToDoListItem item : toDoList.getList()) {
                        System.out.println(item.getId() + ". " + item.getTitle());
                    }
                    System.out.println("-".repeat(40));
                    break;
                case "5":
                    System.exit(0);
                case "v":
                    System.out.printf(menu);
            }

            System.out.printf("Select menu item [\'v\' for menu options]: ");
            choice = in.nextLine();

        }


    }
}