package app.shb.somershotbagels;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles the display and functionality of the list items fragment.
 *
 * @author Hunter Quant, Robert Miller
 */
public class ListItemsFragment extends Fragment {

    /*
      THe list view.
     */
    ListView listView;
    /*
      The list of items in a category.
     */
    private List<Item> itemList;
    /*
      The list of item names.
     */
    private List<String> itemNames;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ((AppCompatActivity)getActivity()).getSupportActionBar();
        Bundle bundle = this.getArguments();
        final int listIndex = bundle.getInt("LIST_INDEX");

        View root = inflater.inflate(R.layout.list_items_fragment, container, false);

        itemList = MenuRetrieval.retreveCategory(MenuRetrieval.CATEGORY_NAMES[listIndex]);

        listView = (ListView) root.findViewById(R.id.itemListActivity);

        // Fragment transaction on item click with the appropriate item.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("LIST_INDEX", listIndex);
                bundle.putInt("ITEM_INDEX", position);

                ItemEditFragment ief = new ItemEditFragment();
                ief.setArguments(bundle);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.homeContainer, ief);
                ft.commit();
            }
        });
        itemNames = new ArrayList<String>();
        populateItemNames();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list,
                itemNames);
        arrayAdapter.setNotifyOnChange(true);

        listView.setAdapter(arrayAdapter);

        return root;
    }

    /**
     * Populates the item name list with the item names.
     */
    private void populateItemNames() {
        for (Item item : itemList) {
            itemNames.add(item.getName());
        }
    }
}
