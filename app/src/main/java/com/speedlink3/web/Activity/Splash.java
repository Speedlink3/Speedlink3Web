package com.speedlink3.web.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.onesignal.OneSignal;
import com.speedlink3.web.R;
import com.speedlink3.web.Utilities.RemoteConfigUtils;
import com.speedlink3.web.Utilities.SaveSharedPreference;


public class Splash extends AppCompatActivity {

    Handler handler = new Handler();
    ConstraintLayout splashBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashBackground = findViewById(R.id.splashBackground);


        if (SaveSharedPreference.getIsDarkMode(getApplicationContext()).equals("true")) {

            splashBackground.setBackgroundColor(getResources().getColor(R.color.dark_color));
            statusBarNightColor();
        } else {


            splashBackground.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            statusBarNormalColor();

        }

        // Logging set to help debug issues, remove before releasing your app.
     //   OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
//        OneSignal.startInit(this)
//                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
//                .unsubscribeWhenNotificationsAreDisabled(true)
//                .init();

        int SPLASH_DISPLAY_LENGTH = 1000;
        handler.postDelayed(( ) -> {

            if (RemoteConfigUtils.isHideAppIntro()) {

                Intent mainIntent = new Intent(Splash.this, WebViewActivity.class);
                Splash.this.startActivity(mainIntent);

            } else {

                if (SaveSharedPreference.getShowIntro(getApplicationContext()).equals("true")) {

                    Intent mainIntent = new Intent(Splash.this, WebViewActivity.class);
                    Splash.this.startActivity(mainIntent);

                } else {

                    Intent mainIntent = new Intent(Splash.this, AppIntroActivity.class);
                    Splash.this.startActivity(mainIntent);
                }


            }


            Splash.this.finish();



            /* Create an Intent that will start the Menu-Activity. */

        }, SPLASH_DISPLAY_LENGTH);

    }


    @Override
    protected void onDestroy( ) {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    public void statusBarNormalColor( ) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary, this.getTheme()));
        } else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }

    }

    public void statusBarNightColor( ) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            getWindow().setStatusBarColor(getResources().getColor(R.color.dark_color, this.getTheme()));
        else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.dark_color));
        }

    }

}