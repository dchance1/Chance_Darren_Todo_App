public class ToDoListItem implements Comparable<ToDoListItem> {
    private boolean completed = false;
    private String title;
    private String notes;

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
            //System.out.println("greater than");
            return 1;
        } else if ((this.title.compareTo(toDoListItem.getTitle()) < 0)) {
            //System.out.println("less than");

            return -1;
        } else {
            //System.out.println("equals");

            return 0;
        }
    }
}
