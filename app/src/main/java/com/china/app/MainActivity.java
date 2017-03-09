package com.china.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.luoshihai.xxphotoview.ViewPagerActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> mdatas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdatas.add("http://pic55.nipic.com/file/20141208/19462408_171130083000_2.jpg");
        mdatas.add("http://img3.imgtn.bdimg.com/it/u=17572568,2472534097&fm=23&gp=0.jpg");
        mdatas.add("http://img0.imgtn.bdimg.com/it/u=1881341853,2194594401&fm=23&gp=0.jpg");
        mdatas.add("http://img1.imgtn.bdimg.com/it/u=2180892042,1064845699&fm=23&gp=0.jpg");
        Intent intent = new Intent(this, ViewPagerActivity.class);
        intent.putExtra("mDatas", mdatas);
        startActivity(intent);
    }
}
