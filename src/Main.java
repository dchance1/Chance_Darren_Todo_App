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
        Scanner in = new Scanner(System.in);
        ArrayList<String> toDoList = new ArrayList<String>();
        String fileName = "todo.txt";
        String choice;

        String menu = "Menu\n" +
                "-".repeat(40) + "\n" +
                "1. New list item\n" +
                "2. Delete list item\n" +
                "3. Quit\n" +
                "-".repeat(40) + "\n";
        System.out.printf(menu);

        choice = in.nextLine();
        while (true) {
            switch (choice) {
                case "1":
                    System.out.printf("Enter list text: ");
                    toDoList.add(in.nextLine());
                    break;
                case "2":
                    System.out.println("This feature is not available yet");
                    break;
                case "3":
                    Data.saveFile(fileName,toDoList);
                    System.exit(0);
                case "4":
                    System.out.println("-".repeat(40));
                    System.out.println("|"+" ".repeat(2)+"to-do-list");
                    System.out.println("-".repeat(40));
                    Collections.sort(toDoList);
                    for (String item : toDoList) {
                        System.out.println("-- "+ item);
                    }
                    System.out.println("-".repeat(40));
                    break;
            }
            System.out.println("Select menu item:");
            choice = in.nextLine();


        }


    }


    private static void displayList(ArrayList<String> toListItems) {
        for (String item : toListItems) {
            System.out.println(item);
        }


    }
}