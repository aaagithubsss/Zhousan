package liujiansheng.bwie.com.zhousanmoni.model;

import liujiansheng.bwie.com.zhousanmoni.bean.CarBean;

/**
 * Created by Administrator on 2018/6/23.
 */

public interface MyModelCallBack {
    public void success(CarBean carBean);
    public void  failure();
}
