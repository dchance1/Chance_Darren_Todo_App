import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ToDoList {
    private String title;
    public static final int ASCENDING = 0;
    private ArrayList<ToDoListItem> list = new ArrayList<ToDoListItem>();
    private ArrayList<Integer> itemIds = new ArrayList<Integer>();


    public String listName() {
        return title;
    }

    public void removeId(int id) {
        if (itemIds.size() == 1) {
            itemIds.clear();
        } else {
            //this.itemIds.remove(id);
            this.itemIds.remove(Integer.valueOf(1));
        }

    }

    public void reorder() {
        int num = 0;
        refreshList();
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

    public void add(ToDoListItem item) {
        int listSize = this.list.size();

        // iterate through list and re-sets id's, so they can be in order
        refreshList();
        // sets id to be the next number after the last number in the list then adds item to ToDoList
        item.setId(listSize + 1);
        list.add(item);
    }

    private void refreshList() {
        int i = 0;
        for (ToDoListItem toDoListItem : this.list) {
            i++;
            toDoListItem.setId(i);
        }
    }

    public int delete(int num) {
        int id = 0;
        for (ToDoListItem item : this.list) {
            if (item.getId() == num) {
                id = item.getId();
                this.list.remove(item);
                break;
            }

        }
        //removeId(id);
        return 0;
    }
}
