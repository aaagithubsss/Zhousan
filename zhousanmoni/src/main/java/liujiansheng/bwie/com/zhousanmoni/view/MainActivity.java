package liujiansheng.bwie.com.zhousanmoni.view;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import liujiansheng.bwie.com.zhousanmoni.R;

public class MainActivity extends AppCompatActivity {

    private SurfaceView surfaceView;
    private Button bofang, zanting, tingzhi;
    private MediaPlayer mediaPlayer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        surfaceView =  findViewById(R.id.surfaceview);
        bofang =  findViewById(R.id.bofang);
        zanting =  findViewById(R.id.zanting);
        tingzhi =  findViewById(R.id.tingzhi);
        mediaPlayer = MediaPlayer.create(this, R.raw.oppo2);
        bofang.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                try {
                    mediaPlayer.setDisplay(surfaceView.getHolder()); // 设置将视频画面输出到SurfaceView
                    mediaPlayer.start(); // 开始播放
                    bofang.setEnabled(false);
                    zanting.setEnabled(true);
                    tingzhi.setEnabled(true);


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
        zanting.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause(); // 停止播放
                } else {
                    mediaPlayer.start();
                }
                bofang.setEnabled(true);
                zanting.setEnabled(false);
                tingzhi.setEnabled(false);


            }
        });
        tingzhi.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                } else {
                    mediaPlayer.start();
                }
                bofang.setEnabled(true);
                zanting.setEnabled(false);
                tingzhi.setEnabled(false);


            }
        });


// mediaPlayer添加完成事件的监听器
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer arg0) {
                surfaceView.setBackgroundResource(R.mipmap.ic_launcher); // 改变SurfaceView的背景图片
                Toast.makeText(MainActivity.this, "视频播放完毕！", Toast.LENGTH_SHORT).show();


            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();


        }
        mediaPlayer.release();// 释放资源
    }

    public void tiaozhuan(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
