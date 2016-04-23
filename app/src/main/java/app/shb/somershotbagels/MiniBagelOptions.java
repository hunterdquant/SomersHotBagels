package app.shb.somershotbagels;

import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 4/23/2016.
 */
public class MiniBagelOptions implements Option{
    String optionString;
    Spinner miniBagelType;

    public List<String> getMiniBagelList(){
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
