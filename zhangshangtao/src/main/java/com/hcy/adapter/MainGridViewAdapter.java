package com.hcy.adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hcy.zhangshangtao.R;

/**
 * Created by Mr.He on 2016/4/19.
 */
public class MainGridViewAdapter extends BaseAdapter{//主页GridView适配器
    public int[] images=new int[6];
    public String[] text=new String[6];

    public String[] color={"#6EA4EA","#FD7965","#CB8EBF","#F2A33C","#53BCB5","#A3BD1C","#e6cd13"};
    public Context context;

    public MainGridViewAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.main_gridview_item,parent,false);
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.main_gridView_image);
            viewHolder.textView= (TextView) convertView.findViewById(R.id.main_gridView_text);
            //保存
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
//        //显示数据
//        viewHolder.imageView.setImageResource(images[position]);
//        viewHolder.textView.setText(text[position]);
        viewHolder.textView.setBackgroundColor(Color.parseColor(color[position]));
        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
