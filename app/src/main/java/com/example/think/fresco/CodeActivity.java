package com.example.think.fresco;

import android.Manifest;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.example.demonstrate.DemonstrateUtil;
import com.example.demonstrate.DialogUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.joker.annotation.PermissionsGranted;
import com.joker.api.Permissions4M;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zxn on 2018-11-12 16:55:54.
 */
public class CodeActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private static final int READ_EXTERNAL_CODE = 100;
    @BindView(R.id.sdv_image)
    SimpleDraweeView sdvImage;
    private String mFileImagepath;
    private boolean mIsFileFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        ButterKnife.bind(this);

        //sdvImage.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.mipmap.icon_failure)).build());

    }

    @OnClick(R.id.btn_select_image_source)
    public void onViewClicked() {
        DialogUtil.showListDialog(this, getString(R.string.text_select_image_source), items, this);
    }

    String[] items = {"选择res目录下图片方式1",
            "选择res目录下图片方式2",
            "选择res目录下图片方式3",
            "加载本地asset方式1",
            "加载本地asset方式2",
            "加载本地文件方式1",
            "加载本地文件方式2",
            "加载远程图片方式1",
    };

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case 0:
                sdvImage.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.mipmap.img_res1)).build());
                break;
            case 1:
                sdvImage.setImageURI(Uri.parse("res:///" + R.mipmap.img_res2));
                break;
            case 2:
                sdvImage.setImageURI(Uri.parse("res://" + getPackageName() + "/" + R.mipmap.img_res3));
                break;
            case 3:
                sdvImage.setImageURI((new Uri.Builder()).scheme("asset").path("image/img_asset1.jpg").build());
                break;
            case 4:
                sdvImage.setImageURI(Uri.parse("asset:///image/img_asset2.jpg"));
                break;
            case 5:
                mFileImagepath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/img_file1.jpg";
                DemonstrateUtil.showLogResult(mFileImagepath);
                mIsFileFirst = true;
                //-->   /storage/emulated/0--->***
                Permissions4M.get(this)
                        .requestPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .requestCodes(READ_EXTERNAL_CODE)
                        .request();
                break;
            case 6:
                mFileImagepath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/img_file2.jpg";
                DemonstrateUtil.showLogResult(mFileImagepath);
                mIsFileFirst = false;
                Permissions4M.get(this)
                        .requestPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .requestCodes(READ_EXTERNAL_CODE)
                        .request();

                break;
            case 7:
                sdvImage.setImageURI(Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542467972770&di=1fd94acb2f06c600a9cd96a2875414e0&imgtype=0&src=http%3A%2F%2Fpic26.nipic.com%2F20121219%2F7447430_180412467000_2.jpg"));
                break;
        }
    }

    @PermissionsGranted(READ_EXTERNAL_CODE)
    public void granted() {
        if (mIsFileFirst) {
            sdvImage.setImageURI(Uri.parse("file://" + mFileImagepath));
        } else {
            sdvImage.setImageURI((new Uri.Builder()).scheme("file").path(mFileImagepath).build());
        }
    }
}
