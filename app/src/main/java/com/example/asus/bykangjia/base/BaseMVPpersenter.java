package com.example.asus.bykangjia.base;

import com.example.asus.bykangjia.model.Imodel;
import com.example.asus.bykangjia.model.Model;

import java.lang.ref.WeakReference;

/**
 * Created by ASUS on 2017/12/28.
 */

public abstract class BaseMVPpersenter<V extends BaseIvew,M extends Model>  implements BaePersenter<V,M>{

    protected WeakReference<V> vWeakReference;
    protected WeakReference<M> vWeakReference2;
    protected V v1;
    protected  M m1;

    @Override
    public void Attch(V v,M m) {
          vWeakReference = new WeakReference<V>(v);
          vWeakReference2 =new WeakReference<M>(m);
          v1 = vWeakReference.get();

          m1 = vWeakReference2.get();

    }

    @Override
    public void Jie() {
         vWeakReference.clear();
         vWeakReference2.clear();
         vWeakReference2 = null;
         vWeakReference =null;
    }
}
