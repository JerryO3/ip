package duke;

import duke.item.Deadline;
import duke.item.Event;
import duke.item.ToDo;
import duke.item.Item;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemList implements Serializable {
    private ArrayList<Item> listOfItems = new ArrayList<Item>();
    private int itemCount = 0;

    public int getItemCount() {
        return itemCount;
    }

    public ArrayList<Item> getList() {
        return this.listOfItems;
    }

    public String addToDo(String[] name) {
        listOfItems.add(itemCount, new ToDo(name));
        itemCount++;
        return listOfItems.get(itemCount-1).addMessage(itemCount);
    }

    public String addEvent(String[] info) throws CustomExceptions {
        listOfItems.add(itemCount, new Event(info));
        itemCount++;
        return listOfItems.get(itemCount-1).addMessage(itemCount);
    }

    public String addDeadline(String[] info) throws CustomExceptions{
        listOfItems.add(itemCount, new Deadline(info));
        itemCount++;
        return listOfItems.get(itemCount-1).addMessage(itemCount);
    }

    public String removeItem(int index) throws CustomExceptions {
        String s = "";
        try {
            itemCount--;
            s = listOfItems.get(index-1).removeMessage(itemCount);
            listOfItems.remove(index-1);
        } catch (IndexOutOfBoundsException e) {
            itemCount++; // reverse decrement in the event of error
            throw new CustomExceptions.noSuchIndexException("Index out of bounds, there is no event with such an index");
        }
        return s;
    }

    @Override
    public String toString() {
        int c = 0;
        String out = "";
        while (c < listOfItems.size()) {
            out += (c+1) + "." + listOfItems.get(c).toString() + "\n     ";
            c++;
        }
        return out.trim();
    }
}