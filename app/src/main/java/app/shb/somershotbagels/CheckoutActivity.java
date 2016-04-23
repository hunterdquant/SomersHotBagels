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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
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
    private final long DELAY = 1000;
    private ReentrantLock lock = new ReentrantLock();
    private EditText nameEdit;
    private EditText emailEdit;
    private EditText phoneEdit;

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
                    Toast t = Toast.makeText(CheckoutActivity.this, "Phone Number Not Valid", Toast.LENGTH_SHORT);
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

        Pattern emailPattern = Pattern.compile("^\\w+@\\w+.\\w+$");
        Matcher emailMatcher = emailPattern.matcher(text);
        if(emailMatcher.find()){
            emailEnter = true;
        }else{
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast t = Toast.makeText(CheckoutActivity.this, "Email Address Not Valid", Toast.LENGTH_SHORT);
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
    private String nameS, emailS, phoneS;
    private void enableButton(){
        runOnUiThread(new Runnable(){
            public void run () {
                placeOrderB.setEnabled(phoneEnter & emailEnter & nameEnter);
            }
        });
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

        nameEdit = (EditText) findViewById(R.id.userName);
        emailEdit = (EditText) findViewById(R.id.emailAddress);
        phoneEdit = (EditText) findViewById(R.id.phoneNum);
        placeOrderB = (Button) findViewById(R.id.orderButton);

        nameEdit.addTextChangedListener(new GenericTextWatcher(nameEdit));
        emailEdit.addTextChangedListener(new GenericTextWatcher(emailEdit));
        phoneEdit.addTextChangedListener(new GenericTextWatcher(phoneEdit));



        placeOrderB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    public void run() {
                        Log.d("text", "CLICKED");
                        try {
                            InetAddress i = InetAddress.getByName("cisco09122.townhouse.clarkson.edu");
                            Socket socket = new Socket(i, 5969);
                            Log.d("text", "ORDERING");
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(socket.getInputStream()));
                            out.println("<order>");
                            out.println("Name: " + nameEdit.getText().toString());
                            out.println("Phone: " + phoneEdit.getText().toString());
                            out.println("Email: " + emailEdit.getText().toString());
                            out.println(order.toString());
                            out.println("</order>");


                            runOnUiThread(new Runnable() {
                                public void run() {
                                    Toast t = Toast.makeText(CheckoutActivity.this, "Order Received", Toast.LENGTH_SHORT);
                                    t.setGravity(Gravity.CENTER, 0, 0);
                                    t.show();
                                }
                            });
                            out.close();
                            socket.close();
                        }catch (Exception e) {
                            Log.d("text", e.toString());
                        }
                    }
                });
                t.start();
            }
        });
    }

}
