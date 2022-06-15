package com.huafu.android_study;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import java.util.function.Supplier;

public class MainActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Supplier<String> supplier = ()-> "hello";
        System.out.println(supplier.get());
    }
}