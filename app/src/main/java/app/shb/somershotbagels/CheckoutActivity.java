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
    private boolean nameBool = false, phoneBool = false, emailBool = false;
    private ReentrantLock lock = new ReentrantLock();
    private EditText nameEdit;
    private EditText emailEdit;
    private EditText phoneEdit;



    private void phoneChange(String text){
        Pattern phoneNumPattern = Pattern.compile("^([(]?[2-9]\\d{2}\\s?[)|-]\\s?\\d{3}\\s?-\\s?\\d{4}" +
                "|\\d{3}\\s?-\\s?\\d{4}" +
                "|[2-9]\\d{9}" +
                "|\\d{7})$");
        Matcher phoneNumMatcher = phoneNumPattern.matcher(text);
        if(phoneNumMatcher.find()){
            phoneEnter = true;
        }else{
            phoneEnter = false;
        }
    }
    private void nameChange(){
        nameEnter = true;
    }
    private void emailChange(String text){
        Pattern emailPattern = Pattern.compile("^\\w+@\\w+\\.\\w+$");
        Matcher emailMatcher = emailPattern.matcher(text);
        if(emailMatcher.find()){
            emailEnter = true;
        }else{
            emailEnter = false;
        }

    }
    private String nameS, emailS, phoneS;
    private void enableButton(){
        runOnUiThread(new Runnable(){
            public void run () {
                placeOrderB.setEnabled(phoneBool & emailBool & nameBool);
            }
        });
    }
    private boolean checkFields(){
        return emailEnter & nameEnter & phoneEnter;
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

        nameEdit.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s){
                nameBool = true;
                enableButton();
                nameChange();
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after){}
        });
        emailEdit.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s){
                emailBool = true;
                enableButton();
                emailChange(s.toString());
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after){}
        });
        phoneEdit.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s){
                phoneBool = true;
                enableButton();
                phoneChange(s.toString());
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after){}
        });



        placeOrderB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkFields()) {
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
                            } catch (Exception e) {
                                Log.d("text", e.toString());
                            }
                        }
                    });
                    t.start();
                }else{
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast t = Toast.makeText(CheckoutActivity.this, "", Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.BOTTOM, 0, 0);
                            if (nameEnter == false){
                                t.setText("Invalid Name");
                                t.show();
                            }else if (phoneEnter == false){
                                t.setText("Invalid Phone Number");
                                t.show();
                            }else if (emailEnter == false){
                                t.setText("Invalid Email");
                                t.show();
                            }
                        }
                    });
                }
            }
        });
    }

}
