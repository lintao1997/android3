package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.ExecutionException;

import okhttp3.OkHttp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void testgetRequest(View view ) throws ExecutionException, InterruptedException {
        System.out.println( okHttpUtil.getRequest("https://www.baidu.com"));
    }
}
