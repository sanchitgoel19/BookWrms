/**
 * Created by jaiswal on 08/08/15.
 * Disclaimer: This is the property of BookWorms Corporation. Any reproduction of the material here in any form is liable to legal action.
 */
package com.android.bookwrms.bookwrms;

import android.app.Activity;
import android.os.Bundle;

import android.os.Handler;
import android.content.Intent;


public class WelcomeScreen extends Activity {

    /* Setting Welcome Screen Timeout to 2 secs
     */
    private static int WS_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        new Handler().postDelayed(new Runnable(){

            /*
             * Showing splash screen with a timer of 2 seconds. Can make the HTTP request to get channels information in this time
             */

            @Override
            public void run(){
                /*This method will be executed once the timer is over
                    Starting main activity now
                */

                Intent i = new Intent(WelcomeScreen.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }

        }, WS_TIME_OUT);
    }
}
