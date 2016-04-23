package app.shb.somershotbagels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 4/23/2016.
 */
public class OptionsSpreads {
    Spinner spinner;
    String optionString;

    public void display(LinearLayout ll, Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View element = inflater.inflate(R.layout.spinner, null);
        spinner = (Spinner) element.findViewById(R.id.spinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,getList());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setPrompt("Spreads");
        TextView text = new TextView(context);
        text.setText("Spreads");
        text.setTextSize(30);
        ll.addView(text);
        ll.addView(spinner);
    }

    public List<String> getList(){
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
        optionString = spinner.getSelectedItem().toString();
        String s = new String();
        s += "Spread: " + optionString;
        return s;
    }
}
