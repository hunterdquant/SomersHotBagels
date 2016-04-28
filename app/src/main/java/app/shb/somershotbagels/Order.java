package app.shb.somershotbagels;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains items in a group.
 *
 * @author Hunter Quant, Robert Miller
 */
public class Order {

    /*
      The name of the order.
     */
    private String orderName;
    /*
      The list of items in a order.
     */
    private List<Item> itemList;

    public Order() {
        this("cart");
    }

    public Order(String orderName) {
        this.orderName = orderName;
        this.itemList = new ArrayList<Item>();
    }

    /**
     * Adds a item to the order.
     *
     * @param item the item to add to the order.
     */
    public void addItem(Item item) {
        itemList.add(item);
    }

    /**
     * Appends a order to this order.
     *
     * @param order the order to be appended.
     */
    public void appendOrder(Order order) {
        itemList.addAll(order.getItems());
    }

    /**
     * Gets the list of items.
     *
     * @return the list of items.
     */
    public List<Item> getItems() {
        return itemList;
    }

    /**
     * @return the name of the order.
     */
    public String getOrderName() {
        return orderName;
    }

    /**
     * Sets the name of the order.
     *
     * @param name the name to set to the order.
     */
    public void setOrderName(String name) {
        orderName = name;
    }

    /**
     * removes a item from the order.
     *
     * @param position the position of the element to remove.
     */
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
