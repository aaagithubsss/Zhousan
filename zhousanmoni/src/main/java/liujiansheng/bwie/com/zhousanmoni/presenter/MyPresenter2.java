package liujiansheng.bwie.com.zhousanmoni.presenter;

import liujiansheng.bwie.com.zhousanmoni.bean.DeleteBean;
import liujiansheng.bwie.com.zhousanmoni.model.MyModel2;
import liujiansheng.bwie.com.zhousanmoni.model.MyModelCallBack2;
import liujiansheng.bwie.com.zhousanmoni.view.MyViewCallBack2;

/**
 * Created by Administrator on 2018/6/23.
 */

public class MyPresenter2 {
    MyModel2 myModel2;
    MyViewCallBack2 myViewCallBack2;

    public MyPresenter2(MyViewCallBack2 myViewCallBack2) {
        this.myModel2 = new MyModel2();
        this.myViewCallBack2 = myViewCallBack2;
    }
    public void delete(String pid){
        myModel2.delete(pid,new MyModelCallBack2() {
            @Override
            public void success(DeleteBean deleteBean) {
                myViewCallBack2.success(deleteBean);
            }

            @Override
            public void failure() {
                myViewCallBack2.failure();
            }
        });
    }
    public void detach(){
        this.myViewCallBack2=null;
    }
}
