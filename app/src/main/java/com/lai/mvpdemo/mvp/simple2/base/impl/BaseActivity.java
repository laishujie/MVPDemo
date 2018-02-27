package com.lai.mvpdemo.mvp.simple2.base.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.lai.mvpdemo.mvp.simple2.base.IPresenter;
import com.lai.mvpdemo.mvp.simple2.base.IView;

/**
 * @author Lai
 * @time 2017/12/10 17:18
 * @describe describe
 */

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IView {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            int layoutResID = getLayoutResId(savedInstanceState);
            if (layoutResID != 0) {
                setContentView(layoutResID);
                //创建P对象
                mPresenter = createPresenter();
                if (mPresenter != null) {
                    //绑定View
                    mPresenter.attachView(this);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        initData(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        //把所有的数据销毁掉
        if (mPresenter != null)
            mPresenter.onDestroy();//释放资源
        this.mPresenter = null;
        super.onDestroy();
    }

    public abstract P createPresenter();

    public abstract int getLayoutResId(Bundle savedInstanceState);

    public abstract void initData(Bundle savedInstanceState);

    //public abstract void inject(BaseComponent component);


    @Override
    public void showLoading() {
        Toast.makeText(this, "加载中", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void handleError(Exception e) {
        e.printStackTrace();
        hideLoading();
        showMessage(e.getMessage());
    }

    @Override
    public void hideLoading() {
        Toast.makeText(this, "加载结束", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setToolBar(Toolbar toolBar, String title, boolean needBackButton) {

    }

}
