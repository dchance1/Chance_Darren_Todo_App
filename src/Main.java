import java.io.File;
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
    public static void main(String[] args) {
//        ToDoList toDoList = new ToDoList("Bills Due");
//        toDoList.add(new ToDoListItem("Light bill"));
//        toDoList.add(new ToDoListItem("Phone bill"));
//        toDoList.add(new ToDoListItem("Youtube TV"));
//        toDoList.add(new ToDoListItem("Spotify"));

//        System.out.println(toDoList.listName());
//        //Collections.sort(toDoList.getList(), Collections.reverseOrder());
//        Collections.sort(toDoList.getList());
//
//        int i = 1;
//        for (ToDoListItem item : toDoList.getList()) {
//
//            System.out.println(i + ". " + item.getTitle());
//            i++;
//
//
//
//        }


        Scanner in = new Scanner(System.in);
        String fileName = "todo.txt";
        String choice;

        String menu = "Menu\n" +
                "-".repeat(40) + "\n" +
                "1. New list item\n" +
                "2. Delete list item\n" +
                "3. Quit\n" +
                "-".repeat(40) + "\n";
        System.out.printf(menu);

        ToDoList toDoList = new ToDoList("Bills Due");

        choice = in.nextLine();
        while (true) {
            switch (choice) {
                case "1":
                    System.out.printf("Enter list item: ");
                    //toDoList.add(in.nextLine());
                    break;
                case "2":
                    System.out.println("This feature is not available yet");
                    break;
                case "3":
                    //Data.saveFile(fileName,toDoList);
                    System.exit(0);
                case "4":
                    System.out.println("-".repeat(40));
                    System.out.println("|"+" ".repeat(2)+"to-do-list");
                    System.out.println("-".repeat(40));
                    //Collections.sort(toDoList);
                    for (ToDoListItem item : toDoList.getList()) {
                        System.out.println("-- "+ item);
                    }
                    System.out.println("-".repeat(40));
                    break;
            }
            System.out.println("Select menu item:");
            choice = in.nextLine();


        }



    }
}