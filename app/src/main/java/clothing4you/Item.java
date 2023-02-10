package clothing4you;

import javax.swing.*;
import java.awt.*;

public class Item {
    private String name;
    private String category;
    private String size;
    private double price;
    private Image image;

    public Item(String name, String category,String size, double price, Image image) {
        this.name = name;
        this.category = category;
        this.size = size;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
