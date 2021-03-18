package com.example.project2.charPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.project2.adapter.MyAdapter;
import com.example.project2.R;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class CollectEmojisFragment extends Fragment{




    /**
     * 自定义的Adapter对象
     */
    private  MyAdapter adapter;

    public CollectEmojisFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.collect_emojis_container, container, false);

        int width = view.getMeasuredWidth();
        int height = view.getMeasuredHeight();

        int emojisWidth = 25;
        int emojisHeigh = 25;

        int row = width/emojisWidth;


        return view;
    }

}
