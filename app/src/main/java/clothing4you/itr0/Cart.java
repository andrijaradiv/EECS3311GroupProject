package itr0;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;
    private double tax;
    private double totalPrice;

    public Cart(){
        items = new ArrayList<>();
        tax = 0.13;
        totalPrice = 0.0;
    }

    public void addItem(Item item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return totalPrice + (totalPrice * tax);
    }
}

