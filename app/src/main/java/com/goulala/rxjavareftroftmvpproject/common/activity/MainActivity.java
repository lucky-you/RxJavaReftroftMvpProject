package com.goulala.rxjavareftroftmvpproject.common.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.goulala.rxjavareftroftmvpproject.R;

import io.reactivex.Observable;

/**
 * 程序的主入口
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
