package com.example.asus.bykangjia.model;

import android.widget.Toast;

import com.example.asus.bykangjia.Bean;
import com.example.asus.bykangjia.utils.Api;
import com.example.asus.bykangjia.utils.ApiService;
import com.example.asus.bykangjia.utils.RetrofitUtils;
import com.example.asus.bykangjia.view.Iview;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ASUS on 2017/12/28.
 */

  /**
   *                             _ooOoo_
   *                            o8888888o
   *                            88" . "88
   *                            (| -_- |)
   *                            O\  =  /O
   *                         ____/`---'\____
   *                       .'  \\|     |//  `.
   *                      /  \\|||  :  |||//  \
   *                     /  _||||| -:- |||||-  \
   *                     |   | \\\  -  /// |   |
   *                     | \_|  ''\---/''  |   |
   *                     \  .-\__  `-`  ___/-. /
   *                   ___`. .'  /--.--\  `. . __
   *                ."" '<  `.___\_<|>_/___.'  >'"".
   *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
   *               \  \ `-.   \_ __\ /__ _/   .-` /  /
   *          ======`-.____`-.___\_____/___.-`____.-'======
   *                             `=---='
   *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   *                     佛祖保佑        永无BUG
   *            佛曰:
   *                   写字楼里写字间，写字间里程序员；
   *                   程序人员写程序，又拿程序换酒钱。
   *                   酒醒只在网上坐，酒醉还来网下眠；
   *                   酒醉酒醒日复日，网上网下年复年。
   *                   但愿老死电脑间，不愿鞠躬老板前；
   *                   奔驰宝马贵者趣，公交自行程序员。
   *                   别人笑我忒疯癫，我笑自己命太贱；
   *                   不见满街漂亮妹，哪个归得程序员？
  */


public class Model implements Imodel {


    @Override
    public void Fanren(final Iview.Iv2 iv) {
        RetrofitUtils.getRetrofitUtils().Builder().Get(Api.B).enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                iv.Datas(response.body().getData().get(0).getNews_title());
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {

            }
        });
    }
}
