package app.shb.somershotbagels;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * This fragment represents a container for fragment transactions.
 *
 * @author Hunter Quant, Robert Miller
 */
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Replace initially withe the CategoryListFragment.
        View root = inflater.inflate(R.layout.home_tab_fragment, container, false);
        CategoryListFragment clf = new CategoryListFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.homeContainer, clf);
        ft.commit();
        return root;
    }
}