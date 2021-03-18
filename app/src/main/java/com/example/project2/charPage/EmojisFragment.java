package com.example.project2.charPage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.project2.adapter.MyAdapter;
import com.example.project2.model.EmojiEntity;
import com.example.project2.model.NewsData;
import com.example.project2.R;
import com.example.project2.utils.FileUtil;
import com.example.project2.utils.JsonParseUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class EmojisFragment extends Fragment{

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

    public EmojisFragment() {
    }

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.emojis_container, container, false);

        FlowLayout mFlowLayout = (FlowLayout) view.findViewById(R.id.emojis_container_flowlayout);

        List<EmojiEntity> emojiEntityList  = JsonParseUtil.parseEmojiList(FileUtil.readAssetsFile(getContext(), "EmojiList.json"));

//        mFlowLayout.setAlignByCenter(FlowLayout.AlienState.CENTER);  设置居中
        mFlowLayout.setAlignByCenter(FlowLayout.AlienState.FLOW_LAYOUT_CENTER);

        mFlowLayout.setAdapter(emojiEntityList, R.layout.item, new FlowLayout.ItemView<EmojiEntity>() {
            @Override
            void getCover(EmojiEntity emojiEntity, FlowLayout.ViewHolder holder, View inflate, int position) {
                holder.setText(R.id.tv_label_name,new String(Character.toChars(emojiEntity.getUnicode())));
            }
        });
        return view;
    }

}
