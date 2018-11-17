package com.example.think.fresco;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zxn on 2018-11-16 21:30:22.
 */
public class GifActivity extends AppCompatActivity {

    private static final String TAG = "GifActivity";
    private static final String IMG_URL = "http://img.huofar.com/data/jiankangrenwu/shizi.gif";
    @BindView(R.id.my_image_view)
    SimpleDraweeView myImageView;

    ControllerListener controllerListener = new ControllerListener() {

        @Override
        public void onSubmit(String id, Object callerContext) {
            Log.i(TAG, "*-->onSubmit: id" + id);
        }

        @Override
        public void onFinalImageSet(String id, @Nullable Object imageInfo, @Nullable Animatable animatable) {
            Log.i(TAG, "*-->onFinalImageSet: id" + id);
        }

        @Override
        public void onIntermediateImageSet(String id, @Nullable Object imageInfo) {
            Log.i(TAG, "*-->onIntermediateImageSet: id" + id);
        }

        @Override
        public void onIntermediateImageFailed(String id, Throwable throwable) {
            Log.i(TAG, "*-->onIntermediateImageFailed: id" + id);
        }

        @Override
        public void onFailure(String id, Throwable throwable) {
            Log.i(TAG, "*-->onFailure: id" + id);
        }

        @Override
        public void onRelease(String id) {
            Log.i(TAG, "*-->onRelease: id=" + id);
        }
    };
    @BindView(R.id.ll_root)
    LinearLayout llRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        ButterKnife.bind(this);

        //showImage();
//        addImage();
        loadImageFromAssets();
    }

    private void showImage(boolean isAutoPlay) {
        Uri uri = Uri.parse("http://img.huofar.com/data/jiankangrenwu/shizi.gif");
        DraweeController draweeController =
                Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setAutoPlayAnimations(isAutoPlay) // 设置加载图片完成后是否直接进行播放
                        .setControllerListener(controllerListener)
                        .build();
        myImageView.setController(draweeController);
        //Fresco.shutDown();
    }

    @OnClick({R.id.btn_load_image, R.id.btn_stop, R.id.btn_add, R.id.btn_load_assets_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_load_image:
                showImage(true);
                break;
            case R.id.btn_stop:
                showImage(false);
                break;
            case R.id.btn_add:
                addImage();
                break;
            case R.id.btn_load_assets_img:
                loadImageFromAssets();
                break;
        }
    }

    private void loadImageFromAssets() {
        Uri uri = Uri.parse("http://img.huofar.com/data/jiankangrenwu/shizi.gif");
        DraweeController draweeController =
                Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setAutoPlayAnimations(true) // 设置加载图片完成后是否直接进行播放
                        .build();
        myImageView.setController(draweeController);
    }

    private void addImage() {
        SimpleDraweeView simpleDraweeView
                = new SimpleDraweeView(this);
        simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(Uri.parse(IMG_URL)).build());
        int width = getResources().getDimensionPixelSize(R.dimen.dp_300);
        int height = getResources().getDimensionPixelSize(R.dimen.dp_200);
        simpleDraweeView.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        llRoot.addView(simpleDraweeView);
    }
}
