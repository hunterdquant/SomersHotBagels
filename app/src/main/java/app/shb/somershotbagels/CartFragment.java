package app.shb.somershotbagels;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(getActivity(), listView);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.cart_popup, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getTitle().equals("Remove")) {
                            order.removeItem(position);
                            orderTransfer.updateCart();
                            Toast.makeText(getActivity(), "Item removed from the cart.", Toast.LENGTH_LONG).show();
                        }
                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });

        listView.setAdapter(arrayAdapter);

        Button favorite = (Button) root.findViewById(R.id.favoriteButton);
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

        return root;
    }
    private void populateItemList() {
        itemList.clear();
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
