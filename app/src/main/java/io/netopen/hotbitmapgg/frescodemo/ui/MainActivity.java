package io.netopen.hotbitmapgg.frescodemo.ui;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import io.netopen.hotbitmapgg.frescodemo.R;
import io.netopen.hotbitmapgg.frescodemo.adapter.GankMeiziRecyclerAdapter;
import io.netopen.hotbitmapgg.frescodemo.entity.MeiziInfo;
import io.netopen.hotbitmapgg.frescodemo.network.RetrofitHelper;
import java.util.ArrayList;
import java.util.List;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class MainActivity extends RxAppCompatActivity {

  @Bind(R.id.toolBar)
  Toolbar mToolbar;

  @Bind(R.id.swipe_refresh)
  SwipeRefreshLayout mSwipeRefreshLayout;

  @Bind(R.id.recycler)
  RecyclerView mRecyclerView;

  private List<MeiziInfo.ResultsBean> meizis = new ArrayList<>();
  private GankMeiziRecyclerAdapter mAdapter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);
    initToolBar();
    initView();
  }


  private void initToolBar() {

    mToolbar.setTitle("FrescoDemo");
    setSupportActionBar(mToolbar);
  }


  private void initView() {

    mSwipeRefreshLayout.setColorSchemeResources(R.color.cardview_dark_background);
    mSwipeRefreshLayout.setOnRefreshListener(() -> mSwipeRefreshLayout.setRefreshing(false));
    mSwipeRefreshLayout.post(() -> {

      mSwipeRefreshLayout.setRefreshing(true);
      initData();
    });

    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mAdapter = new GankMeiziRecyclerAdapter();
    mRecyclerView.setAdapter(mAdapter);
    mAdapter.setOnItemClickListener((position, holder) -> {

      Intent mIntent = MeiziDetailsActivity.launch(MainActivity.this,
          meizis.get(position).getUrl(),
          meizis.get(position).getDesc());

      startActivity(mIntent,
          ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,
              holder.getParentView().findViewById(R.id.item_image),
              "transitionImg")
              .toBundle());
    });
  }


  private void initData() {

    RetrofitHelper.getGankMeiziApi()
        .getMeiziInfos(20, 1)
        .compose(bindToLifecycle())
        .filter(meiziInfo -> !meiziInfo.isError())
        .map(MeiziInfo::getResults)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(resultsBeans -> {

          meizis.addAll(resultsBeans);
          finishTask();
        }, throwable -> {

        });
  }


  private void finishTask() {

    mAdapter.setDataSources(meizis);
    mAdapter.notifyDataSetChanged();
    mSwipeRefreshLayout.setRefreshing(false);
  }


  @Override
  protected void onDestroy() {

    super.onDestroy();
    ButterKnife.unbind(this);
  }
}
