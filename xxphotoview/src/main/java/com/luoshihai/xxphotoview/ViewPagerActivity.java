package com.luoshihai.xxphotoview;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by liuheng on 2015/8/19.
 */
public class ViewPagerActivity extends Activity {

    private ViewPager mPager;
    private ArrayList<String> images;
    private int position;
    private TextView tv_pageIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        View view = View.inflate(this, R.layout.activity_view_pager, null);
        setContentView(view);
        images = getIntent().getStringArrayListExtra("mDatas");
        position = getIntent().getIntExtra("position", 0);
        tv_pageIndex = ((TextView) findViewById(R.id.tv_pageIndex));
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setPageMargin((int) (getResources().getDisplayMetrics().density * 15));
        tv_pageIndex.setText((position + 1) + "/" + images.size());

        mPager.setAdapter(pagerAdapter);
        mPager.setOnPageChangeListener(onPageChangeListener);

        mPager.setCurrentItem(position);
    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            tv_pageIndex.setText((position + 1) + "/" + images.size());
        }
    };


    PagerAdapter pagerAdapter = new PagerAdapter() {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View inflate = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_img, null);
            PhotoView view = (PhotoView) inflate.findViewById(R.id.img1);
            view.enable();
            String s = images.get(position);
            view.setOnSinglClick(onSinglClick);
            view.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Glide.with(ViewPagerActivity.this).load(s).placeholder(R.drawable.loading).into(view);
            container.addView(inflate);
            return inflate;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    };
    private PhotoView.OnSinglClick onSinglClick = new PhotoView.OnSinglClick() {
        @Override
        public void onSingleClick() {
            if (mPager != null) mPager = null;
            if (pagerAdapter != null) pagerAdapter = null;
            finish();
        }
    };


}
