package com.speedlink3.web.Utilities;

import android.app.Application;
import android.content.Context;

import com.google.firebase.FirebaseApp;

public class MainLanguageApplication extends Application {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));

    }

    @Override
    public void onCreate( ) {
        super.onCreate();
        FirebaseApp.initializeApp(this);
        RemoteConfigUtils.init();
    }
}
