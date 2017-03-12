package com.luoshihai.xxphotoview;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by liuheng on 2015/6/21.
 */
public class ImgActivity extends AppCompatActivity {


    private String url;
    private boolean isallowRotate;
    private PhotoView mPhotoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        url = getIntent().getStringExtra("url");
        isallowRotate = getIntent().getBooleanExtra("isallowRotate", false);
        mPhotoView = (PhotoView) findViewById(R.id.img1);
        mPhotoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        mPhotoView.setOnSinglClick(onSinglClick);
        mPhotoView.setAllowRotate(isallowRotate);
        mPhotoView.enable();

        mPhotoView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("NewApi")
            @Override
            public void onGlobalLayout() {
                Glide.with(ImgActivity.this).load(url).placeholder(R.drawable.loading).into(mPhotoView);
                mPhotoView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });


    }


    PhotoView.OnSinglClick onSinglClick = new PhotoView.OnSinglClick() {
        @Override
        public void onSingleClick() {
            finish();
        }
    };

}
