package app.shb.somershotbagels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a item.
 *
 * @author Hunter Quant, Robert Miller
 */
public class Item {

    /*
      The item name.
     */
    private String name;
    /*
      The item description.
     */
    private String description;
    /*
      A list of options for the item.
     */
    private List<Option> optionList;

    public Item() {
        this.name = "";
        this.optionList = new ArrayList<Option>();
        this.description = "";
    }

    public Item(String name) {
        this.name = name;
        this.optionList = new ArrayList<Option>();
        this.description = "";
    }

    public Item(String name, String description){
        this.name = name;
        this.optionList = new ArrayList<Option>();
        this.description = description;
    }

    /**
     * Adds a option to a item.
     *
     * @param option the option to be added to the item.
     */
    public void addOption(Option option) {
        optionList.add(option);
    }

    /**
     * @return the name of the item.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the views for name and description.
     *
     * @param itemContainer the linear layout to add to.
     * @param context
     */
    public void addItemDetails(LinearLayout itemContainer, Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View element = inflater.inflate(R.layout.item_name, null);
        TextView itemName = (TextView) element.findViewById(R.id.itemName);
        element = inflater.inflate(R.layout.item_description, null);
        TextView itemDescription = (TextView) element.findViewById(R.id.itemDescription);
        itemName.setText(name);
        itemDescription.setText(description);
        itemContainer.addView(itemName);
        itemContainer.addView(itemDescription);
    }

    /**
     * Adds all options to the linear layout..
     *
     * @param itemContainer the item container.
     * @param context
     */
    public void addOptionsToView(LinearLayout itemContainer, Context context) {
        for (Option option : optionList) {
            option.display(itemContainer, context);
        }
    }

    @Override
    public String toString() {
        String s = this.name;

        for (Option o : optionList) {
            s += "\n\t\t" + o.toString();
        }
        return s;
    }
}
