package com.example.edisonliao.mvpdemo.retrofit;

import com.example.edisonliao.mvpdemo.mvp.model.MainModelResponse;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by EdisonLiao on 2017/9/23.
 */

public interface ApiStores {
    //base URL
    String BASE_URL = "http://gank.io/api/data/";

    //RxjavaRetrofit
    @GET("{osType}/{month}/{day}")
    Observable<MainModelResponse> loadDataByRetrofitRxjava(@Path("osType")String osType,
                                                           @Path("month")String month,
                                                           @Path("day")String day);

}
