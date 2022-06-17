package com.huafu.android_study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.huafu.android_study.util.DateUtil;

public class ButtonStyleActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_style);

        result = findViewById(R.id.result1);

    }

    public void onClick(View view) {
        String desc = String.format("%s  您点击了按钮", DateUtil.getNowTime());
        result.setText(desc);
        Log.d("test",desc);
    }
}