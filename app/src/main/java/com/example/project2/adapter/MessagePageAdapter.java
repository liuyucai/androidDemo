package com.example.project2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project2.R;
import com.example.project2.model.MessageData;
import com.example.project2.model.NewsData;

import java.util.ArrayList;
import java.util.List;

public class MessagePageAdapter extends BaseAdapter {

    private List<MessageData> datas = new ArrayList<MessageData>();//新闻列表集合

    private Context context;
    private LayoutInflater layoutInflater;

    public MessagePageAdapter(Context context, List<MessageData> datas) {
        this.datas = datas;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size(); //返回列表的长度
    }

    @Override
    public MessageData getItem(int position) {
        return datas.get(position); //通过列表的位置 获得集合中的对象
    }

    @Override
    public long getItemId(int position) { // 获得集合的Item的位置
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.message_page_list_item, null);//找到布局文件
            convertView.setTag(new ViewHolder(convertView));
        }
        initViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;

    }

    private void initViews(MessageData data, ViewHolder holder) {//初始化数据

        /**
         * 第一次初始话的时候通过 要请求的Url地址 为每个图片设置一个Tag标记,
         * 然后在设置图片的时候判断Tag标记如果是才把图片设置到ImageView上,
         * 这做的原因是为了防止ListView 中的图片错位...
         */
//        holder.ivImg.setTag(data.getNewsImgUrl());//设置Tag

        //设置新闻标题为集合中获得的标题
        holder.tvTitle.setText(data.getNewsTitle());

//        设置新闻发布时间为集合中获得的发布时间
        holder.tvDate.setText(data.getNewsDate());

        //通过集合中的图片地址获得图片并且设置到view上
        holder.ivImg.setImageResource(R.drawable.p1);

    }

    protected class ViewHolder {
        private ImageView ivImg;
        private TextView tvTitle;
        private TextView tvDate;

        public ViewHolder(View view) {
            ivImg = (ImageView) view.findViewById(R.id.message_page_iv_img);
            tvTitle = (TextView) view.findViewById(R.id.message_page_tv_title);
            tvDate = (TextView) view.findViewById(R.id.message_page_tv_date);
        }
    }

}