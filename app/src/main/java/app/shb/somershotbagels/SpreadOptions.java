package app.shb.somershotbagels;

import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 4/23/2016.
 */
public class SpreadOptions implements Option{
    String optionString;
    Spinner spreadType;


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

    @Override
    public String toString(){
        String s = new String();
        s += "Bagel Type: " + optionString + '\n';
        return s;
    }
}
