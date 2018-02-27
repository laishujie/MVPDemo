package com.lai.mvpdemo.mvp.simple2.view;

import android.os.Bundle;

import com.lai.mvpdemo.R;
import com.lai.mvpdemo.bean.ComicListInfo;
import com.lai.mvpdemo.mvp.simple2.base.impl.BaseFragment;
import com.lai.mvpdemo.mvp.simple2.contract.ContractComic;
import com.lai.mvpdemo.mvp.simple2.presenter.ComicPresenter;

import java.util.List;

/**
 * @author Lai
 * @time 2018/2/27 16:10
 * @describe fragment请求
 */

public class ComicFragment extends BaseFragment<ComicPresenter> implements ContractComic.ComicView {

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void finishCreateView(Bundle state) {
        mPresenter.requestList();
    }

    @Override
    public ComicPresenter createPresenter() {
        return new ComicPresenter();
    }

    @Override
    public void showList(List<ComicListInfo.EntriesBean> comicListInfos) {
        showMessage(comicListInfos.toString());
    }

}
