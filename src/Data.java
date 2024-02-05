import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Data {

    /**
     * Method: loadFile
     * <p>
     * This method loads .txt file to a {@code ToDoList} and assigns each line of text to a new  {@code ToDoListItem}.
     *
     * @param toDoList an {@code Object} of ToDoList
     * @return the value {@code 1} if the file is saved successfully; unsuccessfully{@code -1}
     */
    static int loadFile(ToDoList toDoList) {

        File file = new File("To-do list.txt");
        Path path = Paths.get(file.getName());
        if (file.exists()) {
            System.out.println("Loading previously saved file from directory: " + path.toAbsolutePath());
            Scanner scan = null;
            try {
                scan = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("You have an error" + e);
                return -1;
            }
            while (scan.hasNextLine()) {
                toDoList.add(new ToDoListItem(scan.nextLine()));
            }
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Method: saveFile
     * <p>
     * This method saves a {@code ToDoList} object to a .txt file.
     *
     * @param toDoList an {@code Object} of ToDoList
     * @return the value {@code 1} if the file is saved successfully; unsuccessfully{@code -1}
     */
    static int saveFile(ToDoList toDoList) {
        String fileName = toDoList.listName() + ".txt";
        System.out.println("Saving list to file " + fileName);
        File file = new File(fileName);
        if (file.exists()) {
            try {
                PrintWriter output = new PrintWriter(file);
                for (ToDoListItem item : toDoList.getList()) {
                    output.println(item.getTitle());
                }
                Path path = Paths.get(file.getName());
                System.out.println("File saved to directory: " + path.toAbsolutePath());
                output.close();
                return 1;
            } catch (FileNotFoundException e) {
                System.out.println("You have an error: " + e);
                return -1;
            }
        } else {
            try {
                PrintWriter output = new PrintWriter(file);
                for (ToDoListItem item : toDoList.getList()) {
                    output.println(item.getTitle());
                }
                Path path = Paths.get(file.getName());
                System.out.println("New file created in directory: " + path.toAbsolutePath());
                System.out.println("File save Successful.");
                output.close();
                return 1;
            } catch (FileNotFoundException e) {
                System.out.println("You have an error: " + e);
                return -1;
            }
        }
    }
}
