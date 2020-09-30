package com.example.project2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//每创建一个新增加的AppCompatActivity类，需要在AndroidManifest.xml配置该类

public class NewsInfoActivity extends AppCompatActivity {


    private ImageView ivImg;
    private TextView tvTitle;
    private TextView tvDate;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);
        TextView tvShow = (TextView) findViewById(R.id.back_icon);
        Typeface font = Typeface.createFromAsset(getAssets(), "icons/iconfont.ttf");
        tvShow.setTypeface(font);
        tvShow.setTextSize(40); //设置大小
        tvShow.setTextColor(Color.parseColor("#cccccc")); //设置颜色
        tvShow.setText(getResources().getString(R.string.back_font));
        initViews();
    }

    /**
     * 初始化数据
     */
    public void initViews(){
        ivImg = (ImageView) this.findViewById(R.id.iv_img);
        tvTitle = (TextView) this.findViewById(R.id.tv_title);
        tvDate = (TextView) this.findViewById(R.id.tv_date);
        webView = (WebView) this.findViewById(R.id.wv_content);

        /**
         * 获得传递过来的数据
         */
          Intent intent = this.getIntent();
        String newsTitle = intent.getStringExtra("newsTitle");
        String newsDate = intent.getStringExtra("newsDate");
        String newsImgUrl = intent.getStringExtra("newsImgUrl");
        String newsUrl = intent.getStringExtra("newsUrl");


        //通过集合中的图片地址获得图片并且设置到view上
        ivImg.setImageResource(R.drawable.p1);

        /**
         * 显示新闻信息
         */
        tvTitle.setText(newsTitle);
        tvDate.setText(newsDate);
//        webView.loadUrl(newsUrl);

    }

    /**
     * 加载网络图片
     */
    public void getImage(final ImageView imageView) {

    }

    public void gotoBack(View v){
        this.finish();
    }

}