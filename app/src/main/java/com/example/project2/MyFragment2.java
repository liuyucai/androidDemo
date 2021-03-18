package com.example.project2;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.project2.adapter.ChatAdapter;
import com.example.project2.model.ChatMsg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyucai on 2020/10/09
 */
public class MyFragment2 extends Fragment {

    public MyFragment2() {
    }

    private ChatAdapter chatAdapter;

    private List<ChatMsg> msgs = new ArrayList<ChatMsg>();
    private ListView lv;
    private TextView et_chat_input;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat, container, false);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "icons/iconfont.ttf");

        TextView chat_back_icon = (TextView) view.findViewById(R.id.chat_back_icon);
        chat_back_icon.setTypeface(font);
        chat_back_icon.setTextSize(40); //设置大小
        chat_back_icon.setTextColor(Color.parseColor("#cccccc")); //设置颜色
        chat_back_icon.setText(getResources().getString(R.string.back_font));

        TextView voice_font_textView = (TextView) view.findViewById(R.id.voice_font_textView);
        voice_font_textView.setTypeface(font);
        voice_font_textView.setTextSize(24); //设置大小
        voice_font_textView.setTextColor(Color.parseColor("#ffffff")); //设置颜色
        voice_font_textView.setText(getResources().getString(R.string.voice_open_font));

        TextView emojis_font_textView = (TextView) view.findViewById(R.id.emojis_font_textView);
        emojis_font_textView.setTypeface(font);
        emojis_font_textView.setTextSize(24); //设置大小
        emojis_font_textView.setTextColor(Color.parseColor("#ffffff")); //设置颜色
        emojis_font_textView.setText(getResources().getString(R.string.emojis_open_font));

        TextView char_image_container_tv = (TextView)view.findViewById(R.id.char_image_container_tv);
        char_image_container_tv.setTypeface(font);
        char_image_container_tv.setTextSize(24); //设置大小
        char_image_container_tv.setTextColor(Color.parseColor("#cccccc")); //设置颜色
        char_image_container_tv.setText(getResources().getString(R.string.pic_font));

        TextView char_emojis_container_tv = (TextView)view.findViewById(R.id.char_emojis_container_tv);
        char_emojis_container_tv.setTypeface(font);
        char_emojis_container_tv.setTextSize(24); //设置大小
        char_emojis_container_tv.setTextColor(Color.parseColor("#cccccc")); //设置颜色
        char_emojis_container_tv.setText(getResources().getString(R.string.emojis_open_font));

        TextView char_collect_emojis_container_tv = (TextView)view.findViewById(R.id.char_collect_emojis_container_tv);
        char_collect_emojis_container_tv.setTypeface(font);
        char_collect_emojis_container_tv.setTextSize(24); //设置大小
        char_collect_emojis_container_tv.setTextColor(Color.parseColor("#cccccc")); //设置颜色
        char_collect_emojis_container_tv.setText(getResources().getString(R.string.collect_font));



        msgs.add(new ChatMsg());
        chatAdapter = new ChatAdapter(getActivity(),msgs);
        TextView tv_send = view.findViewById(R.id.tv_send);
        lv = view.findViewById(R.id.chat_listView);
        et_chat_input = view.findViewById(R.id.et_chat_message);
        final TextView et_chat_message = view.findViewById(R.id.et_chat_message);

        lv.setAdapter(chatAdapter);
        chatAdapter.notifyDataSetChanged();
        tv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = et_chat_message.getText().toString();
                if (!content.isEmpty()) {
                    msgs.add(new ChatMsg(ChatMsg.TYPE_SEND,content));
                    chatAdapter.notifyDataSetChanged();
//                    lv.setSelection(msgs.size() - 1);
                    lv.setSelection(msgs.size());
                    et_chat_input.setText("");
                } else {
                    Toast.makeText(getActivity(), "请输入内容!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
