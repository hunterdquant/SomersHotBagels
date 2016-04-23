package app.shb.somershotbagels;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunter on 4/23/16.
 */
public class ItemEditFragment extends Fragment{

    OrderTransfer orderTransfer;
    private Order order;
    private Item item;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ((AppCompatActivity)getActivity()).getSupportActionBar();
        Bundle bundle = this.getArguments();
        final int listIndex = bundle.getInt("LIST_INDEX");
        final int itemIndex = bundle.getInt("ITEM_INDEX");
        item = MenuRetrieval.retreveCategory(MenuRetrieval.CATEGORY_NAMES[listIndex]).get(itemIndex);


        View root = inflater.inflate(R.layout.list_items_fragment, container, false);
        order = orderTransfer.getOrder();

        return root;
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
