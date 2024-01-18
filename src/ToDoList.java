import java.util.ArrayList;
import java.util.Collections;

public class ToDoList {
    private String title;
    public static final int ASCENDING = 0;
    private ArrayList<ToDoListItem> list = new ArrayList<ToDoListItem>();

    public String listName() {
        return title;
    }

    public void sortByTitle(final int sortOrder) {
        Collections.sort(this.list, Collections.reverseOrder());
    }

    public void sortByTitle() {
        Collections.sort(this.list, Collections.reverseOrder());
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ToDoListItem> getList() {
        return list;
    }

    public void setList(ArrayList<ToDoListItem> list) {
        this.list = list;
    }

    public ToDoList(String title) {
        this.title = title;
    }

    public ToDoList(String title, ArrayList<ToDoListItem> stringArrayList) {
        this.title = title;
        this.list = stringArrayList;

    }

    public void add(ToDoListItem item) {
        list.add(item);

    }
}
