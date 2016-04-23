package app.shb.somershotbagels;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

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
        Log.d("test", listIndex + "");
        final int itemIndex = bundle.getInt("ITEM_INDEX");
        Log.d("test", itemIndex + "");
        item = MenuRetrieval.retreveCategory(MenuRetrieval.CATEGORY_NAMES[listIndex]).get(itemIndex);


        View root = inflater.inflate(R.layout.item_edit_fragment, container, false);
        order = orderTransfer.getOrder();
        LinearLayout itemContainer = (LinearLayout) root.findViewById(R.id.itemEditContainer);
        item.addItemDetails(itemContainer, getContext());
        item.addOptionsToView(itemContainer, getContext());
        View element = inflater.inflate(R.layout.add_to_cart_button, null);
        Button addToCart = (Button) element.findViewById(R.id.addToCart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.addItem(item);
                orderTransfer.updateCart();
            }
        });
        itemContainer.addView(addToCart);
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
