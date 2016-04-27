package app.shb.somershotbagels;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hunter on 3/25/16.
 */
public class FavoriteFragment extends Fragment {
    OrderTransfer orderTransfer;
    private Order order;
    private List<Order> orderList;
    private List<String> orderNames;
    private ArrayAdapter<String> arrayAdapter;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        orderList = new ArrayList<Order>();

        final SharedPreferences prefs = orderTransfer.getPrefs();
        Map<String,?> keys = prefs.getAll();
        Gson gson = new Gson();

        for(String key : keys.keySet()) {
            String json = prefs.getString(key, "");
            try {
                Order obj = gson.fromJson(json, Order.class);
                orderList.add(obj);
            } catch (ClassCastException cce) {
            }
        }

        orderNames = new ArrayList<String>();
        loadOrderNameList();

        arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list,
                orderNames );

        View root = inflater.inflate(R.layout.favorite_tab_fragment, container, false);

        listView = (ListView) root.findViewById(R.id.historyList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(true);
                builder.setTitle(orderList.get(position).getOrderName());

                builder.setPositiveButton("Add to cart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        order.appendOrder(orderList.get(position));
                        orderTransfer.updateCart();
                        Toast.makeText(getActivity(), "The selected order has been added to the cart.", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("Remove", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final SharedPreferences.Editor editor = prefs.edit();
                        if (prefs.contains(orderNames.get(position))) {
                            editor.remove(orderNames.get(position));
                            editor.commit();
                        }
                        orderList.remove(position);
                        orderNames.remove(position);
                        arrayAdapter.notifyDataSetChanged();
                        Toast.makeText(getActivity(), "The selected order has been removed from history.", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });



                final AlertDialog dialog = builder.create();
                dialog.show(); //show() should be called before dialog.getButton().

            }
        });
        arrayAdapter.setNotifyOnChange(true);
        listView.setAdapter(arrayAdapter);

        return root;
    }

    public void updateList() {
        refreshOrders();
        loadOrderNameList();
        arrayAdapter.notifyDataSetChanged();
    }

    public void refreshOrders() {
        orderList.clear();

        final SharedPreferences prefs = orderTransfer.getPrefs();
        Map<String,?> keys = prefs.getAll();
        Gson gson = new Gson();

        for(String key : keys.keySet()) {
            String json = prefs.getString(key, "");
            Log.d("json", json);
            try {
                Order obj = gson.fromJson(json, Order.class);
                orderList.add(obj);
            } catch (ClassCastException cce) {
            }
        }
    }

    public void loadOrderNameList() {
        orderNames.clear();
        for (Order order : orderList) {
            orderNames.add(order.getOrderName());
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
