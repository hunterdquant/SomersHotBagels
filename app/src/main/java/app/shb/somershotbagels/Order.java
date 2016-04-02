package app.shb.somershotbagels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunter on 4/2/16.
 */
public class Order {
    private String orderName;
    private List<Item> items;

    public Order() {
        this("cart");
    }

    public Order(String orderName) {
        this.orderName = orderName;
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void appendOrder(Order order) {
        items.addAll(order.getItems());
    }

    public List<Item> getItems() {
        return items;
    }

    public String getOrderName() {
        return orderName;
    }

    @Override
    public String toString() {
        String s = "";
        for (Item item : items) {
            s += item.toString();
        }
        return s;
    }
}
