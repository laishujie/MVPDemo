package com.lai.mvpdemo.mvp.simple2.contract;

import com.lai.mvpdemo.bean.ComicListInfo;
import com.lai.mvpdemo.mvp.simple2.base.IView;

import java.util.List;

/**
 * @author Lai
 * @time 2018/2/27 0:16
 * @describe 契约类
 */

public interface ContractComic {
    interface ComicModel {
        void requestList(IComicCallBack iComicCallBack);
    }

    interface ComicView extends IView {
        void showList(List<ComicListInfo.EntriesBean> comicListInfos);
    }

    interface IComicCallBack {
        void ok(List<ComicListInfo.EntriesBean> comicListInfos);
    }
}
