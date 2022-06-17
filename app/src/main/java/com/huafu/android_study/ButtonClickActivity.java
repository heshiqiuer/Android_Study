package com.huafu.android_study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonClickActivity extends AppCompatActivity {

    private Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);
        mbutton = findViewById(R.id.btn);
//        mbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("点击了按钮");
//                Log.d("btnclick","点击了按钮");
//                Toast.makeText(ButtonClickActivity.this, "点击了按钮", Toast.LENGTH_SHORT).show();
//            }
//        });
        mbutton.setOnClickListener(new MyOnClickListener());

        mbutton.setOnLongClickListener(view -> {
            Log.d("longPress","长按了");
            return true;
        });
    }

    static class  MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Log.d("btnclick","点击了按钮");
        }
    }

}