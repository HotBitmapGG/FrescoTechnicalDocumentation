package io.netopen.hotbitmapgg.frescodemo.ui;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import io.netopen.hotbitmapgg.frescodemo.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

/**
 * Created by hcc on 2016/11/27 16:10
 * 100332338@qq.com
 * <p>
 * 图片查看详情界面
 */

public class MeiziDetailsActivity extends AppCompatActivity {

  @Bind(R.id.image_details)
  ImageView mImageView;

  @Bind(R.id.toolbar)
  Toolbar mToolbar;

  @Bind(R.id.app_bar_layout)
  AppBarLayout mAppBarLayout;

  private String url;

  private String title;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_meizi_details);
    ButterKnife.bind(this);

    Intent intent = getIntent();
    if (intent != null) {
      url = intent.getStringExtra("url");
      title = intent.getStringExtra("title");
    }

    initToolBar();
    initData();
  }


  private void initToolBar() {

    mToolbar.setTitle(title);
    setSupportActionBar(mToolbar);
    ActionBar supportActionBar = getSupportActionBar();
    if (supportActionBar != null) {
      supportActionBar.setDisplayHomeAsUpEnabled(true);
    }
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    getMenuInflater().inflate(R.menu.menu_meizi, menu);
    return true;
  }


  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    int itemId = item.getItemId();
    switch (itemId) {
      case R.id.action_save:
        //FrescoDownloadImageUtil.saveFile(MeiziDetailsActivity.this, Uri.parse(url));
        break;

      case R.id.action_share:
        share(Uri.parse(url));
        break;

      case android.R.id.home:
        onBackPressed();
        break;
    }
    return super.onOptionsItemSelected(item);
  }


  private void initData() {

    Glide.with(this)
        .load(url)
        .centerCrop()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(mImageView);

    // //加载大图
    // mSimpleDraweeView.setImageURI(Uri.parse(url));
    // mSimpleDraweeView.setOnClickListener(
    //     view -> Snackbar.make(mSimpleDraweeView, "点击了", Snackbar.LENGTH_SHORT).show());
  }


  public static Intent launch(Activity activity, String url, String title) {

    Intent mIntent = new Intent(activity, MeiziDetailsActivity.class);
    mIntent.putExtra("url", url);
    mIntent.putExtra("title", title);
    return mIntent;
  }


  /**
   * 分享图片
   */
  private void share(Uri uri) {

    Intent shareIntent = new Intent();
    shareIntent.setAction(Intent.ACTION_SEND);
    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
    shareIntent.setType("image/jpeg");
    startActivity(Intent.createChooser(shareIntent, title));
  }
}
