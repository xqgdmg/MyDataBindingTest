package com.example.qhsj.mydatabindingtest.observablefield;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.example.qhsj.mydatabindingtest.R;
import com.example.qhsj.mydatabindingtest.baseobservable.UserViewModel;
import com.example.qhsj.mydatabindingtest.databinding.TestFieldLayoutBinding;

/**
 * Created by Chris on 2017/5/22.
 */
public class DataBindingActivity2 extends Activity implements View.OnClickListener {

    private TestFieldLayoutBinding mBinding;
    private UserModel mViewModel;
    private int mCount = 0;
    private int mCount1 = 0;
    private int mCount2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_field_layout);

        initView();

        initListener();

    }

    private void initListener() {
        mBinding.btnChangUserName.setOnClickListener(this);
        mBinding.btnChangPassword.setOnClickListener(this);
    }

    private void initView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.test_field_layout);

        // viewmodel
        mViewModel = new UserModel();
        mBinding.setUserViewModel(mViewModel);

        mViewModel.userName.set("name");
        mViewModel.userPassword.set("passWord");

         // 动态更新直接在 xml 中添加的
        String userName = mViewModel.userName.get();
        String userPassword = mViewModel.userPassword.get();
        mViewModel.userInfo.set(userName + userPassword);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnChangUserName:
                mCount1 = mCount1 + 1;
                mViewModel.userName.set("name" + mCount1);

//                mViewModel.notifyAll(); // 一共有三个这样的刷新方法，这个会报错
                break;
            case R.id.btnChangPassword:
                mCount2 = mCount2 + 1;
                mViewModel.userPassword.set("passWord" + mCount2);

//                mViewModel.notify(); // 一共有三个这样的刷新方法，这个也会报错
                break;
        }
    }
}
