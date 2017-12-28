package com.example.asus.bykangjia.base;

import com.example.asus.bykangjia.model.Model;
import com.example.asus.bykangjia.view.Iview;

/**
 * Created by ASUS on 2017/12/28.
 */

public interface BaePersenter<V extends BaseIvew,M extends Model> {
    //写绑定 和解绑的 操作
    void Attch(V v,M m);
    void Jie();
}
