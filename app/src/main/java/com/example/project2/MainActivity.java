package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private View page1, page2, page3,page4; // ViewPager包含的页面

    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.layout2);
//        ImageView imageView = (ImageView) findViewById(R.id.imageView);
//        imageView.setImageResource(R.drawable.p1);
//        getSupportFragmentManager()为androix中FragmentActivity类的方法
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
    }
    private void bindViews() {

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(1);
        vpager.addOnPageChangeListener(this);
    }

    public void linearLayoutClickEvent(View v){
        String pageNumber = (String) v.getTag();
        switch (pageNumber) {
            case "1":
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case "2":
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case "3":
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case "4":
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }

    }

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
                    //加载数据
//                    rb_channel.setChecked(true);
                    break;
                case PAGE_TWO:
//                    rb_message.setChecked(true);
                    break;
                case PAGE_THREE:
//                    rb_better.setChecked(true);
                    break;
                case PAGE_FOUR:
//                    rb_setting.setChecked(true);
                    break;
            }
        }

    }
}