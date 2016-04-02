package app.shb.somershotbagels;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunter on 3/25/16.
 */
public class CartFragment extends Fragment {

    OrderTransfer orderTransfer;
    private Order order;
    ListView listView;
    private List<String> itemList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.cart_tab_fragment, container, false);
        listView = (ListView) root.findViewById(R.id.cartList);
        itemList = new ArrayList<String>();

        arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list,
                itemList );
        populateItemList();
        arrayAdapter.setNotifyOnChange(true);
        listView.setAdapter(arrayAdapter);
        return root;
    }
    private void populateItemList() {
        for (Item item : order.getItems()) {
            itemList.add(item.toString());
        }
    }

    public void updateList() {
        populateItemList();
        arrayAdapter.notifyDataSetChanged();
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
