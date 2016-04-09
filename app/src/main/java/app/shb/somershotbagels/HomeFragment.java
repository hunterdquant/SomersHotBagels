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

    public static final String[] CATEGORY_NAMES = {"Beverages", "Bagels", "Breakfast Foods", "Baked Goods", "Wraps", "Sandwiches", "Salads"};
    public static final int[] IMAGE_IDS = {R.mipmap.beverages, R.mipmap.bagels, R.mipmap.breakfast, R.mipmap.bakedgoods, R.mipmap.wrap, R.mipmap.sandwiches, R.mipmap.salad};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.home_tab_fragment, container, false);
        categoryList = new ArrayList<Category>();

        for (int i = 0; i < CATEGORY_NAMES.length; i++) {
            Category category = new Category(IMAGE_IDS[i], CATEGORY_NAMES[i]);
            MenuRetrieval.buildMenu(category);
            categoryList.add(category);
        }
        listView = (ListView) root.findViewById(R.id.categoryList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Intent intent = new Intent(getActivity(), ListItemsActivity.class);
                Gson gson = new Gson();
                Log.d("srsly", categoryList.get(position).getItems() + " why");
                intent.putExtra("ITEMS", gson.toJson(categoryList.get(position).getItems()));
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

