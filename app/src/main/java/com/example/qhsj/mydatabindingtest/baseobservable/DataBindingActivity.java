package com.example.qhsj.mydatabindingtest.baseobservable;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.example.qhsj.mydatabindingtest.R;
import com.example.qhsj.mydatabindingtest.databinding.TestDbLayoutBinding;

/**
 * Created by Chris on 2017/5/22.
 */
public class DataBindingActivity extends Activity implements View.OnClickListener {

    private TestDbLayoutBinding mBinding;
    private UserViewModel mViewModel;
    private int mCount1 = 0;
    private int mCount2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        initListener();

    }

    private void initListener() {
        mBinding.btnChangFirstName.setOnClickListener(this);
        mBinding.btnChangLastName.setOnClickListener(this);
        mBinding.btnChangDisplayName.setOnClickListener(this);
    }

    private void initView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.test_db_layout);

        // viewmodel
        mViewModel = new UserViewModel("111","222");
        mBinding.setUserViewModel(mViewModel);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnChangFirstName){
            mCount1 = mCount1 + 1;
            mViewModel.setFirstName("詹姆斯" + mCount1);
            mViewModel.notifyChange(); // 还要自己调用这么坑爹？？？？？？？
        }else if (v == mBinding.btnChangLastName){
            mCount2 = mCount2 + 1;
            mViewModel.setLastName("勒布朗" + mCount2);
            mViewModel.notifyChange();
        }else if (v.getId() == R.id.btnChangDisplayName){
            mViewModel.setDisplayName("肖恩-罗冰逊" + mCount1); // 这个方法会被覆盖，变成了 詹姆斯-勒布朗
            mViewModel.notifyChange();
        }
    }




}
