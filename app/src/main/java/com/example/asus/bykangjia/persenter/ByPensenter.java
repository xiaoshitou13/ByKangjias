package com.example.asus.bykangjia.persenter;


import com.example.asus.bykangjia.base.BaseMVPpersenter;
import com.example.asus.bykangjia.model.Imodel;
import com.example.asus.bykangjia.model.Model;
import com.example.asus.bykangjia.view.Iview;

/**
 * Created by ASUS on 2017/12/28.
 */

public class ByPensenter<V extends Iview.Iv,M extends Model> extends BaseMVPpersenter<V,M>{


    public void Datas1(){
        m1.Fanren(new Iview.Iv2() {
            @Override
            public void Datas(String s) {
                v1.Data(s);
            }
        });
    }


}
