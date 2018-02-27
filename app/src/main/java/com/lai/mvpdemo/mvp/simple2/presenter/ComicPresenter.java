package com.lai.mvpdemo.mvp.simple2.presenter;

import com.lai.mvpdemo.bean.ComicListInfo;
import com.lai.mvpdemo.mvp.simple2.contract.ComicModelImpl;
import com.lai.mvpdemo.mvp.simple2.base.impl.BasePresenter;
import com.lai.mvpdemo.mvp.simple2.contract.ContractComic;

import java.util.List;

/**
 * @author Lai
 * @time 2018/2/27 0:24
 * @describe describe
 */

public class ComicPresenter extends BasePresenter<ContractComic.ComicView> {
    //M
    private ComicModelImpl mContractComic;

    public ComicPresenter() {
        mContractComic = new ComicModelImpl();
    }

    /**
     * 模拟请求数据
     */
    public void requestList() {
        //显示加载
        mRootView.showLoading();
        //调用m的方法加载数据
        mContractComic.requestList(new ContractComic.IComicCallBack() {
            @Override
            public void ok(List<ComicListInfo.EntriesBean> comicListInfos) {
                //接口回调给activity
                mRootView.showList(comicListInfos);
            }
        });
    }
}
