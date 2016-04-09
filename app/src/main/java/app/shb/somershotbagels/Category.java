package app.shb.somershotbagels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunter on 4/2/16.
 */
public class Category {
    private int imageId;
    private String name;
    private List<Item> items;

    public Category(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {return items;}

    public void addItem(Item item){
        if (items == null){
            items = new ArrayList<Item>();
        }
        items.add(item);
    }

    @Override
    public String toString() {
        return name;
    }
}
