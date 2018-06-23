package liujiansheng.bwie.com.zhousanmoni.presenter;

import liujiansheng.bwie.com.zhousanmoni.bean.CarBean;
import liujiansheng.bwie.com.zhousanmoni.model.MyModel;
import liujiansheng.bwie.com.zhousanmoni.model.MyModelCallBack;
import liujiansheng.bwie.com.zhousanmoni.view.MyViewCallBack;

/**
 * Created by Administrator on 2018/6/23.
 */

public class MyPresenter {
    MyModel myModel;
    MyViewCallBack myViewCallBack;

    public MyPresenter(MyViewCallBack myViewCallBack) {
        this.myModel = new MyModel();
        this.myViewCallBack = myViewCallBack;
    }
    public void select(){
        myModel.select(new MyModelCallBack() {
            @Override
            public void success(CarBean carBean) {
                myViewCallBack.success(carBean);
            }

            @Override
            public void failure() {
                myViewCallBack.failure();
            }
        });
    }
    public void detach(){
        this.myViewCallBack=null;
    }

}
