package io.netopen.hotbitmapgg.frescodemo.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.netopen.hotbitmapgg.frescodemo.R;
import io.netopen.hotbitmapgg.frescodemo.adapter.GankMeiziRecyclerAdapter;
import io.netopen.hotbitmapgg.frescodemo.entity.MeiziInfo;
import io.netopen.hotbitmapgg.frescodemo.network.RetrofitHelper;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
{

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.recycler)
    RecyclerView mRecyclerView;

    private List<MeiziInfo.ResultsBean> meizis = new ArrayList<>();

    private final static String TAG = MainActivity.class.getName();

    private GankMeiziRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initView();
    }

    private void initView()
    {

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                R.color.colorPrimaryDark, R.color.colorAccent);
        mSwipeRefreshLayout.setOnRefreshListener(() -> {

        });
        mSwipeRefreshLayout.post(() -> {

            mSwipeRefreshLayout.setRefreshing(true);
            initData();
        });

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new GankMeiziRecyclerAdapter(mRecyclerView, meizis);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((position, holder) ->
                MeiziDetailsActivity.launch(MainActivity.this, meizis.get(position).getUrl()));
    }

    private void initData()
    {

        RetrofitHelper.getGankMeiziApi()
                .getMeiziInfos(100, 1)
                .filter(meiziInfo -> !meiziInfo.isError())
                .map(MeiziInfo::getResults)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resultsBeans -> {

                    meizis.addAll(resultsBeans);
                    finishTask();
                }, throwable -> {

                    Log.i(TAG, throwable.getMessage());
                });
    }

    private void finishTask()
    {

        mAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected void onDestroy()
    {

        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
