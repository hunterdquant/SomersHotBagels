package app.shb.somershotbagels;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.gson.Gson;

/**
 * takes an order and gets some user information and sends the order
 * @author Robert Miller & Hunter Quant
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


    /**
     * compares entered text with regular expression of phone number
     * @param text - the text in the phone edit text box
     */
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

    /**
     * returns true because name is only used for identification on pickup
     */
    private void nameChange(){
        nameEnter = true;
    }

    /**
     * compares entered text with email regular expression
     * @param text - the text in the email edit text box
     */
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

    /**
     * enables the button if the phone, email, and name edit texts have info in them
     */
    private void enableButton(){
        runOnUiThread(new Runnable(){
            public void run () {
                placeOrderB.setEnabled(phoneBool & emailBool & nameBool);
            }
        });
    }

    /**
     * checks if user entered fields are valid
     * @return true if all the fields are entered correctly
     */
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
        //listens for the back press
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getSupportActionBar().setDisplayShowTitleEnabled(false);


        nameEdit = (EditText) findViewById(R.id.userName);
        emailEdit = (EditText) findViewById(R.id.emailAddress);
        phoneEdit = (EditText) findViewById(R.id.phoneNum);
        placeOrderB = (Button) findViewById(R.id.orderButton);

        //detects if edit text is changed
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

        //detects if edit text is changed
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

        //detects if edit text is changed
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


        //sends order if everything is in order
        //if not then a toast tells the user what was wrong
        placeOrderB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkFields()) {
                    ConnectivityManager cm = (ConnectivityManager) CheckoutActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

                    Thread t = new Thread(new Runnable() {
                        public void run() {
                            try {
                                //sending order
                                InetAddress i = InetAddress.getByName("cisco09122.townhouse.clarkson.edu");
                                Socket socket = new Socket(i, 5969);
                                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                                BufferedReader in = new BufferedReader(
                                        new InputStreamReader(socket.getInputStream()));
                                out.println("<order>");
                                out.println("Name: " + nameEdit.getText().toString());
                                out.println("Phone: " + phoneEdit.getText().toString());
                                out.println("Email: " + emailEdit.getText().toString());
                                out.println(order.toString());
                                out.println("</order>");

                                //toast to tell user
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
                                //order did not send/receive
                                Toast t = Toast.makeText(CheckoutActivity.this, "Order Not Received", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER, 0, 0);
                                t.show();
                            }
                        }
                    });
                    t.start();
                }else{
                    runOnUiThread(new Runnable() {
                        public void run() {
                            //user entered info is incorrect
                            //toasts what was wrong
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
