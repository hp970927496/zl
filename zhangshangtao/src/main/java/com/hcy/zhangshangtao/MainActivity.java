package com.hcy.zhangshangtao;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;

import com.hcy.adapter.MainGridViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //定义组件
    AutoCompleteTextView autoCompleteTextView;
    GridView main_gridView;
    ViewPager main_viewPager;
    //轮播图片的总张数
    private int IMAGE_COUNT=6;
    //轮播的图片
    int[] imageTitle=new int[]{};
    //第一张图片的索引
    private static final int first_index=1;
    //当前图片位置
    private int currentItem=first_index;
    //
    private boolean isChanged=false;
    //用来存储轮播图片
    ArrayList<View> title_image;
    //创建Handler对象
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0x123){
                currentItem++;
                if(currentItem>IMAGE_COUNT+1){
                    currentItem=1;
                    main_viewPager.setCurrentItem(currentItem,false);
                }else{
                    main_viewPager.setCurrentItem(currentItem);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取组件
        main_gridView= (GridView) findViewById(R.id.main_gridView);
        autoCompleteTextView= (AutoCompleteTextView) findViewById(R.id.auto_textView_search);
        main_viewPager= (ViewPager) findViewById(R.id.titleViewPager);
        //
        initView();
    }

    //初始化视图
    public void initView(){
        main_gridView.setAdapter(new MainGridViewAdapter(this));
    }

    //点击菜单按钮
    public void IB_menu(View view){

    }

    //点击搜索按钮
    public void IB_search(View view){

    }


}
