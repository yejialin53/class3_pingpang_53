package com.example.hp.android_final;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {

    //UI Objects
    //private TextView txt_topbar;
    private RadioGroup rg_tab_bar;
    private RadioButton ranking;
    private RadioButton players_data;
    private RadioButton schedule;
    private RadioButton highlights;
    private RadioButton first_page;
    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;
    public static final int PAGE_FIVE = 4 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        ranking = (RadioButton) findViewById(R.id.ranking);
        players_data = (RadioButton) findViewById(R.id.players_data);
        schedule = (RadioButton) findViewById(R.id.schedule);
        highlights = (RadioButton) findViewById(R.id.highlights);
        first_page = (RadioButton)findViewById(R.id.first_page) ;
        rg_tab_bar.setOnCheckedChangeListener(this);

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
       // rb_channel.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.first_page:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.ranking:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.players_data:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.schedule:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
            case R.id.highlights:
                vpager.setCurrentItem(PAGE_FIVE);
                break;
        }
    }


    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    first_page.setChecked(true);
                    break;
                case PAGE_TWO:
                    ranking.setChecked(true);
                    break;
                case PAGE_THREE:
                    players_data.setChecked(true);
                    break;
                case PAGE_FOUR:
                    schedule.setChecked(true);
                    break;
                case PAGE_FIVE:
                    highlights.setChecked(true);
                    break;
            }
        }
    }
}