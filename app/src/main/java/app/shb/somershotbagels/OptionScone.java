package app.shb.somershotbagels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 4/23/2016.
 */
public class OptionScone  {
    Spinner spinner;
    String optionString;

    public void display(LinearLayout ll, Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View element = inflater.inflate(R.layout.spinner, null);
        spinner = (Spinner) element.findViewById(R.id.spinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,getList());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setPrompt("Scones");
        TextView text = new TextView(context);
        text.setText("Scone Type");
        text.setTextSize(30);
        ll.addView(text);
        ll.addView(spinner);
    }

    public List<String> getList(){
        List <String> m_list = new ArrayList<String>();
        m_list.add("Blueberry Scone");
        m_list.add("Chocolate Chip Scone");
        m_list.add("Cranberry Scone");
        m_list.add("Raisin Scone");
        return m_list;
    }

    @Override
    public String toString(){
        optionString = spinner.getSelectedItem().toString();
        String s = new String();
        s = "Scone Type: " + optionString;
        return s;
    }
}

