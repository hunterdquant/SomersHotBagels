package app.shb.somershotbagels;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.gson.Gson;

/**
 * Created by Robert on 4/9/2016.
 */
public class CheckoutActivity extends AppCompatActivity{
    private Order order;

    private Button placeOrderB;
    private boolean nameEnter = false, phoneEnter = false, emailEnter = false;
    private Timer emailTimer = new Timer();
    private Timer phoneTimer = new Timer();
    private final long DELAY = 750;
    private ReentrantLock lock = new ReentrantLock();

    private class GenericTextWatcher implements TextWatcher{
        private View view;
        private GenericTextWatcher(View view) {
            this.view = view;
        }
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            switch(view.getId()) {
                case R.id.userName:
                    break;
                case R.id.emailAddress:
                    if (emailTimer != null) {
                        emailTimer.cancel();
                    }
                    break;
                case R.id.phoneNum:
                    if (phoneTimer != null){
                        phoneTimer.cancel();
                    }
                    break;
            }
        }
        public void afterTextChanged(Editable editable) {
            final String viewInfo = editable.toString();
            switch(view.getId()){
                case R.id.userName:
                    nameChange();
                    break;
                case R.id.emailAddress:
                    emailTimer = new Timer();
                    emailTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            emailChange(viewInfo);

                        }
                    }, DELAY);
                    break;
                case R.id.phoneNum:
                    phoneTimer = new Timer();
                    phoneTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            phoneChange(viewInfo);
                        }
                    }, DELAY);
                    break;
            }
        }
    }


    private void phoneChange(String text){
        Pattern phoneNumPattern = Pattern.compile("^([(]?[2-9]\\d{2}\\s?[)|-]\\s?\\d{3}\\s?-\\s?\\d{4}" +
                "|\\d{3}\\s?-\\s?\\d{4}" +
                "|[2-9]\\d{9}" +
                "|\\d{7})$");
        Matcher phoneNumMatcher = phoneNumPattern.matcher(text);
        if(phoneNumMatcher.find()){
            phoneEnter = true;
        }else{
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast t = Toast.makeText(CheckoutActivity.this, "Phone Number Not Valid", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                }
            });
        }
        lock.lock();
        try {
            enableButton();
        }finally{
            lock.unlock();
        }
    }
    private void nameChange(){
        nameEnter = true;
        lock.lock();
        try {
            enableButton();
        }finally{
            lock.unlock();
        }
    }
    private void emailChange(String text){

        Pattern phoneNumPattern = Pattern.compile("^\\w+@\\w+.\\w+$");
        Matcher phoneNumMatcher = phoneNumPattern.matcher(text);
        if(phoneNumMatcher.find()){
            emailEnter = true;
        }else{
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast t = Toast.makeText(CheckoutActivity.this, "Email Address Not Valid", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                }
            });
        }
        lock.lock();
        try {
            enableButton();
        }finally{
            lock.unlock();
        }
    }
    private void enableButton(){
        placeOrderB.setEnabled(phoneEnter & emailEnter & nameEnter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_checkout);
        Gson gson = new Gson();
        order = gson.fromJson(getIntent().getStringExtra("ORDER"), Order.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("text", "back pressed");
                finish();
            }
        });

        EditText nameEdit = (EditText) findViewById(R.id.userName);
        EditText emailEdit = (EditText) findViewById(R.id.emailAddress);
        EditText phoneEdit = (EditText) findViewById(R.id.phoneNum);
        placeOrderB = (Button) findViewById(R.id.orderButton);

        nameEdit.addTextChangedListener(new GenericTextWatcher(nameEdit));
        emailEdit.addTextChangedListener(new GenericTextWatcher(emailEdit));
        phoneEdit.addTextChangedListener(new GenericTextWatcher(phoneEdit));

        RatingBar rateBar = (RatingBar) findViewById(R.id.ratingBar);
        EditText experienceEdit = (EditText) findViewById(R.id.experienceText);
        placeOrderB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Socket socket = new Socket("128.153.191.52", 5969);
                }catch(Exception e){}
            }
        });
    }

}
