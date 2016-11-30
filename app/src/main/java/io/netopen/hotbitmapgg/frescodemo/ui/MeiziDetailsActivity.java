package io.netopen.hotbitmapgg.frescodemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.netopen.hotbitmapgg.frescodemo.R;

/**
 * Created by hcc on 2016/11/27 16:10
 * 100332338@qq.com
 * <p>
 * 图片查看详情界面
 */

public class MeiziDetailsActivity extends AppCompatActivity
{

    @Bind(R.id.image_details)
    SimpleDraweeView mSimpleDraweeView;


    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meizi_details);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        if (intent != null)
        {
            url = intent.getStringExtra("url");
        }

        initData();
    }

    private void initData()
    {

        //加载大图
        mSimpleDraweeView.setImageURI(Uri.parse(url));
        mSimpleDraweeView.setOnClickListener(view -> Snackbar.make(mSimpleDraweeView, "点击了", Snackbar.LENGTH_SHORT).show());
    }


    public static void launch(Activity activity, String url)
    {

        Intent mIntent = new Intent(activity, MeiziDetailsActivity.class);
        mIntent.putExtra("url", url);
        activity.startActivity(mIntent);
    }
}
