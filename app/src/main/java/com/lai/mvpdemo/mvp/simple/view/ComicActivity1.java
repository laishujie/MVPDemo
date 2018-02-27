package com.lai.mvpdemo.mvp.simple.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.lai.mvpdemo.R;
import com.lai.mvpdemo.bean.ComicListInfo;
import com.lai.mvpdemo.mvp.simple.contract.ContractComic;
import com.lai.mvpdemo.mvp.simple.presenter.ComicPresenter;

import java.util.List;

public class ComicActivity1 extends AppCompatActivity implements ContractComic.ComicView {

    private ComicPresenter mComicPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mComicPresenter = new ComicPresenter();
        //把当前View赋予P层
        mComicPresenter.attachView(this);
        //请求数据
        mComicPresenter.requestList();
    }

    @Override
    protected void onDestroy() {
        //销毁依赖对象
        mComicPresenter.onDestroy();
        super.onDestroy();
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

    @Override
    public void showLoading() {
        Toast.makeText(this, "加载中", Toast.LENGTH_SHORT).show();
    }
}
