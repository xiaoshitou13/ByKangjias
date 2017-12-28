package com.example.asus.bykangjia.dargger2;

import com.example.asus.bykangjia.MainActivity;

import dagger.Component;

/**
 * Created by ASUS on 2017/12/28.
 */

@Component(modules = MVPmoduis.class)
public interface MVPComment {
    void Inject(MainActivity mainActivity);
}
