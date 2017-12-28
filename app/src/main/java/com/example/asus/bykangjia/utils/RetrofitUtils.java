package com.example.asus.bykangjia.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ASUS on 2017/12/28.
 */

public class RetrofitUtils {
    protected static  RetrofitUtils retrofitUtils = null;
    OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

    public static RetrofitUtils getRetrofitUtils(){
        if(retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if(retrofitUtils==null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }


    public ApiService Builder(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.A)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        return apiService;
    }

}
