package apurv.com.polaris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Dell on 25-10-2015.
 */
public class SplashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;

    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
/*
        final ImageView im = (ImageView) findViewById(R.id.logo);

        final Animation animFadeOut = AnimationUtils.loadAnimation(this, R.anim.wobble);
        animFadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation animFadeOuts = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.wobble);

                im.startAnimation(animFadeOuts);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        im.startAnimation(animFadeOut);
*/

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, menu.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }




}