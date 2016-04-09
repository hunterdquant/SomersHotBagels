package app.shb.somershotbagels;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hunter on 3/25/16.
 */
public class FragmentPagerAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;
    CartFragment cartTab;
    public FragmentPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);;
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FavoriteFragment histTab = new FavoriteFragment();
                return histTab;
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

    public CartFragment getCart() {
        return cartTab;
    }
}
