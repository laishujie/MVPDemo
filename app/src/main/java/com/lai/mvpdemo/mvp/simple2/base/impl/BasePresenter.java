package com.lai.mvpdemo.mvp.simple2.base.impl;

import com.lai.mvpdemo.mvp.simple2.base.IPresenter;
import com.lai.mvpdemo.mvp.simple2.base.IView;

/**
 * @author Lai
 * @time 2017/12/10 16:32
 * @describe BasePresenter
 */

public abstract class BasePresenter<V extends IView> implements IPresenter<V> {

    //Model数据
    // protected M mModel;
    //View 显示回显的接口
    protected V mRootView;

    public BasePresenter() {
        onStart();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {
        this.mRootView = null;
    }

    @Override
    public void attachView(V view) {
        this.mRootView = view;
    }

    @Override
    public V getView() {
        return mRootView;
    }


}
