package app.shb.somershotbagels;

import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * The main application activity.
 *
 * @author Hunter Quant, Robert Miller
 */
public class SHBActivity extends AppCompatActivity implements OrderTransfer {

    /*
      The current order.
     */
    private Order order;
    /*
      The local storage access to save and load orders.
     */
    SharedPreferences prefs;
    /*
      Fragment pager.
     */
    FragmentPagerAdapter adapter;

    /*
      The view pager.
     */
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Create the cart.
        order = new Order();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shb);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        prefs = getPreferences(MODE_PRIVATE);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Favorites"));
        tabLayout.addTab(tabLayout.newTab().setText("Menu"));
        tabLayout.addTab(tabLayout.newTab().setText("Cart"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);
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

        // Sets navigation functionality of back button.
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
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

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            viewPager.setCurrentItem(1);
        } else if (viewPager.getCurrentItem() == 2) {
            viewPager.setCurrentItem(1);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * @return The cart.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @return the storage access.
     */
    public SharedPreferences getPrefs() {
        return prefs;
    }

    /**
     * Update the information in the cart.
     */
    public void updateCart() {
        adapter.getCart().updateList();
    }

    /**
     * Update the information in the favorites.
     */
    public void updateFavorites() {
        adapter.getFav().updateList();
    }
}
