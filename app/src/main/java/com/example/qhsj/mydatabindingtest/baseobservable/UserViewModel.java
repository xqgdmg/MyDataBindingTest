package com.example.qhsj.mydatabindingtest.baseobservable;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Chris on 2017/5/22.
 * BaseObservable 为了实现动态更新
 * get 方法中有 @Bindable
 */
public class UserViewModel extends BaseObservable{
    private String firstName;
    private String lastName;
    private String displayName ; // 这里设置默认值是没有用的，默认值是 firstName + lastName


//      @Bindable 可以放在 public 之前或之后，但是不能放在 String 之后。
//    这种方式，框架会自动生成 getFirstName() 方法。注意，此时变量的访问权限必须是 public。
//    如果 @Bindable 修饰的变量和 @Bindable 修饰的该变量的 getter 方法同时存在，则 getter 方法失效。
//    而如果使用 public @Bindable String displayName;，由于 get 方法是框架自动生成的，方法体是 return displayName;， 我们将无法做到这种效果。

    public @Bindable String autoName; // 这种方式，框架会自动生成 getFirstName() 方法。注意，此时变量的访问权限必须是 public ???

    public UserViewModel(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
        notifyPropertyChanged(com.example.qhsj.mydatabindingtest.BR.firstName); // 难道 set 之后不会更新？这个什么意思？？
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
        notifyPropertyChanged(com.example.qhsj.mydatabindingtest.BR.lastName);
    }

     // 这是前后两个名字拼接起来的，一个变化的话，这个会自动变化
     // 居然只有第一次进来的时候才会自动设置？？？？
     // UI 上 这个东西不会自动变化？？？
     @Bindable
     public String getDisplayName() {
         return firstName + "-" + lastName;
     }

     // 这个是默认的设置方法，会被覆盖掉，存在 getDisplayName ，无法通过这个赋值
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
        notifyPropertyChanged(com.example.qhsj.mydatabindingtest.BR.displayName);
    }

     /*
      * 实现改动 firstName 或者 lastName 的时候  displayName 自动更新
      *
      * 类似：
      * mViewModel.setLastName("勒布朗");
      * mViewModel.notifyChange();
      */

}
