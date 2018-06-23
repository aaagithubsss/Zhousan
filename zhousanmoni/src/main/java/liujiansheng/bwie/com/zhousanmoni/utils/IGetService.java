package liujiansheng.bwie.com.zhousanmoni.utils;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2018/6/23.
 */

public interface IGetService {
    @GET
    Observable<String> select(@Url String url, @QueryMap Map<String,String> map);
    @GET
    Observable<String> delete(@Url String url, @QueryMap Map<String,String> map);
    @GET
    Observable<String> update(@Url String url, @QueryMap Map<String,String> map);
}
