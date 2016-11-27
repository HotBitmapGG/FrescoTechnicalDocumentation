package io.netopen.hotbitmapgg.frescodemo.network.api;

import io.netopen.hotbitmapgg.frescodemo.entity.MeiziInfo;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hcc on 2016/11/27 11:54
 * 100332338@qq.com
 */

public interface GankMeiziService
{

    @GET("data/福利/{number}/{page}")
    Observable<MeiziInfo> getMeiziInfos(@Path("number") int number, @Path("page") int page);
}
