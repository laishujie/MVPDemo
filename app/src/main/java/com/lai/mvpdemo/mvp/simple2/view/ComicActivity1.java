package com.lai.mvpdemo.mvp.simple2.view;

import android.os.Bundle;
import android.util.Log;

import com.lai.mvpdemo.R;
import com.lai.mvpdemo.bean.ComicListInfo;
import com.lai.mvpdemo.mvp.simple2.base.impl.BaseActivity;
import com.lai.mvpdemo.mvp.simple2.contract.ContractComic;
import com.lai.mvpdemo.mvp.simple2.presenter.ComicPresenter;

import java.util.List;

public class ComicActivity1 extends BaseActivity<ComicPresenter> implements ContractComic.ComicView {

    @Override
    public ComicPresenter createPresenter() {
        return new ComicPresenter();
    }

    @Override
    public int getLayoutResId(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        //请求数据
        mPresenter.requestList();
    }

    /**
     * p层回调数据
     *
     * @param comicListInfos
     */
    @Override
    public void showList(List<ComicListInfo.EntriesBean> comicListInfos) {
        Log.w("ComicActivity1", "首页数据" + comicListInfos.size());
    }

}
