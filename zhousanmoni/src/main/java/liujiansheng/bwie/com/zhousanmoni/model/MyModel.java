package liujiansheng.bwie.com.zhousanmoni.model;

import java.util.HashMap;
import java.util.Map;

import liujiansheng.bwie.com.zhousanmoni.bean.CarBean;
import liujiansheng.bwie.com.zhousanmoni.utils.APIFactory;
import liujiansheng.bwie.com.zhousanmoni.utils.AbstractObserver;

/**
 * Created by Administrator on 2018/6/23.
 */

public class MyModel {
    public void select(final MyModelCallBack myModelCallBack){
        final Map<String,String> map=new HashMap<>();
        map.put("source","android");
        map.put("uid","14927");
        APIFactory.getInstance().select("/product/getCarts", map, new AbstractObserver<CarBean>() {
            @Override
            public void onSuccess(CarBean carBean) {
                myModelCallBack.success(carBean);
            }

            @Override
            public void onFailure() {

                myModelCallBack.failure();
            }
        });
    }
}
