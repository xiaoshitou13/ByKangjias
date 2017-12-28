package com.example.asus.bykangjia.dargger2;

import com.example.asus.bykangjia.model.Model;
import com.example.asus.bykangjia.persenter.ByPensenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ASUS on 2017/12/28.
 */
@Module
@Singleton
public class MVPmoduis {

    @Provides
    public ByPensenter byPensenter(){
        return new ByPensenter();
    }

    @Provides
    public Model getmModel(){
        return new Model();
    }
}

