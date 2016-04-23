package app.shb.somershotbagels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunter on 4/2/16.
 */
public class Order {
    private String orderName;
    private List<Item> itemList;

    public Order() {
        this("cart");
    }

    public Order(String orderName) {
        this.orderName = orderName;
        this.itemList = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void appendOrder(Order order) {
        itemList.addAll(order.getItems());
    }

    public List<Item> getItems() {
        return itemList;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String name) {
        orderName = name;
    }

    public void removeItem(int position) {
        itemList.remove(position);
    }

    @Override
    public String toString() {
        String s = "";
        for (Item item : itemList) {
            s += item.toString() + "\n";
        }
        return s;
    }
}
