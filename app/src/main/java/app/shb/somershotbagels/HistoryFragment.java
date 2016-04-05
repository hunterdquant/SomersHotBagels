package app.shb.somershotbagels;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hunter on 3/25/16.
 */
public class HistoryFragment extends Fragment {
    OrderTransfer orderTransfer;
    private Order order;
    private List<Order> orderList;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        orderList = new ArrayList<Order>();
        Order hist1 = new Order("The goto statement");
        Order hist2 = new Order("Ode to Ed");
        Order hist3 = new Order("The bulk");
        Order hist4 = new Order("#Makin'Grains");
        Order hist5 = new Order("The saturday morning cartoon");
        Order hist6 = new Order("The end of the road");

        Item item = new Item("Bagel");
        item.addOption(new Option() {
            @Override
            public String toString() {
                return "Quantity: 6";
            }
        });
        item.addOption(new Option() {
            @Override
            public String toString() {
                return "Cream Cheese: Cranberry";
            }
        });
        hist1.addItem(item);
        item = new Item("Orange Juice");
        hist1.addItem(item);
        item = new Item("Buttered Toast");
        item.addOption(new Option() {
            @Override
            public String toString() {
                return "Toasted";
            }
        });
        hist2.addItem(new Item("Buttered Toast"));
        item = new Item("Orange Juice");
        item.addOption(new Option() {
            @Override
            public String toString() {
                return "Style: Scrambled";
            }
        });
        item.addOption(new Option() {
            @Override
            public String toString() {
                return "Vegetables: Spinach";
            }
        });
        hist2.addItem(item);
        item = new Item("Egg bagel cheese");
        item.addOption(new Option() {
            @Override
            public String toString() {
                return "Quantity: 2";
            }
        });
        hist3.addItem(item);
        item = new Item("Breakfast Burrito");
        item.addOption(new Option() {
            @Override
            public String toString() {
                return "Quantity: 12";
            }
        });
        hist3.addItem(item);
        item = new Item("Cream of wheat");
        hist4.addItem(item);
        item = new Item("Oatmeal");
        item.addOption(new Option() {
            @Override
            public String toString() {
                return "Type: Apple cinnamon";
            }
        });
        hist4.addItem(item);
        item = new Item("Cereal");
        item.addOption(new Option() {
            @Override
            public String toString() {
                return "Type: Honey Bunches of Oats with almonds";
            }
        });
        hist5.addItem(item);
        item = new Item("Coffee");
        item.addOption(new Option() {
            @Override
            public String toString() {
                return "Sugar: 10 packets";
            }
        });
        hist6.addItem(item);
        item = new Item("Grapefruit");
        item.addOption(new Option() {
            @Override
            public String toString() {
                return "Quantity: 9001";
            }
        });
        hist6.addItem(item);
        orderList.add(hist1);
        orderList.add(hist2);
        orderList.add(hist3);
        orderList.add(hist4);
        orderList.add(hist5);
        orderList.add(hist6);


        final SharedPreferences prefs = orderTransfer.getPrefs();
        Map<String,?> keys = prefs.getAll();
        Gson gson = new Gson();

        for(String key : keys.keySet()) {
            String json = prefs.getString(key, "");
            Object obj = gson.fromJson(json, Object.class);
            if (obj instanceof Order) {
                orderList.add((Order) obj);
            }
        }

        final List<String> orderNames = getListOfOrderNames();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list,
                orderNames );

        View root = inflater.inflate(R.layout.history_tab_fragment, container, false);

        listView = (ListView) root.findViewById(R.id.historyList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(getActivity(), listView);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.history_popup, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getTitle().equals("Add to cart")) {
                            order.appendOrder(orderList.get(position));
                            orderTransfer.updateCart();
                            Toast.makeText(getActivity(), "The selected order has been added to the cart.", Toast.LENGTH_LONG).show();
                        } else if (item.getTitle().equals("Remove from history")) {
                            final SharedPreferences.Editor editor = prefs.edit();
                            if (prefs.contains(orderNames.get(position))) {
                                editor.remove(orderNames.get(position));
                                editor.commit();
                            }
                            orderList.remove(position);
                            orderNames.remove(position);
                            arrayAdapter.notifyDataSetChanged();
                            Toast.makeText(getActivity(), "The selected order has been removed from history.", Toast.LENGTH_LONG).show();
                        }
                        return true;
                    }

                });

                popup.show();//showing popup menu
            }
        });
        arrayAdapter.setNotifyOnChange(true);
        listView.setAdapter(arrayAdapter);

        return root;
    }

    private List<String> getListOfOrderNames() {
        List<String> orderNames = new ArrayList<String>();
        for (Order order : orderList) {
            orderNames.add(order.getOrderName());
        }
        return orderNames;
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
