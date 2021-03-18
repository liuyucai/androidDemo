package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.project2.adapter.MessagePageAdapter;
import com.example.project2.adapter.MyAdapter;
import com.example.project2.charPage.CharActivity;
import com.example.project2.model.MessageData;
import com.example.project2.model.NewsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MessagePageFragment extends Fragment {

    /**
     * ListView对象
     */
    private ListView listView;

    /**
     * 新闻集合对象
     */
    private List<MessageData> datas;


    /**
     * 自定义的Adapter对象
     */
    private MessagePageAdapter adapter;

    public MessagePageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.message_page, container, false);
        listView = (ListView) view.findViewById(R.id.messagePageListView);
        datas = new ArrayList<MessageData>();
        for (int i = 0; i <10; i++) {
            MessageData data = new MessageData();
            data.setNewsTitle("title"+i);
            data.setNewsDate("date"+i);
            data.setNewsImgUrl("thumbnail_pic_s"+i);
            data.setNewsUrl("R.drawable.p1");
            datas.add(data);
        }
        adapter = new MessagePageAdapter(getActivity(), datas);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {

                /**
                 * 创建一个意图
                 */
                Intent intent = new Intent(getActivity(), CharActivity.class);

                //需要在AndroidManifest.xml配置新增加的AppCompatActivity类，NewsInfoActivity
                MessagePageFragment.this.startActivity(intent);//启动Activity

            }
        });
        return view;
    }
}
