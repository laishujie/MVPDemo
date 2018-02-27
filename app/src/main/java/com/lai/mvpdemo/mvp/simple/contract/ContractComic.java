package com.lai.mvpdemo.mvp.simple.contract;

import com.lai.mvpdemo.bean.ComicListInfo;

import java.util.List;

/**
 * @author Lai
 * @time 2018/2/27 0:16
 * @describe describe
 */

public interface ContractComic {
    interface ComicModel {
        void requestList(IComicCallBack iComicCallBack);
    }

    interface ComicView {
        void showList(List<ComicListInfo.EntriesBean> comicListInfos);
        void showLoading();
    }

    interface IComicCallBack {
        void ok(List<ComicListInfo.EntriesBean> comicListInfos);
    }
}
