package app.shb.somershotbagels;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 4/23/2016.
 */
public class BagelOptions implements Option{
    Spinner bagelTypes;
    String optionString;


    public List<String> getBagelList(){
        List<String> b_list = new ArrayList<String>();
        b_list.add("Plain Bagel");
        b_list.add("Poppy Seed Bagel");
        b_list.add("Sesame Seed Bagel");
        b_list.add("Cinnamon Raisin Bagel");
        b_list.add("Everything Bagel");
        b_list.add("Wheat Bagel");
        b_list.add("Wheat Everything Bagel");
        b_list.add("Egg Bagel");
        b_list.add("Egg Everything Bagel");
        b_list.add("Marble Bagel");
        b_list.add("Pumpernickel Bagel");
        b_list.add("Pumpernickel Seasame Bagel");
        b_list.add("7-Grain Bagel");
        b_list.add("Onion Bagel");
        b_list.add("Garlic Bagel");
        b_list.add("Salt Bagel");
        b_list.add("Berry Bagel");
        b_list.add("Baker's Dozen");
        return b_list;
    }


    @Override
    public String toString(){
        String s = new String();
        s += "Bagel Type: " + optionString + '\n';
        return s;
    }
}
