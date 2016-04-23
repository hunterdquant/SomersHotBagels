package app.shb.somershotbagels;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

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
        this.name = "item";
        this.optionList = new ArrayList<Option>();
    }

    public Item(String name) {
        this.name = name;
        this.optionList = new ArrayList<Option>();
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
