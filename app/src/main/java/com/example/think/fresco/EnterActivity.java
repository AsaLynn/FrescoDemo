package com.example.think.fresco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zxn on 2018-11-12 16:52:19.
 */
public class EnterActivity extends AppCompatActivity {

    @BindView(R.id.btn0)
    Button btn0;
    @BindView(R.id.btn1)
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn0, R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn0:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btn1:
                startActivity(new Intent(this, CodeActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this, GifActivity.class));
                break;
        }
    }
}
