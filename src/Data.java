import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Data {
    static int delete (ToDoList toDoList, int num){
        int tempId = 0;
        for (ToDoListItem item: toDoList.getList()){
            if (item.getId() == num){
                tempId = item.getId();
                toDoList.getList().remove(item);
                break;
            }
        }
        // updating list number index to reflect removal of item.
        toDoList.reorder();
        toDoList.removeId(tempId);

        return 0;
    }


     static int saveFile(ToDoList toDoList) {
         String fileName = toDoList.listName()+".txt";
        System.out.println("Saving list to file " + fileName);
        File file = new File(fileName);
        if (file.exists()){
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
        }else {
            try {
                PrintWriter output = new PrintWriter(file);
                for (ToDoListItem item : toDoList.getList()) {
                    output.println(item.getTitle());
                }
                System.out.println("New file created in directory: " + file.getPath());

                output.close();
                System.out.println("File save Successful.");
                return 1;
            } catch (FileNotFoundException e) {
                System.out.println("You have an error: " + e);
                return -1;
            }
        }




     }

}
