package com.example.project2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.project2.NewsData;
import com.example.project2.R;
import com.example.project2.model.ChatMsg;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends BaseAdapter {

    private EditText et_input;
    private ChatAdapter chatAdapter;
    private ListView lv;

    private ArrayList<ChatMsg> msgs;

    private LayoutInflater layoutInflater;
    private Context context;

    public ChatAdapter(Context context, List<ChatMsg> msgs) {
        this.msgs = (ArrayList<ChatMsg>) msgs;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return msgs.size();
    }

    @Override
    public Object getItem(int i) {
        return msgs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
//            holder = new ViewHolder(view);
//            view = layoutInflater.inflate(R.layout.chat_item, null);//找到布局文件
            view = View.inflate(context,R.layout.chat_item, null);//找到布局文件
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        ChatMsg chatMsg = (ChatMsg) getItem(i);
        if (chatMsg.getType() == ChatMsg.TYPE_RECEIVE) {
            //设置元素是否可见
            holder.chat_resceive.setVisibility(View.VISIBLE);
            holder.chat_send.setVisibility(View.GONE);
            holder.chat_resceive_text.setText(chatMsg.getContent());
        } else if (chatMsg.getType() == ChatMsg.TYPE_SEND) {
            holder.chat_send.setVisibility(View.VISIBLE);
            holder.chat_resceive.setVisibility(View.GONE);
            holder.chat_send_text.setText(chatMsg.getContent());
        }
        return view;
    }
    protected class ViewHolder {

        private RelativeLayout chat_resceive;

        private RelativeLayout chat_send;

        private TextView chat_resceive_text;

        private TextView chat_send_text;

        public ViewHolder(View view) {
            chat_resceive = view.findViewById(R.id.chat_left_item_main);
            chat_send = view.findViewById(R.id.chat_right_item_main);

            chat_resceive_text = view.findViewById(R.id.char_receive_text);
            chat_send_text = view.findViewById(R.id.chat_send_text);
        }
    }
}
