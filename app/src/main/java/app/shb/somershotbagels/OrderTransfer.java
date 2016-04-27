package app.shb.somershotbagels;

import android.content.SharedPreferences;

/**
 * Created by hunter on 4/2/16.
 */

public interface OrderTransfer {
    Order getOrder();
    SharedPreferences getPrefs();
    void updateCart();
    void updateFavorites();
}
