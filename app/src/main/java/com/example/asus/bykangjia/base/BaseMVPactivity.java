package com.example.asus.bykangjia.base;

import android.os.Bundle;
import android.support.annotation.Nullable;


import com.example.asus.bykangjia.dargger2.DaggerMVPComment;
import com.example.asus.bykangjia.dargger2.MVPComment;
import com.example.asus.bykangjia.dargger2.MVPmoduis;
import com.example.asus.bykangjia.model.Model;
import com.example.asus.bykangjia.persenter.ByPensenter;
import com.example.asus.bykangjia.view.Iview;

import javax.inject.Inject;

/**
 * Created by ASUS on 2017/12/28.
 */

public abstract class BaseMVPactivity<T extends ByPensenter,M extends Model> extends BaseActivity implements Iview.Iv {

    @Inject
    T t;

    @Inject
    M m;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        inject();
        t.Attch(this,m);
        t.Datas1();
        t.v1.ShowView();
        t.v1.DestView();
        super.onCreate(savedInstanceState);
    }

    protected abstract void inject();

    public MVPComment mvpComment(){
        return DaggerMVPComment.builder().mVPmoduis(new MVPmoduis()).build();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        t.Jie();
    }
}
