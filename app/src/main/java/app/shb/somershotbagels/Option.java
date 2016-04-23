package app.shb.somershotbagels;


import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

/**
 * Created by hunter on 4/2/16.
 */
public class Option {

    public String type;
    public String optionState;

    public Option() {
        type = "";
        optionState = "";
    }

    public Option(String type) {
        this.type = type;
    }

    public void display(LinearLayout itemContainer, Context context) {

    };

    @Override
    public String toString() {
        return type + ": " + optionState;
    }

    static class OptionInfo {

    }
}
