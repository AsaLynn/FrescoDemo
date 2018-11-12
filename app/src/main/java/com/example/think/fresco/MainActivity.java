package com.example.think.fresco;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.demonstrate.DialogUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView simpleDraweeView;
    private SimpleDraweeView simpleDraweeView1;
    private SimpleDraweeView simpleDraweeView2;
    private SimpleDraweeView simpleDraweeView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建SimpleDraweeView对象
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.main_sdv);
        simpleDraweeView1 = (SimpleDraweeView) findViewById(R.id.main_sdv1);
        simpleDraweeView2 = (SimpleDraweeView) findViewById(R.id.main_sdv2);
        simpleDraweeView3 = (SimpleDraweeView) findViewById(R.id.main_sdv3);

        initView();
    }

    private void initView() {

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = "Fresco的使用!";
                String[] items = {
                        "0加载占位图",
                        "1加载失败图",
                        "2加载失败重新加载",
                        "3加载淡入淡出动画",
                        "4加载,带有背景图—backgroundImage",
                        "5加载,带有叠加图—overlayImage",
                        "6加载,圆形图—roundAsCircle",
                        "7加载,圆角图—roundedCornerRadius",
                        "8加载,圆角图—部分不是圆角",
                        "9加载,圆形圆角边框宽度及颜色—roundingBorder",
                        "10加载,圆形或圆角图像底下的叠加颜色—roundWithOverlayColor",

                };
                DialogUtil.showListDialog(MainActivity.this, title, items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                show0();
                                break;
                            case 1:
                                show1();
                                break;
                            case 2:
                                show2();
                                break;
                            case 3:
                                show3();
                                break;
                            case 4:
                                show4();
                                break;
                            case 5:
                                //叠加图在最上面，覆盖了下面的图。
                                show5();
                                break;
                            case 6:
                                //加载图片设置成圆形的图片
                                show6();
                                break;
                            case 7:
                                show7();
                                break;
                            case 8:
                                show8();
                                break;
                            case 9:
                                show9();
                                break;
                            case 10:
                                show10();
                                break;
                        }
                    }
                });
            }
        });

    }

    private void show10() {
        SimpleDraweeView view = (SimpleDraweeView) findViewById(R.id.main_sdv10);
        Uri imageUri = Uri.parse("http://img.mp.sohu.com/upload/20170807/a2fb82d180bd480390a2198f154c6267_th.png");
        view.setVisibility(View.VISIBLE);
        view.setImageURI(imageUri);
    }

    private void show9() {
        SimpleDraweeView view = (SimpleDraweeView) findViewById(R.id.main_sdv9);
        Uri imageUri = Uri.parse("http://img.mp.sohu.com/upload/20170807/a2fb82d180bd480390a2198f154c6267_th.png");
        view.setVisibility(View.VISIBLE);
        view.setImageURI(imageUri);
        
    }

    private void show8() {
        /*
        fresco:roundTopLeft="false"
        fresco:roundTopRight="false"
        fresco:roundBottomLeft="false"
        fresco:roundBottomRight="false"

         */
        SimpleDraweeView view = (SimpleDraweeView) findViewById(R.id.main_sdv8);
        Uri imageUri = Uri.parse("http://img.mp.sohu.com/upload/20170807/a2fb82d180bd480390a2198f154c6267_th.png");
        view.setVisibility(View.VISIBLE);
        view.setImageURI(imageUri);
    }

    private void show7() {
        SimpleDraweeView view = (SimpleDraweeView) findViewById(R.id.main_sdv7);
        Uri imageUri = Uri.parse("http://img.mp.sohu.com/upload/20170807/a2fb82d180bd480390a2198f154c6267_th.png");
        view.setVisibility(View.VISIBLE);
        view.setImageURI(imageUri);
    }

    private void show6() {
        SimpleDraweeView view = (SimpleDraweeView) findViewById(R.id.main_sdv6);
        Uri imageUri = Uri.parse("http://img.mp.sohu.com/upload/20170807/a2fb82d180bd480390a2198f154c6267_th.png");
        view.setVisibility(View.VISIBLE);
        view.setImageURI(imageUri);
    }

    private void show5() {
        SimpleDraweeView view = (SimpleDraweeView) findViewById(R.id.main_sdv5);
        Uri imageUri = Uri.parse("http://img.mp.sohu.com/upload/20170807/a2fb82d180bd480390a2198f154c6267_th.png");
        view.setVisibility(View.VISIBLE);
        view.setImageURI(imageUri);
    }

    private void show4() {
        SimpleDraweeView simpleDraweeView4 = (SimpleDraweeView) findViewById(R.id.main_sdv4);
        Uri imageUri = Uri.parse("http://img.mp.sohu.com/upload/20170807/a2fb82d180bd480390a2198f154c6267_th.png");
        simpleDraweeView4.setVisibility(View.VISIBLE);
        simpleDraweeView4.setImageURI(imageUri);
    }

    private void show3() {
        //淡入淡出动画—fadeDuration
        Uri imageUri = Uri.parse("http://img.mp.sohu.com/upload/20170807/a2fb82d180bd480390a2198f154c6267_th.png");
        simpleDraweeView3.setVisibility(View.VISIBLE);
        simpleDraweeView3.setImageURI(imageUri);
    }

    private void show2() {
        simpleDraweeView2.setVisibility(View.VISIBLE);
        Uri imageUri2 = Uri.parse("http://img.mp.sohu.com/upload/2017/th.png");
        simpleDraweeView2.setImageURI(imageUri2);
        //创建DraweeController
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                //加载的图片URI地址
                .setUri(imageUri2)
                //设置点击重试是否开启
                .setTapToRetryEnabled(true)
                //设置旧的Controller
                .setOldController(simpleDraweeView2.getController())
                //构建
                .build();
        //设置DraweeController
        simpleDraweeView2.setController(controller);
    }

    private void show1() {
        Uri imageUri = Uri.parse("http://img.mp.sohu.com/upload/2017/th.png");
        simpleDraweeView1.setVisibility(View.VISIBLE);
        simpleDraweeView1.setImageURI(imageUri);
    }

    private void show0() {
        simpleDraweeView.setVisibility(View.VISIBLE);
        Uri imageUri = Uri.parse("http://img.mp.sohu.com/upload/20170807/a2fb82d180bd480390a2198f154c6267_th.png");
        simpleDraweeView.setImageURI(imageUri);
    }
}
