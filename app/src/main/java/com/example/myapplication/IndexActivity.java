package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class IndexActivity extends FragmentActivity implements Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

    }

    @Override
    public void onItemSelected(int id) {
        Intent intent;
        switch (id){
            case 0:
                    intent = new Intent(this,ItemActivity.class);
                    intent.putExtra("url","");
                    startActivity(intent);
            case 1:
        }

    }
}
