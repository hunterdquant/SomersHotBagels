package app.shb.somershotbagels;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        switch (viewType) {
            case "spinner": {
                Log.d("test", name);
                Log.d("test", viewType);
                Log.d("test", OptionInfo.getNameList(name).toString());
                View element = inflater.inflate(R.layout.spinner, null);
                final Spinner spinner = (Spinner) element.findViewById(R.id.spinner);
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, OptionInfo.getNameList(name));
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
            case "check": {
                View element = inflater.inflate(R.layout.check_box, null);
                final CheckBox checkbox = (CheckBox) element.findViewById(R.id.checkbox);
                checkbox.setText(name);
                checkbox.setTextSize(30);
                checkbox.setChecked(false);
                optionState = "No";
                checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (checkbox.isChecked()){
                            optionState = "Yes";
                        }else
                            optionState = "No";
                    }
                });
                itemContainer.addView(checkbox);
                break;
            }
            case "radio": {
                final RadioGroup radiogroup = new RadioGroup(context);
                List<String> radioText = OptionInfo.getNameList(name);
                for (int i = 0; i < radioText.size(); i++){
                    RadioButton radiobutton = new RadioButton(context);
                    radiobutton.setText(radioText.get(i));
                    radiogroup.addView(radiobutton);
                    radiobutton.setChecked(true);
                }
                radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                    @Override
                    public void onCheckedChanged(RadioGroup group, int id){
                        View radioButton = radiogroup.findViewById(id);
                        int idx = radiogroup.indexOfChild(radioButton);
                        RadioButton r = (RadioButton)  radiogroup.getChildAt(idx);
                        optionState = r.getText().toString();
            }
        });
        itemContainer.addView(radiogroup);
                break;
            }
            default:
        }
    };

    @Override
    public String toString() {
        return name + ": " + optionState;
    }

    static class OptionInfo {
        public static String getType(String name) {
            switch(name){
                case "Bagel":
                    return "spinner";
                case "Mini-Bagel":
                    return "spinner";
                case "Scone":
                    return "spinner";
                case "Muffin":
                    return "spinner";
                case "Spread":
                    return "spinner";
                case "Coffee":
                    return "spinner";
                case "Quantity":
                    return "spinner";
                case "To-go":
                    return  "check";
                case "Toasted":
                    return "check";
                case "Size":
                    return "radio";
                default:
                    return "";
            }

        }
        public static List<String> getNameList(String name) {
            List<String> popList = new ArrayList<String>();
            switch(name){
                case "Bagel":
                    popList.add("Plain Bagel");
                    popList.add("Poppy Seed Bagel");
                    popList.add("Sesame Seed Bagel");
                    popList.add("Cinnamon Raisin Bagel");
                    popList.add("Everything Bagel");
                    popList.add("Wheat Bagel");
                    popList.add("Wheat Everything Bagel");
                    popList.add("Egg Bagel");
                    popList.add("Egg Everything Bagel");
                    popList.add("Marble Bagel");
                    popList.add("Pumpernickel Bagel");
                    popList.add("Pumpernickel Seasame Bagel");
                    popList.add("7-Grain Bagel");
                    popList.add("Onion Bagel");
                    popList.add("Garlic Bagel");
                    popList.add("Salt Bagel");
                    popList.add("Berry Bagel");
                    popList.add("Baker's Dozen");
                    return popList;
                case "Mini-Bagel":
                    popList.add("Plain Mini-Bagel");
                    popList.add("Everything Mini-Bagel");
                    popList.add("Poppy Seed Mini-Bagel");
                    popList.add("Sesame Seed Mini-Bagel");
                    popList.add ("Cinnamon Raisin Mini-Bagel");
                    return popList;
                case "Spread":
                    popList.add("None");
                    popList.add("Plain Cream Cheese");
                    popList.add("Butter");
                    popList.add("Peanut Butter");
                    popList.add("Vegetable Cream Cheese");
                    popList.add("Scallion Cream Cheese");
                    popList.add("Cinnamon Raisin Cream Cheese");
                    popList.add("Vanilla Raisin Cream Cheese");
                    popList.add("Olive Pimiento Cream Cheese");
                    popList.add("Strawberry Cream Cheese");
                    popList.add("Jalapeno Cream Cheese");
                    popList.add("Nova Cream Cheese");
                    popList.add("Reduced-Fat Plain Cream Cheese");
                    popList.add("Reduced-Fat Vegetable Cream Cheese");
                    popList.add("Strawberry Jelly");
                    popList.add("Grape Jelly");
                    return popList;
                case "Quantity":
                    for (Integer i = 1; i < 26; i++){
                        popList.add(i.toString());
                    }
                    return popList;
                case "Scone":
                    popList.add("Blueberry Scone");
                    popList.add("Chocolate Chip Scone");
                    popList.add("Cranberry Scone");
                    popList.add("Raisin Scone");
                    return popList;
                case "Muffin":
                    popList.add("Blueberry Muffin");
                    popList.add("Blueberry Fat-Free Muffin");
                    popList.add("Corn Muffin");
                    popList.add("Chocolate Chip Muffin");
                    popList.add("Banana Nut Muffin");
                    popList.add("Bran Muffin");
                    popList.add("Pumpkin Spice Muffin");
                    popList.add("Carrot Muffin");
                    return popList;
                case "Coffee":
                case "Iced Coffee":
                    popList.add("Regular");
                    popList.add("French Vanilla");
                    popList.add("Hazelnut");
                    popList.add("Raspberry Chocolate");
                    return popList;
                case "Decaf":
                    popList.add("Plain");
                    popList.add("Hazelnut");
                    return popList;
                case "Dressing":
                    popList.add("None");
                    popList.add("Bleu Cheese");
                    popList.add("Ranch");
                    popList.add("Honey Mustard");
                    popList.add("Caesar");
                    popList.add("Thousand Islands");
                    popList.add("Creamy Italian");
                    popList.add("Italian");
                    popList.add("Balsamic Vinaigrette");
                    popList.add("Honey Asian");
                    popList.add("Russian");
                    popList.add("Horseradish Sauce");
                    popList.add("Lite Raspberry");
                    popList.add("Red Wine Vinaigrette");
                    popList.add("Spicy Chipotle Mayo");
                    popList.add("Spicy Mustard");
                    popList.add("Deli Mustard");
                    popList.add("Yellow Mustard");
                    return popList;
                case "Toasted":
                    popList.add("Toasted");
                    return popList;
                case "To-go":
                    popList.add("To-go");
                    return popList;
                case "Size":
                    popList.add("Small");
                    popList.add("Large");
                    return popList;
            }
            return null;
        }
    }
}
