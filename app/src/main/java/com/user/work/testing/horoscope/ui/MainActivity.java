package com.user.work.testing.horoscope.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.user.work.testing.horoscope.R;
import com.user.work.testing.horoscope.data.model.Horoscope;
import com.user.work.testing.horoscope.ui.list_fragment.FragmentList;

public class MainActivity extends AppCompatActivity implements HoroscopeClickHandler, FragmentList.AboutOptionClick{

    private FrameLayout listContainer;
    private  FrameLayout detailContainer;
    private boolean isLandScapeMode;
    FragmentList fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContainer = findViewById(R.id.list_container);
        detailContainer = findViewById(R.id.detail_container);
        isLandScapeMode = detailContainer != null;
        fragmentList = new FragmentList();
        if (savedInstanceState != null) {
            fragmentList = (FragmentList) getSupportFragmentManager().getFragment(savedInstanceState, "myFragmentName");

        }
        getSupportFragmentManager().beginTransaction().replace(R.id.list_container, fragmentList, "myFragmentName")
                .commit();

    }

    @Override
    public void onHoroscopeItemClick(Horoscope horoscope) {
        if (isLandScapeMode){
            getSupportFragmentManager().beginTransaction().replace(R.id.detail_container, FragmentAbout.DetailFragment.newInstance(horoscope)).commit();
        }
        else {
            FragmentAbout.DetailFragment dialog = FragmentAbout.DetailFragment.newInstance(horoscope);
            dialog.show(getSupportFragmentManager(), "custom dialog");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "myFragmentName", fragmentList);
    }

    @Override
    public void onAboutOptionClicked() {
        if (isLandScapeMode){
            FragmentAbout dialog = new FragmentAbout();
            dialog.show(getSupportFragmentManager(), "custom dialog");
        }
        else
            startActivity(new Intent(this, AboutActivity.class));
    }
}
