package com.example.qhsj.mydatabindingtest.observablefield;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by Chris on 2017/5/22.
 * 这时候自带get 和 set 方法，我们没有必要再去生成这些方法
 */
public class UserModel {
    public final ObservableField<String> userName = new ObservableField<>();
    public final ObservableField<String> userPassword = new ObservableField<>();
    public final ObservableField<String> userInfo = new ObservableField<>();

}
