package app.shb.somershotbagels;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

/**
 * Created by Robert on 4/9/2016.
 */
public class CheckoutActivity extends AppCompatActivity{
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.checkout);
        Gson gson = new Gson();
        order = gson.fromJson(getIntent().getStringExtra("ORDER"), Order.class);

    }
}
