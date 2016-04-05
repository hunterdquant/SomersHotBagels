package app.shb.somershotbagels;

import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class SHBActivity extends AppCompatActivity implements OrderTransfer {

    private Order order;
    SharedPreferences prefs;
    FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        order = new Order();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shb);

        prefs = getPreferences(MODE_PRIVATE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("History"));
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Cart"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager= (ViewPager) findViewById(R.id.pager);
        adapter = new FragmentPagerAdapter(
                getSupportFragmentManager(),
                tabLayout.getTabCount()
        );

        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        viewPager.setCurrentItem(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.categoryName) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public Order getOrder() {
        return order;
    }

    public SharedPreferences getPrefs() {
        return prefs;
    }

    public void updateCart() {
        adapter.getCart().updateList();
    }
}
