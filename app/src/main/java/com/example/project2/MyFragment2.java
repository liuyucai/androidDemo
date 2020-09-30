package com.example.project2;

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

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment2 extends Fragment {

    public MyFragment2() {
    }

    private ChatAdapter chatAdapter;

    private ArrayList<ChatMsg> msgs = new ArrayList<ChatMsg>();
    private ListView lv;
    private TextView et_chat_input;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.chat, container, false);

        chatAdapter = new ChatAdapter(getActivity(),msgs);
        TextView tv_send = view.findViewById(R.id.tv_send);
        lv = view.findViewById(R.id.chat_listView);
        et_chat_input = view.findViewById(R.id.et_chat_message);
        final TextView et_chat_message = view.findViewById(R.id.et_chat_message);
        tv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = et_chat_message.getText().toString();
                if (!content.isEmpty()) {
                    msgs.add(new ChatMsg());
                    chatAdapter.notifyDataSetChanged();
                    lv.setSelection(msgs.size() - 1);
                    et_chat_input.setText("");
                } else {
                    Toast.makeText(getActivity(), "请输入内容!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
