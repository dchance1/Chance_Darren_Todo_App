import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Data {


    static int saveFile(ToDoList toDoList) {
        String fileName = toDoList.listName() + ".txt";
        System.out.println("Saving list to file " + fileName);
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("file exists");
            try {
                PrintWriter output = new PrintWriter(file);
                for (ToDoListItem item : toDoList.getList()) {
                    output.println(item.getTitle());
                }
                output.close();
                System.out.println("File save Successful.");
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


                output.close();
                Path path = Paths.get(file.getName());
                System.out.println("New file created in directory: " + path.toAbsolutePath());
                System.out.println("File save Successful.");
                return 1;
            } catch (FileNotFoundException e) {
                System.out.println("You have an error: " + e);
                return -1;
            }
        }


    }

}
