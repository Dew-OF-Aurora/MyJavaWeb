package com.aurora.javaweb.adapter2;

import com.aurora.javaweb.MyInterface;

public abstract class UserAdapter implements MyInterface{
    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }


    /*
    * userService主要使用的方法是core方法
    * 抽象出来的方法就是service中要实现的方法
     */
    @Override
    public abstract void core();
}
