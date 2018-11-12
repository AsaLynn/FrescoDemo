package com.example.think.fresco;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zxn on 2018-11-12 16:55:54.
 */
public class CodeActivity extends AppCompatActivity {

    @BindView(R.id.sdv_image)
    SimpleDraweeView sdvImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        ButterKnife.bind(this);

        //Uri uri = Uri.parse("res://包名(实际可以是任何字符串甚至留空)/" + R.drawable.ic_launcher);


        //加载本地图片              "res://包名/"+R.mipmap.图片id
//        Uri uri = Uri.parse("res://com.xxx.xxx/" + R.mipmap.photo);
//        userIcon.setImageURI(uri);

        //portrait.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.more)).build());

        //icon_failure
        sdvImage.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.mipmap.icon_failure)).build());


        //加载本地图片              "res://包名/"+R.mipmap.图片id
//        Uri uri = Uri.parse("res://com.example.think.fresco/" + R.mipmap.icon_failure);
//        sdvImage.setImageURI(uri);
        //sdvImage.setImageResource(R.mipmap.icon_failure);


    }
}
