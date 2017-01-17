package io.netopen.hotbitmapgg.frescodemo.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by hcc on 2017/1/16 19:07
 * 100332338@qq.com
 * FrescoDemo
 *
 * @HotBitmapGG
 */

public class Demo2Activity extends AppCompatActivity {

  private Handler mHandler = new Handler() {

    @Override public void handleMessage(Message msg) {
      super.handleMessage(msg);
    }
  };


  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mHandler.postDelayed(new Runnable() {
      @Override public void run() {

        Toast.makeText(Demo2Activity.this, "toast", Toast.LENGTH_SHORT).show();
      }
    }, 1000 * 60 * 10);
  }


  @Override protected void onDestroy() {
    super.onDestroy();
    mHandler.removeCallbacksAndMessages(null);
  }
}
