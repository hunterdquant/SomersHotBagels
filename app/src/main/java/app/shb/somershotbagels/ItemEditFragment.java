package app.shb.somershotbagels;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Handles the display and functionality of the item edit fragment.
 *
 * @author Hunter Quant, Robert Miller
 */
public class ItemEditFragment extends Fragment{

    /*
      Callback to communicate with the activity.
      */
    OrderTransfer orderTransfer;
    /*
      Reference to the activity's global order.
     */
    private Order order;
    /*
      The item being edited.
     */
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

        // Add the item to cart with its modified options.
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.addItem(item);
                orderTransfer.updateCart();
                Toast.makeText(getActivity(), "Item added to the cart.", Toast.LENGTH_SHORT).show();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.popBackStack();
            }
        });
        itemContainer.addView(addToCart);
        return root;
    }

    /**
     * Sets the order on activity attachment
     *
     * @param context
     */
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
