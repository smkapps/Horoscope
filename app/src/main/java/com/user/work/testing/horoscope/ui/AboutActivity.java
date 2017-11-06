package com.user.work.testing.horoscope.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.user.work.testing.horoscope.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportFragmentManager().beginTransaction().replace(R.id.about_container, new FragmentAbout() )
                .commit();
    }
}
