import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ToDoList {
    public String getTitle() {
        return title;
    }

    private String title;
    public static final int ASCENDING = 0;
    private ArrayList<ToDoListItem> list = new ArrayList<ToDoListItem>();

    public String listName() {
        return title;
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
        System.out.println("[" + item.getTitle() + "] added to " + "[" + this.title + "]"+ "To do list.");
    }

    private void refreshList() {
        int i = 0;
        for (ToDoListItem toDoListItem : this.list) {
            i++;
            toDoListItem.setId(i);
        }
    }

    /**
     * Method Name: delete
     * <p>
     * This method deletes a new book from the to do list using by it's id.
     *
     * @param id ToDoListItem id.
     * @return pass or fail
     */
    public int delete(int id) {

        for (ToDoListItem item : this.list) {
            if (item.getId() == id) {
                id = item.getId();
                this.list.remove(item);
                break;
            }

        }
        refreshList();
        //removeId(id);
        return 0;
    }
}
