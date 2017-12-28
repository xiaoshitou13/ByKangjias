package com.example.asus.bykangjia.utils;

import com.example.asus.bykangjia.Bean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by ASUS on 2017/12/28.
 */

public interface ApiService {

 @GET
 Call<Bean> Get(@Url String url);

}
