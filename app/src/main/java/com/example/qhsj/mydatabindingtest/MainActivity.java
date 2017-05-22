package com.example.qhsj.mydatabindingtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.qhsj.mydatabindingtest.baseobservable.DataBindingActivity;
import com.example.qhsj.mydatabindingtest.bindingadapter.DataBindingActivity3;
import com.example.qhsj.mydatabindingtest.observablefield.DataBindingActivity2;

/**
 * Created by Chris on 2017/5/22.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private Button viewById;
    private Button mBtnBaseObservable;
    private Button mBtnObservableField;
    private Button mBtnBindingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initListener() {
        mBtnBaseObservable.setOnClickListener(this);
        mBtnObservableField.setOnClickListener(this);
        mBtnBindingAdapter.setOnClickListener(this);
    }

    private void initView() {
        mBtnBaseObservable = (Button) findViewById(R.id.btnBaseObservable);
        mBtnObservableField = (Button) findViewById(R.id.btnObservableField);
        mBtnBindingAdapter = (Button) findViewById(R.id.btnBindingAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()  ) {
            case R.id.btnBaseObservable:
                startActivity(new Intent(MainActivity.this,DataBindingActivity.class));
                break;
            case R.id.btnObservableField:
                startActivity(new Intent(MainActivity.this,DataBindingActivity2.class));
                break;
            case R.id.btnBindingAdapter:
                startActivity(new Intent(MainActivity.this,DataBindingActivity3.class));
                break;
        }
    }
}
