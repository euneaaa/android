package com.koreait.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView ivImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        ivImg = findViewById(R.id.ivImg);

        String imgUrl = "https://item.kakaocdn.net/do/ff45d6bba620a0c61cdc0291ef1339728f324a0b9c48f77dbce3a43bd11ce785";
        Glide.with(this).load(imgUrl).into(ivImg);

    }
}