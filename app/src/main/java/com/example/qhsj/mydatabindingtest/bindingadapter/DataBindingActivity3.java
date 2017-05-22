package com.example.qhsj.mydatabindingtest.bindingadapter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.example.qhsj.mydatabindingtest.R;
import com.example.qhsj.mydatabindingtest.databinding.TestFieldLayoutBinding;
import com.example.qhsj.mydatabindingtest.databinding.TestViewgroupLayoutBinding;
import com.example.qhsj.mydatabindingtest.observablefield.UserModel;

/**
 * Created by Chris on 2017/5/22.
 */
public class DataBindingActivity3 extends Activity implements View.OnClickListener {

    private TestViewgroupLayoutBinding mBinding;
    private NamesViewModel mViewModel;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        initListener();

    }

    private void initListener() {
        mBinding.btnAct.setOnClickListener(this);
    }

    private void initView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.test_viewgroup_layout);

        // viewmodel
        mViewModel = new NamesViewModel(this);
        mBinding.setViewModel(mViewModel);
    }

    /*
     * 不建议这样写，1.逻辑不清晰，与 mvvp相违背
     */
    @Override
    public void onClick(View v) {
         // 可以直接使用集合中的方法
        mCount = mCount + 1;
        mViewModel.names.add("act" + mCount);
    }
}
