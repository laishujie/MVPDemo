package com.lai.mvpdemo.mvp.simple.presenter;

import com.lai.mvpdemo.bean.ComicListInfo;
import com.lai.mvpdemo.mvp.simple.contract.ComicModelImpl;
import com.lai.mvpdemo.mvp.simple.contract.ContractComic;

import java.util.List;

/**
 * @author Lai
 * @time 2018/2/27 0:24
 * @describe describe
 */

public class ComicPresenter {
    //M
    private ComicModelImpl mContractComic;
    //V
    private ContractComic.ComicView mComicView;

    public ComicPresenter() {
        mContractComic = new ComicModelImpl();
    }

    /**
     * 销毁对象
     */
    public void onDestroy() {
        mComicView = null;
    }

    /**
     * 与View建立链接
     */
    public void attachView(ContractComic.ComicView view) {
        mComicView = view;
    }

    /**
     * 模拟请求数据
     */
    public void requestList() {
        //显示加载
        mComicView.showLoading();
        //调用m的方法加载数据
        mContractComic.requestList(new ContractComic.IComicCallBack() {
            @Override
            public void ok(List<ComicListInfo.EntriesBean> comicListInfos) {
                //接口回调给activity
                mComicView.showList(comicListInfos);
            }
        });
    }
}
