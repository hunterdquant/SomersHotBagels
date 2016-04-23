package app.shb.somershotbagels;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by hunter on 4/2/16.
 */
public class Option {

    public String name;
    public String viewType;
    public String optionState;

    public Option() {
        viewType = "";
        optionState = "";
    }

    public Option(String name) {
        this.name = name;
        viewType = OptionInfo.getType(name);
    }

    public void display(LinearLayout itemContainer, Context context) {
        switch (viewType) {
            case "spinner":
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View element = inflater.inflate(R.layout.spinner, null);
                final Spinner spinner = (Spinner) element.findViewById(R.id.spinner);
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, getNameList(name));
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
                spinner.setPrompt(name);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                        optionState = spinner.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parentView) {

                    }

                });
                TextView text = new TextView(context);
                text.setText(name);
                text.setTextSize(30);
                itemContainer.addView(text);
                itemContainer.addView(spinner);
                break;
        }
    };

    @Override
    public String toString() {
        return name + ": " + optionState;
    }

    static class OptionInfo {
        public static String getType(String name) {

        }
        public static String getNameList(String name) {

        }
    }
}
