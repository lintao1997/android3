package com.example.myapplication;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class okHttpUtil {
    static ExecutorService threadpoll = Executors.newFixedThreadPool(30);
    static OkHttpClient okHttpClient = new OkHttpClient();
    public static String getRequest(final String url) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Request request = new Request.Builder()
                .url(url)
                        .build();
                Response response = okHttpClient.newCall(request).execute();
                if(response.isSuccessful()&&response.body()!=null){
                    return response.body().string();
                }else {
                    return null;
                }
            }
        });
        threadpoll.execute(futureTask);
        return futureTask.get().toString();
    }
    public static String postRequest(final String url, Map<String,String> map) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public Object call() throws Exception {
                FormBody.Builder builder= new FormBody.Builder();
                map.forEach(builder::add);
                FormBody formBody = builder.build();
                builder.add("name","78");
                Request request = new Request.Builder()
                        .url(url)
                        .post(formBody)
                        .build();
                Response response = okHttpClient.newCall(request).execute();
                if(response.isSuccessful()&&response.body()!=null){
                    return response.body().string();
                }else {
                    return null;
                }
            }
        });
        threadpoll.execute(futureTask);
        return futureTask.get().toString();
    }

}
