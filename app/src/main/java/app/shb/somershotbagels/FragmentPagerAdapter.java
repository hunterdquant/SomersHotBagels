package app.shb.somershotbagels;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Handles the display and functionality of the favorite fragment.
 *
 * @author Hunter Quant, Robert Miller
 */
public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    /*
      The number of tabs.
     */
    int numOfTabs;
    /*
      A reference to the cart tab fragment.
     */
    CartFragment cartTab;
    /*
      A reference to the favorite fragment.
     */
    FavoriteFragment favTab;

    public FragmentPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);;
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                favTab = new FavoriteFragment();
                return favTab;
            case 1:
                HomeFragment homeTab = new HomeFragment();
                return homeTab;
            case 2:
                cartTab = new CartFragment();
                return cartTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    /**
     * @return The cart fragment.
     */
    public CartFragment getCart() {
        return cartTab;
    }

    /**
     * @return The favorite fragment.
     */
    public FavoriteFragment getFav() {
        return favTab;
    }
}
