package app.shb.somershotbagels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 4/23/2016.
 */
public class MiniBagelOptions implements Option{
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
        b_list.add("Everything Mini-Bagel");
        b_list.add("Plain Mini-Bagel");
        b_list.add("Poppy Seed Mini-Bagel");
        b_list.add("Sesame Seed Mini-Bagel");
        b_list.add ("Cinnamon Raisin Mini-Bagel");
        return b_list;
    }

    @Override
    public String toString(){
        String s = new String();
        s += "Mini Bagel Type: " + optionString + '\n';
        return s;
    }
}
