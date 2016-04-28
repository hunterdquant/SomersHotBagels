package app.shb.somershotbagels;

import android.content.SharedPreferences;

/**
 * This interface serves for callbacks between fragments,
 *
 * @author Hunter Quant, Robert Miller
 */
public interface OrderTransfer {

    /*
      Lets a fragment get the order.
     */
    Order getOrder();
    /*
      The local storage as prefs.
     */
    SharedPreferences getPrefs();
    /*
      Function to update the cart.
     */
    void updateCart();
    /*
      Function to update favorites.
     */
    void updateFavorites();
}
