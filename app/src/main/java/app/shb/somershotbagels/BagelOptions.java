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
public class BagelOptions {
    TextView description;
    Spinner quantity;
    Spinner bagelTypes;
    Spinner spreads;
    ToggleButton toasted;
    CheckBox eatIn;
    Button saveItem;


    int quantityChoosen;
    String bagelChoosen;
    String spreadChoosen;
    String toasty;
    String hereOrTogo;

    public List<Integer> getQuantityList(){
        List<Integer> q_list = new ArrayList<Integer>();
        for (int i=1; i<25; i++){
            q_list.add(i);
        }
        return q_list;
    }
    public void init(){
        toasted.setTextOn("Toasted");
        toasted.setTextOff("Untoasted");
        eatIn.setText("Eat In");
    }
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
    public List<String> getMiniBagelList(){
        List<String> b_list = new ArrayList<String>();
        b_list.add("Everything Mini-Bagel");
        b_list.add("Plain Mini-Bagel");
        b_list.add("Poppy Seed Mini-Bagel");
        b_list.add("Sesame Seed Mini-Bagel");
        b_list.add ("Cinnamon Raisin Mini-Bagel");
        return b_list;
    }
    public List<String> getSpreadList(){
        List<String> s_list = new ArrayList<String>();
        s_list.add("Plain Cream Cheese");
        s_list.add("Vegetable Cream Cheese");
        s_list.add("Scallion Cream Cheese");
        s_list.add("Cinnamon Raisin Cream Cheese");
        s_list.add("Vanilla Raisin Cream Cheese");
        s_list.add("Olive Pimiento Cream Cheese");
        s_list.add("Strawberry Cream Cheese");
        s_list.add("Jalapeno Cream Cheese");
        s_list.add("Nova Cream Cheese");
        s_list.add("Reduced-Fat Plain Cream Cheese");
        s_list.add("Reduced-Fat Vegetable Cream Cheese");
        s_list.add("Butter");
        s_list.add("Peanut Butter");
        s_list.add("Strawberry Jelly");
        s_list.add("Grape Jelly");
        return s_list;
    }

    public void saveChoices(){
        quantityChoosen = Integer.parseInt(quantity.getSelectedItem().toString());
        bagelChoosen = bagelTypes.getSelectedItem().toString();
        spreadChoosen = spreads.getSelectedItem().toString();
        toasty = (toasted.isChecked() ? toasted.getTextOn() : toasted.getTextOff()).toString();

    }

    @Override
    public String toString(){
        String s = new String("");
        s += "Quantity: " + quantityChoosen + '\n';
        s += bagelChoosen + '\n';
        s += spreadChoosen + '\n';
        s += toasty + '\n';
        s += hereOrTogo;
        return s;
    }
}
