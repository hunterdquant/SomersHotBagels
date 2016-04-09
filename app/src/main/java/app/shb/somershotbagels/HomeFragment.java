package app.shb.somershotbagels;

import android.content.Context;
import android.content.Intent;
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunter on 3/25/16.
 */
public class HomeFragment extends Fragment {

    OrderTransfer orderTransfer;
    ListView listView;
    List<Category> categoryList;
    private Order order;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.home_tab_fragment, container, false);
        categoryList = new ArrayList<Category>();
        order.addItem(new Item("Item"));
        for (int i = 0; i < MenuRetrieval.CATEGORY_NAMES.length; i++) {
            Category category = new Category(MenuRetrieval.IMAGE_IDS[i], MenuRetrieval.CATEGORY_NAMES[i]);
            categoryList.add(category);
        }
        listView = (ListView) root.findViewById(R.id.categoryList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Intent intent = new Intent(getActivity(), ListItemsActivity.class);
                Gson gson = new Gson();
                intent.putExtra("CAT_NUM", position);
                intent.putExtra("ORDER", gson.toJson(order));
                startActivity(intent);
            }
        });
        ImageTextBaseAdapter adapter = new ImageTextBaseAdapter(getActivity(), categoryList);
        listView.setAdapter(adapter);
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

