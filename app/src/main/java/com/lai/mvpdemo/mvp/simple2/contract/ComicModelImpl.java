package com.lai.mvpdemo.mvp.simple2.contract;

import com.google.gson.Gson;
import com.lai.mvpdemo.JsonTest;
import com.lai.mvpdemo.bean.ComicListInfo;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Lai
 * @time 2018/2/27 0:10
 * @describe describe
 */

public class ComicModelImpl implements ContractComic.ComicModel {

    /**
     * 请求漫画首页数据
     *
     * @param iComicCallBack 回调
     */
    @Override
    public void requestList(final ContractComic.IComicCallBack iComicCallBack) {
        Observable.create(new ObservableOnSubscribe<ComicListInfo>() {
            @Override
            public void subscribe(ObservableEmitter<ComicListInfo> e) throws Exception {
                Gson gson = new Gson();
                ComicListInfo comicListInfo = gson.fromJson(JsonTest.home, ComicListInfo.class);
                e.onNext(comicListInfo);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ComicListInfo>() {
            @Override
            public void accept(ComicListInfo comicListInfo) throws Exception {
                iComicCallBack.ok(comicListInfo.getEntries());
            }
        });
    }

}
