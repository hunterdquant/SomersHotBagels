package app.shb.somershotbagels;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


/**
 * Handles the display and functionality of the category list fragment.
 *
 * @author Hunter Quant, Robert Miller
 */
public class CategoryListFragment extends Fragment {

    /*
      Callback to communicate with the activity.
     */
    OrderTransfer orderTransfer;
    /*
      Cart list view.
     */
    ListView listView;
    /*
      A list of category names.
     */
    List<Category> categoryList;
    /*
      Reference to the activity's global order.
     */
    private Order order;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.category_list_fragment, container, false);
        categoryList = new ArrayList<Category>();
        for (int i = 0; i < MenuRetrieval.CATEGORY_NAMES.length; i++) {
            Category category = new Category(MenuRetrieval.IMAGE_IDS[i], MenuRetrieval.CATEGORY_NAMES[i]);
            categoryList.add(category);
        }
        listView = (ListView) root.findViewById(R.id.categoryList);

        // Do a fragment transaction with the selected item.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("LIST_INDEX", position);

                ListItemsFragment lif = new ListItemsFragment();
                lif.setArguments(bundle);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.homeContainer, lif);
                ft.commit();
            }
        });
        ImageTextBaseAdapter adapter = new ImageTextBaseAdapter(getActivity(), categoryList);
        listView.setAdapter(adapter);
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

