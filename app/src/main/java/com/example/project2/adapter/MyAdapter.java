package com.example.project2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.project2.R;
import com.example.project2.model.NewsData;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<NewsData> datas = new ArrayList<NewsData>();//新闻列表集合

    private Context context;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, List<NewsData> datas) {
        this.datas = datas;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size(); //返回列表的长度
    }

    @Override
    public NewsData getItem(int position) {
        return datas.get(position); //通过列表的位置 获得集合中的对象
    }

    @Override
    public long getItemId(int position) { // 获得集合的Item的位置
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item, null);//找到布局文件
            convertView.setTag(new ViewHolder(convertView));
        }
        initViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;

    }

    private void initViews(NewsData data, ViewHolder holder) {//初始化数据

        /**
         * 第一次初始话的时候通过 要请求的Url地址 为每个图片设置一个Tag标记,
         * 然后在设置图片的时候判断Tag标记如果是才把图片设置到ImageView上,
         * 这做的原因是为了防止ListView 中的图片错位...
         */
//        holder.ivImg.setTag(data.getNewsImgUrl());//设置Tag

        //设置新闻标题为集合中获得的标题
        holder.tvTitle.setText(data.getNewsTitle());

        //通过集合中的图片地址获得图片并且设置到view上
        holder.ivImg.setImageResource(R.drawable.p1);

    }

    protected class ViewHolder {
        private ImageView ivImg;
        private TextView tvTitle;
        private TextView video_read_font_icon;
        private TextView video_read_number;
        private TextView video_comment_font_icon;
        private TextView video_comment_number;
        private TextView video_collect_font_icon;
        private VideoView videoView;



        public ViewHolder(View view) {
            ivImg = (ImageView) view.findViewById(R.id.iv_img);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);

            Typeface font = Typeface.createFromAsset(view.getContext().getAssets(), "icons/iconfont.ttf");

            video_read_font_icon = (TextView)view.findViewById(R.id.video_read_font_icon);
            video_read_font_icon.setTypeface(font);
            video_read_font_icon.setTextSize(24); //设置大小
            video_read_font_icon.setTextColor(Color.parseColor("#ffffff")); //设置颜色
            video_read_font_icon.setText(view.getContext().getResources().getString(R.string.read_font));

            video_comment_font_icon = (TextView)view.findViewById(R.id.video_comment_font_icon);
            video_comment_font_icon.setTypeface(font);
            video_comment_font_icon.setTextSize(24); //设置大小
            video_comment_font_icon.setTextColor(Color.parseColor("#ffffff")); //设置颜色
            video_comment_font_icon.setText(view.getContext().getResources().getString(R.string.comment_font));

            video_collect_font_icon = (TextView)view.findViewById(R.id.video_collect_font_icon);
            video_collect_font_icon.setTypeface(font);
            video_collect_font_icon.setTextSize(24); //设置大小
            video_collect_font_icon.setTextColor(Color.parseColor("#ffffff")); //设置颜色
            video_collect_font_icon.setText(view.getContext().getResources().getString(R.string.itme_collect_font));

            videoView = view.findViewById(R.id.videoView);
//            videoView.setVideoPath(String.valueOf(R.raw.video1));
//            videoView.setVideoPath("android.resource://com.example.project2.adapter/" + R.raw.video1);
            videoView.setVideoURI(Uri.parse("android.resource://"+ context.getPackageName() + R.raw.video1));
            videoView.start();
        }
    }

}