package io.netopen.hotbitmapgg.frescodemo.ui;

import io.netopen.hotbitmapgg.frescodemo.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hcc on 2017/1/16 12:07
 * 100332338@qq.com
 * FrescoDemo
 *
 * @HotBitmapGG
 */

public class DemoActivity extends AppCompatActivity {

  private List<String> strs = new ArrayList<>();

  Message message = new Message();


  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_demo);

    MyHandler myHandler = new MyHandler(this);
    myHandler.postDelayed(new Runnable() {
      @Override public void run() {

      }
    }, 1000 * 60 * 10);
  }


  private static class MyHandler extends Handler {

    private WeakReference<DemoActivity> mActivityWeakReference;


    public MyHandler(DemoActivity demoActivity) {
      mActivityWeakReference = new WeakReference<>(demoActivity);
    }


    @Override public void handleMessage(Message msg) {
      super.handleMessage(msg);
      DemoActivity demoActivity = mActivityWeakReference.get();
      if (demoActivity != null) {

      }
    }
  }


  @Override protected void onDestroy() {
    super.onDestroy();
    strs.clear();
  }
}
