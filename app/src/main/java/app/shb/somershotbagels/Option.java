package app.shb.somershotbagels;


import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

/**
 * Created by hunter on 4/2/16.
 */
public interface Option {

    public void display(LinearLayout itemContainer, Context context);

    @Override
    public String toString();
}
