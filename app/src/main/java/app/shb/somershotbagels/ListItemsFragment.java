package app.shb.somershotbagels;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunter on 4/9/16.
 */
    public class ListItemsFragment extends Fragment {

    OrderTransfer orderTransfer;
    private Order order;
    private List<Item> itemList;
    private List<String> itemNames;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ((AppCompatActivity)getActivity()).getSupportActionBar();
        Bundle bundle = this.getArguments();
        int listIndex = bundle.getInt("LIST_INDEX");

        View root = inflater.inflate(R.layout.list_items_fragment, container, false);

        itemList = MenuRetrieval.retreveCategory(MenuRetrieval.CATEGORY_NAMES[listIndex]);
        order = orderTransfer.getOrder();

        ListView listView = (ListView) root.findViewById(R.id.itemListActivity);
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

    private void populateItemNames() {
        for (Item item : itemList) {
            itemNames.add(item.getName());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            orderTransfer = (OrderTransfer) context;
            order = ((OrderTransfer) context).getOrder();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }
    }
}
