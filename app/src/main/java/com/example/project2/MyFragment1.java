package com.example.project2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment1 extends Fragment{

    /**
     * ListView对象
     */
    private ListView listView;

    /**
     * 新闻集合对象
     */
    private List<NewsData> datas;


    /**
     * 自定义的Adapter对象
     */
    private  MyAdapter adapter;

    public MyFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.index, container, false);
        listView = (ListView) view.findViewById(R.id.listView1);
        datas = new ArrayList<NewsData>();
        for (int i = 0; i <10; i++) {
            NewsData data = new NewsData();
            data.setNewsTitle("title"+i);
            data.setNewsDate("date"+i);
            data.setNewsImgUrl("thumbnail_pic_s"+i);
            data.setNewsUrl("R.drawable.p1");
            datas.add(data);
        }
        adapter = new MyAdapter(getActivity(), datas);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {

                /**
                 * 创建一个意图
                 */
                Intent intent = new Intent(getActivity(),NewsInfoActivity.class);

                /**
                 * 在datas中通过点击的位置position通过get()方法获得具体某个新闻
                 * 的数据然后通过Intent的putExtra()传递到NewsInfoActivity中
                 */
                intent.putExtra("newsTitle", datas.get(position).getNewsTitle());
                intent.putExtra("newsDate", datas.get(position).getNewsDate());
                intent.putExtra("newsImgUrl", datas.get(position).getNewsImgUrl());
                intent.putExtra("newsUrl", datas.get(position).getNewsUrl());

                //需要在AndroidManifest.xml配置新增加的AppCompatActivity类，NewsInfoActivity
                MyFragment1.this.startActivity(intent);//启动Activity

            }
        });
        return view;
    }

}
