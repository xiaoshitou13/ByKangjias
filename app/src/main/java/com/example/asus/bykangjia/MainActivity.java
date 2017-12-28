package com.example.asus.bykangjia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.asus.bykangjia.base.BaseActivity;
import com.example.asus.bykangjia.base.BaseMVPactivity;
import com.example.asus.bykangjia.model.Imodel;
import com.example.asus.bykangjia.model.Model;
import com.example.asus.bykangjia.persenter.ByPensenter;
import com.example.asus.bykangjia.view.Iview;

public class MainActivity extends BaseMVPactivity<ByPensenter,Model> implements Iview.Iv{


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void ShowView() {
        Log.d("riz","show");
    }

    @Override
    public void DestView() {
        Log.d("riz","dest");
    }

    @Override
    public void Data(String s) {

        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void inject() {
        mvpComment().Inject(this);
    }
}
