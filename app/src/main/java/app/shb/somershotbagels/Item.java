package app.shb.somershotbagels;

import android.content.Context;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunter on 4/2/16.
 */
public class Item {
    private String name;
    private String description;
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



    public void addOption(Option option) {
        optionList.add(option);
    }

    public String getName() {
        return this.name;
    }

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

    public void addOptionsToView(LinearLayout itemContainer, Context context) {
        for (Option option : optionList) {
            Log.d("test", option.toString());
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
