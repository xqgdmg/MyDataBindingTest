package com.example.qhsj.mydatabindingtest.bindingadapter;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qhsj.mydatabindingtest.R;

import java.util.ArrayList;

/**
 * Created by Chris on 2017/5/22.
 * 动态添加布局
 */
public class NamesViewModel {

     // app:context="@{viewModel.context}"
     // 布局中需要用到
    public Context context;

     // 可被观察的集合
    public final ObservableArrayList<String> names = new ObservableArrayList<>();

    public NamesViewModel(Context context) {
        names.add("111");
        names.add("222");
        names.add("333");
        names.add("444");
        names.add("555");

        this.context = context;
    }

    /*
     * 这个初始化的值可以显示
     * 绑定了 names 和 context
     *
     * 出现两个警告:
     * Error:(41, 24) 警告: Application namespace for attribute bind:names will be ignored.
     * Error:(41, 24) 警告: Application namespace for attribute bind:context will be ignored.
     */
    @BindingAdapter({"bind:names", "bind:context"})
    public static void setNames(ViewGroup linearLayout, ArrayList<String> names, Context context) {

         // 先移除
        linearLayout.removeAllViews();

         // ViewGroup 上添加布局
        for (String s : names) {
            TextView t = new TextView(context);
            t.setText(s);
            linearLayout.addView(t);
        }
    }

    /*
     * 点击事件也是可以响应
     */
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.add_btn) {
            names.add("add_btn");
        }
    }
}
