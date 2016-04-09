package app.shb.somershotbagels;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunter on 4/9/16.
 */
public class ListItemsActivity extends AppCompatActivity {

    private Order order;
    private List<Item> itemList;
    private List<String> itemNames;

    @Override
    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_list_items);
        Gson gson = new Gson();
        itemList = MenuRetrieval.retreveCategory(MenuRetrieval.CATEGORY_NAMES[getIntent().getIntExtra("CAT_NUM", 0)]);
        order = gson.fromJson(getIntent().getStringExtra("ORDER"), Order.class);
        Log.d("order", itemList + " why u do dis");
        ListView listView = (ListView) findViewById(R.id.itemListActivity);
        itemNames = new ArrayList<String>();
        populateItemNames();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                R.layout.list,
                itemNames);
        arrayAdapter.setNotifyOnChange(true);
        listView.setAdapter(arrayAdapter);
    }

    private void populateItemNames() {
        for (Item item : itemList) {
            itemNames.add(item.getName());
        }
    }
}
