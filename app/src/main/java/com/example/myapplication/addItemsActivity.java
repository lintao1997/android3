package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class addItemsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText6;
    private EditText editText8;
    private EditText editText9;
    private EditText editText10;
    private Button button4;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button4:
                String name = editText6.getText().toString();
                String desc = editText8.getText().toString();
                String remark = editText9.getText().toString();
                String price = editText10.getText().toString();
                Map<String, String> map = new HashMap<>();
                map.put("itemName", name);
                map.put("itemDesc", desc);
                map.put("itemRemark", remark);
                map.put("initPrice", price);
                map.put("kindId", "1");
                map.put("avail", "1");
                try {
                    String result = okHttpUtil.postRequest("http://172.18.85.254:8080/auction/api/items", map);
                    Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    
                }
                break;
            case R.id.button5:
                Intent intent = new Intent(this,ItemActivity.class);
                startActivity(intent);
                break;
        }
    }


    private void initView() {
        editText6 = (EditText) findViewById(R.id.editText6);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);

        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    private void submit() {
        // validate
        String editText6String = editText6.getText().toString().trim();
        if (TextUtils.isEmpty(editText6String)) {
            Toast.makeText(this, "editText6String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String editText8String = editText8.getText().toString().trim();
        if (TextUtils.isEmpty(editText8String)) {
            Toast.makeText(this, "editText8String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String editText9String = editText9.getText().toString().trim();
        if (TextUtils.isEmpty(editText9String)) {
            Toast.makeText(this, "editText9String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String editText10String = editText10.getText().toString().trim();
        if (TextUtils.isEmpty(editText10String)) {
            Toast.makeText(this, "请输入数字哦", Toast.LENGTH_SHORT).show();
            return;
        }


        // TODO validate success, do something


    }
}
