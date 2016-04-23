package app.shb.somershotbagels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 4/23/2016.
 */
public class BagelOptions implements Option{
    Spinner spinner;
    String optionString;

    @Override
    public void display(LinearLayout ll, Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View element = inflater.inflate(R.layout.spinner, null);
        spinner = (Spinner) element.findViewById(R.id.spinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,getList());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        ll.addView(spinner);
    }

    public List<String> getList(){
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
