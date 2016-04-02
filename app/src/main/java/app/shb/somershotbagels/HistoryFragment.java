package app.shb.somershotbagels;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        orderList.add(order);
        Log.d("test", order.toString());

        SharedPreferences prefs = orderTransfer.getPrefs();
        Map<String,?> keys = prefs.getAll();
        Gson gson = new Gson();

        for(String key : keys.keySet()) {
            String json = prefs.getString(key, "");
            Object obj = gson.fromJson(json, Object.class);
            if (obj instanceof Order) {
                orderList.add((Order) obj);
            }
        }

        List<String> orderNames = getListOfOrderNames();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list,
                orderNames );

        View root = inflater.inflate(R.layout.history_tab_fragment, container, false);

        listView = (ListView) root.findViewById(R.id.historyList);

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
