package com.speedlink3.web.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.speedlink3.web.R;
import com.speedlink3.web.Utilities.RemoteConfigUtils;
import com.speedlink3.web.Utilities.SaveSharedPreference;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AppIntroActivity extends AppIntro {

    int app_intro_text_color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isValidColor(RemoteConfigUtils.getAppIntroTextColor())) {

            app_intro_text_color = Color.parseColor(RemoteConfigUtils.getAppIntroTextColor());

        } else {

            app_intro_text_color = getResources().getColor(R.color.colorWhite);

        }


        setColorSkipButton(app_intro_text_color);
        setNextArrowColor(app_intro_text_color);
        setColorDoneText(app_intro_text_color);
        setIndicatorColor(app_intro_text_color, DEFAULT_COLOR);


        statusBarNormalColor();

        addSlide(AppIntroFragment.newInstance(getString(R.string.slide_one_title), R.font.poppins, getString(R.string.slide_one_text), R.font.poppins,
                R.drawable.slide_one_icon, getResources().getColor(R.color.colorPrimary), app_intro_text_color, app_intro_text_color));
        addSlide(AppIntroFragment.newInstance(getString(R.string.slide_two_title), R.font.poppins, getString(R.string.slide_two_text), R.font.poppins,
                R.drawable.slide_two_icon, getResources().getColor(R.color.colorPrimary), app_intro_text_color, app_intro_text_color));
        addSlide(AppIntroFragment.newInstance(getString(R.string.slide_three_title), R.font.poppins, getString(R.string.slide_three_text), R.font.poppins,
                R.drawable.slide_three_icon, getResources().getColor(R.color.colorPrimary), app_intro_text_color, app_intro_text_color));
    }

    private boolean isValidColor(String color) {

        Pattern colorPattern = Pattern.compile("#([0-9a-f]{3}|[0-9a-f]{6}|[0-9a-f]{8}|[0-9A-F]{3}|[0-9A-F]{6}|[0-9A-F]{8})");
        Matcher m = colorPattern.matcher(color);
        return m.matches();
    }


    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
        startActivity(intent);
        finish();
        SaveSharedPreference.setShowIntro(getApplicationContext(), "true");
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
        startActivity(intent);
        finish();
        SaveSharedPreference.setShowIntro(getApplicationContext(), "true");

    }

    public void statusBarNormalColor( ) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }


    }


}
