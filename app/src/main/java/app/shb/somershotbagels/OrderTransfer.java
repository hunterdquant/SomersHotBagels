package app.shb.somershotbagels;

import android.content.SharedPreferences;

/**
 * Created by hunter on 4/2/16.
 */

public interface OrderTransfer {
    public Order getOrder();
    public SharedPreferences getPrefs();
}
