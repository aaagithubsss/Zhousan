package liujiansheng.bwie.com.zhousanmoni.model;

import java.util.HashMap;
import java.util.Map;

import liujiansheng.bwie.com.zhousanmoni.bean.DeleteBean;
import liujiansheng.bwie.com.zhousanmoni.utils.APIFactory;
import liujiansheng.bwie.com.zhousanmoni.utils.AbstractObserver;

/**
 * Created by Administrator on 2018/6/23.
 */

public class MyModel2 {
    public void delete(String pid,final MyModelCallBack2 myModelCallBack2){
        final Map<String,String> map=new HashMap<>();
        map.put("source","android");
        map.put("pid",pid);
        map.put("uid","14927");
        APIFactory.getInstance().delete("/product/deleteCart", map, new AbstractObserver<DeleteBean>() {
            @Override
            public void onSuccess(DeleteBean deleteBean) {
                myModelCallBack2.success(deleteBean);
            }

            @Override
            public void onFailure() {

                myModelCallBack2.failure();
            }
        });
    }
}
