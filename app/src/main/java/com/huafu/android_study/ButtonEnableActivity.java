package com.huafu.android_study;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.huafu.android_study.databinding.ActivityButtonEnableBinding;

public class ButtonEnableActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_enable);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int vid = view.getId();
        switch (vid) {
            case R.id.btn1:
                btn3.setEnabled(true);
                btn3.setTextColor(Color.BLACK);
                break;
            case R.id.btn2:
                btn3.setEnabled(false);
                btn3.setTextColor(Color.GRAY);
                break;
            case R.id.btn3:
                Log.d("ss","能点击");
                btn3.setTextColor(ContextCompat.getColor(this, R.color.purple_200));
                break;
        }





    }
}