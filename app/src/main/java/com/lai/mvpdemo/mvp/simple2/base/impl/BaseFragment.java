package com.lai.mvpdemo.mvp.simple2.base.impl;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lai.mvpdemo.mvp.simple2.base.IPresenter;
import com.lai.mvpdemo.mvp.simple2.base.IView;

/**
 * @author Lai
 * @time 2017/9/1 9:53
 * @describe 基本的fragment
 */
public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView {
    private View parentView;
    protected FragmentActivity activity;
    protected P mPresenter;



    @LayoutRes
    public abstract int getLayoutResId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();//创建presenter
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        parentView = inflater.inflate(getLayoutResId(), container, false);
        activity = getActivity();
        return parentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //bind = ButterKnife.bind(this, view);
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        finishCreateView(savedInstanceState);
    }

    /**
     * 初始化views
     *
     * @param state
     */
    public abstract void finishCreateView(Bundle state);
    public abstract P createPresenter();

    @Override
    public void onDestroy() {
        if (mPresenter != null)
            mPresenter.onDestroy();//释放资源
        this.mPresenter = null;
        super.onDestroy();
    }


    @Override
    public void onDetach() {
        super.onDetach();
        this.activity = null;
    }
    @Override
    public void showLoading() {
        Toast.makeText(activity, "加载中", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void hideLoading() {
        Toast.makeText(activity, "加载结束", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setToolBar(Toolbar toolBar, String title, boolean needBackButton) {

    }

    @Override
    public void handleError(Exception e) {
        hideLoading();
        showMessage(e.getMessage());
        e.printStackTrace();
    }
}
