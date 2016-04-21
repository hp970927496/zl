package com.hcy.zhangshangtao;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.hcy.adapter.DrawerLayout_listView_adapter;
import com.hcy.adapter.FragmentViewPagerAdapter;
import com.hcy.fragment.Fragment_main_home;
import com.hcy.fragment.Fragment_main_me;
import com.hcy.fragment.Fragment_main_publish;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //定义组件
    LinearLayout bottom_main_homePage,bottom_main_askToBuy,bottom_main_publish,
            bottom_main_news,bottom_main_me;
    FrameLayout main_fragment_frameLayout;
    //定义一个碎片管理器
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainExit.addActivity(this);
        //获取组件
        bottom_main_homePage= (LinearLayout) findViewById(R.id.bottom_main_homePage);
        bottom_main_askToBuy= (LinearLayout) findViewById(R.id.bottom_main_askToBuy);
        bottom_main_publish= (LinearLayout) findViewById(R.id.bottom_main_publish);
        bottom_main_me= (LinearLayout) findViewById(R.id.bottom_main_me);
        main_fragment_frameLayout= (FrameLayout) findViewById(R.id.main_Fragment_FrameLayout);
        //注册点击事件
        bottom_main_homePage.setOnClickListener(this);
        bottom_main_askToBuy.setOnClickListener(this);
        bottom_main_publish.setOnClickListener(this);
        bottom_main_me.setOnClickListener(this);
        //获取碎片管理器
        fragmentManager=getSupportFragmentManager();
        //首先显示首页
        fragmentManager.beginTransaction().add(R.id.main_Fragment_FrameLayout,new Fragment_main_home(),"home").commit();
    }

    //点击搜索按钮
    public void IB_search(View view){

    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bottom_main_homePage:
                //发布页面(是他的实例)
                fragmentManager.beginTransaction()
                        .replace(R.id.main_Fragment_FrameLayout, new Fragment_main_home()).commit();
                break;
            case R.id.bottom_main_askToBuy:

                break;
            case R.id.bottom_main_publish:
                //发布页面
                fragmentManager.beginTransaction()
                        .replace(R.id.main_Fragment_FrameLayout, new Fragment_main_publish()).commit();
                break;
            case R.id.bottom_main_news:
                break;
            case R.id.bottom_main_me:
                //发布页面
                fragmentManager.beginTransaction()
                        .replace(R.id.main_Fragment_FrameLayout,new Fragment_main_me()).commit();
                break;
        }
    }

    //退出程序
    long time=0;
    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis()-time<2000){
            MainExit.exit();
        }else{
            time=System.currentTimeMillis();
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
        }
    }
}
