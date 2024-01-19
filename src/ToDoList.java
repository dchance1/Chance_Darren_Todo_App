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
        if(itemIds.size()==1){
            itemIds.clear();
        }else {
            //this.itemIds.remove(id);
            this.itemIds.remove(Integer.valueOf(1));
        }

    }

    public void reorder() {
        int num = 0;
        for (ToDoListItem item : this.list) {
            num++;
            item.setId(num);
        }
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
        int listSize = this.itemIds.size();
        int tempNum = 0;
        HashSet<Integer> tempSet = new HashSet<Integer>(itemIds);
        int i = 0;
        if (!itemIds.contains(listSize + 1)) {
            item.setId(listSize + 1);
            tempNum = listSize + 1;

        } else {

            for (ToDoListItem listItem : this.list) {
                i++;
                listItem.setId(i);
            }
            tempNum = i + 1;
            item.setId(tempNum);

        }

        this.itemIds.add(tempNum);
        list.add(item);


    }
}
