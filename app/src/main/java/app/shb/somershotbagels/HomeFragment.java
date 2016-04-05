package app.shb.somershotbagels;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

    public static final String[] CATEGORY_NAMES = {"Bagels", "Sandwiches", "Beverages", "Other"};
    public static final int[] IMAGE_IDS = {R.mipmap.bagels, R.mipmap.sandwiches, R.mipmap.beverages, R.mipmap.other};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.home_tab_fragment, container, false);
        categoryList = new ArrayList<Category>();

        for (int i = 0; i < CATEGORY_NAMES.length; i++) {
            Category category = new Category(IMAGE_IDS[i], CATEGORY_NAMES[i]);
            categoryList.add(category);
        }
        listView = (ListView) root.findViewById(R.id.categoryList);
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

