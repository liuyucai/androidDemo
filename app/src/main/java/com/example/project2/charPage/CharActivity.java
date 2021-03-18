package com.example.project2.charPage;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.project2.R;
import com.example.project2.adapter.ChatAdapter;
import com.example.project2.adapter.EmojisPagerAdapter;
import com.example.project2.adapter.MyFragmentPagerAdapter;
import com.example.project2.model.ChatMsg;
import com.example.project2.model.EmojiEntity;
import com.example.project2.utils.FileUtil;
import com.example.project2.utils.JsonParseUtil;

import java.util.ArrayList;
import java.util.List;

//每创建一个新增加的AppCompatActivity类，需要在AndroidManifest.xml配置该类

public class CharActivity extends AppCompatActivity {


    private ChatAdapter chatAdapter;

    private EmojisPagerAdapter emojisPagerAdapter;

    private ViewPager charVpager;

    private List<ChatMsg> msgs = new ArrayList<ChatMsg>();
    private ListView lv;
    private TextView et_chat_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        Typeface font = Typeface.createFromAsset(getAssets(), "icons/iconfont.ttf");

        TextView chat_back_icon = (TextView)findViewById(R.id.chat_back_icon);
        chat_back_icon.setTypeface(font);
        chat_back_icon.setTextSize(40); //设置大小
        chat_back_icon.setTextColor(Color.parseColor("#cccccc")); //设置颜色
        chat_back_icon.setText(getResources().getString(R.string.back_font));

        TextView voice_font_textView = (TextView)findViewById(R.id.voice_font_textView);
        voice_font_textView.setTypeface(font);
        voice_font_textView.setTextSize(24); //设置大小
        voice_font_textView.setTextColor(Color.parseColor("#ffffff")); //设置颜色
        voice_font_textView.setText(getResources().getString(R.string.voice_open_font));

        TextView emojis_font_textView = (TextView)findViewById(R.id.emojis_font_textView);
        emojis_font_textView.setTypeface(font);
        emojis_font_textView.setTextSize(24); //设置大小
        emojis_font_textView.setTextColor(Color.parseColor("#ffffff")); //设置颜色
        emojis_font_textView.setText(getResources().getString(R.string.emojis_open_font));

        TextView char_image_container_tv = (TextView)findViewById(R.id.char_image_container_tv);
        char_image_container_tv.setTypeface(font);
        char_image_container_tv.setTextSize(24); //设置大小
        char_image_container_tv.setTextColor(Color.parseColor("#cccccc")); //设置颜色
        char_image_container_tv.setText(getResources().getString(R.string.pic_font));

        TextView char_emojis_container_tv = (TextView)findViewById(R.id.char_emojis_container_tv);
        char_emojis_container_tv.setTypeface(font);
        char_emojis_container_tv.setTextSize(24); //设置大小
        char_emojis_container_tv.setTextColor(Color.parseColor("#cccccc")); //设置颜色
        char_emojis_container_tv.setText(getResources().getString(R.string.emojis_open_font));

        TextView char_collect_emojis_container_tv = (TextView)findViewById(R.id.char_collect_emojis_container_tv);
        char_collect_emojis_container_tv.setTypeface(font);
        char_collect_emojis_container_tv.setTextSize(24); //设置大小
        char_collect_emojis_container_tv.setTextColor(Color.parseColor("#cccccc")); //设置颜色
        char_collect_emojis_container_tv.setText(getResources().getString(R.string.collect_font));

        msgs.add(new ChatMsg());
        chatAdapter = new ChatAdapter(CharActivity.this,msgs);
        TextView tv_send = findViewById(R.id.tv_send);
        lv = findViewById(R.id.chat_listView);
        et_chat_input = findViewById(R.id.et_chat_message);
        final TextView et_chat_message = findViewById(R.id.et_chat_message);

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
                    Toast.makeText(CharActivity.this, "请输入内容!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void gotoBack(View v){
        this.finish();
    }

    @SuppressLint("WrongConstant")
    public void emojis_state_fun(View v){
        LinearLayout emojis_container = (LinearLayout) this.findViewById(R.id.emojis_container);

//        VISIBLE:0  意思是可见的
//        INVISIBILITY:4 意思是不可见的，但还占着原来的空间
//        GONE:8  意思是不可见的，不占用原来的布局空间
        int emojis_container_state = emojis_container.getVisibility();
        if(emojis_container_state == 8){
            emojis_container.setVisibility(0);

            emojisPagerAdapter = new EmojisPagerAdapter(getSupportFragmentManager());
            charVpager = (ViewPager) findViewById(R.id.char_vp);
            charVpager.setAdapter(emojisPagerAdapter);
            charVpager.setCurrentItem(0);
        }else{
            emojis_container.setVisibility(8);
        }
    }

    public void emojisTypePageClickEvent(View v){
        String pageNumber = (String) v.getTag();
        switch (pageNumber) {
            case "0":
                break;
            case "1":
                charVpager.setCurrentItem(0);
                break;
            case "2":
                charVpager.setCurrentItem(1);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addEmojis(View v){
        String msg = et_chat_input.getText().toString();
        et_chat_input.setText(msg+(String)v.getTag());
    }

}