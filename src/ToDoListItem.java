/**
 * Darren Chance<br>
 * CEN 4025C - Software Development 2<br>
 * January 19, 2024<br>
 * ToDoListItem.java<br>
 * <p>
 * <p>
 * The class {@code ToDoListItem} creates an individual to-do list item. A to-do - list item has attributes such as
 * {@code title, notes, completed, id} for added functionality and organization. This Object can be sorted if placed
 * into an {@code ArrayList<E>} using the {@code Collections class}.
 */
public class ToDoListItem implements Comparable<ToDoListItem> {
    private boolean completed = false;
    private String title;
    private String notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public ToDoListItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public int compareTo(ToDoListItem toDoListItem) {
        if (this.title.compareTo(toDoListItem.getTitle()) > 0) {
            return 1;
        } else if ((this.title.compareTo(toDoListItem.getTitle()) < 0)) {
            return -1;
        } else {
            return 0;
        }
    }
}
