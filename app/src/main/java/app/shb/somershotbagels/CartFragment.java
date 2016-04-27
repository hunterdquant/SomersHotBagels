package app.shb.somershotbagels;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the display and functionality of the Cart tab.
 *
 * @author Hunter Quant, Robert Miller
 */
public class CartFragment extends Fragment {

    /*
      Callback to communicate with the activity.
      */
    OrderTransfer orderTransfer;
    /*
      Reference to the activity's global order.
     */
    private Order order;
    /*
      Cart list view.
     */
    ListView listView;
    /*
      List containing the strings of the items.
     */
    private List<String> itemList;
    /*
      Adapter for the itemList.
     */
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
        // Populate with the list of items in the cart.
        populateItemList();
        arrayAdapter.setNotifyOnChange(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(true);
                builder.setTitle("Would you like to remove " + order.getItems().get(position).getName());
                //builder.setMessage(message);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        order.removeItem(position);
                        orderTransfer.updateCart();
                        Toast.makeText(getActivity(), "Item removed from the cart.", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });



                final AlertDialog dialog = builder.create();
                dialog.show(); //show() should be called before dialog.getButton().


                final Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                LinearLayout.LayoutParams positiveButtonLL = (LinearLayout.LayoutParams) positiveButton.getLayoutParams();
                positiveButtonLL.gravity = Gravity.CENTER;
                positiveButton.setLayoutParams(positiveButtonLL);

                final Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                LinearLayout.LayoutParams negativeButtonLL = (LinearLayout.LayoutParams) negativeButton.getLayoutParams();
                negativeButtonLL.gravity = Gravity.CENTER;
                negativeButton.setLayoutParams(negativeButtonLL);
            }
        });

        listView.setAdapter(arrayAdapter);

        Button favorite = (Button) root.findViewById(R.id.favoriteButton);
        // Set alert dialog to prompt order save.
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Name your favorite order.");

                final EditText input = new EditText(getActivity());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences.Editor prefsEditor = orderTransfer.getPrefs().edit();
                        Gson gson = new Gson();
                        order.setOrderName(input.getText().toString());
                        String json = gson.toJson(order);
                        prefsEditor.putString(input.getText().toString(), json);
                        prefsEditor.commit();
                        orderTransfer.updateFavorites();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
        Button checkout = (Button) root.findViewById(R.id.checkoutButton);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), CheckoutActivity.class);
                Gson gson = new Gson();
                intent.putExtra("ORDER", gson.toJson(order));
                startActivity(intent);
            }
        });

        return root;
    }

    /**
     * Populates the item list with the contents of the order.
     */
    private void populateItemList() {
        itemList.clear();
        for (Item item : order.getItems()) {
            itemList.add(item.toString());
        }
    }

    /**
     * Tell the adapter to refresh.
     */
    public void updateList() {
        populateItemList();
        arrayAdapter.notifyDataSetChanged();
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
