import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Darren Chance<br>
 * CEN 4025C - Software Development 2<br>
 * January 19, 2024<br>
 * ToDoList.java<br>
 * <p>
 * <p>
 * The class {@code ToDoList} creates a to-do list and can store {@code ToDoListItem Objects}. This object contains
 * functions for manipulation of the list items and data
 */
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


    public void sortByTitle(final int sortOrder) {
        Collections.sort(this.list, Collections.reverseOrder());
    }

    /**
     * Method: sortByTitle
     * <p>
     * This method sorts the {@code ToDoList} items by title
     */
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

    /**
     * Method: add
     * <p>
     * This method adds a {@code ToDoListItem Object}  to a {@code ToDoList Object}
     *
     * @param toDoListItem an {@code Object} of ToDoList
     * @return the value {@code 1} if the file is saved successfully; unsuccessfully{@code -1}
     */
    public void add(ToDoListItem toDoListItem) {
        int listSize = this.list.size();

        // iterate through list and re-sets id's, so they can be in order
        refreshList();
        // sets id to be the next number after the last number in the list then adds item to ToDoList
        toDoListItem.setId(listSize + 1);
        list.add(toDoListItem);
        System.out.println("[" + toDoListItem.getTitle() + "] added to " + "[" + this.title + "]" + "To do list.");
    }

    /**
     * Method: refreshList
     * <p>
     * This method reassigns each list Item id in order. This is useful for when an item is removed or added.
     */
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
     * This method deletes the list item from the to do list by it's id.
     *
     * @param id a ToDoListItem id.
     * @return pass or fail
     */
    public int delete(int id) {
        boolean itemExists = false;

        for (ToDoListItem item : this.list) {
            if (item.getId() == id) {
                itemExists = true;
                id = item.getId();
                this.list.remove(item);
                System.out.println("[" + item.getTitle() + "] deleted.");
                refreshList();
                break;
            }
        }
        if (!itemExists) {
            System.out.println("Item with id: [" + id + "]" + " not found.");
        }
        return 0;
    }
}
