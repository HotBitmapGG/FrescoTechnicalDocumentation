package io.netopen.hotbitmapgg.frescodemo;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by hcc on 2016/11/27 11:51
 * 100332338@qq.com
 */

public class FrescoDemoApp extends Application
{

    @SuppressLint("StaticFieldLeak")
    private static Context mAppContext;

    @Override
    public void onCreate()
    {

        super.onCreate();
        mAppContext = this;

        Fresco.initialize(this);
    }

    public static Context getAppContext()
    {

        return mAppContext;
    }
}
