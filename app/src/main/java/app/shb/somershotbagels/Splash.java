package app.shb.somershotbagels;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Displays the splash screen for SPLASH_TIME seconds.
 *
 * @author Hunter Quant, Robert Miller
 */
public class Splash extends AppCompatActivity {

    /*
      The time to display.
     */
    private final int SPLASH_TIME = 2000;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splash.this,SHBActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_TIME);
    }
}