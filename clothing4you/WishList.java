package clothing4you;

import java.util.ArrayList;

public class WishList {
    private ArrayList<Item> items;

    public WishList() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
