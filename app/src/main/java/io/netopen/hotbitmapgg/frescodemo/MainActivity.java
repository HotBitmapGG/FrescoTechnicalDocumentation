package io.netopen.hotbitmapgg.frescodemo;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.netopen.hotbitmapgg.frescodemo.adapter.GankMeiziRecyclerAdapter;
import io.netopen.hotbitmapgg.frescodemo.entity.MeiziInfo;
import io.netopen.hotbitmapgg.frescodemo.network.RetrofitHelper;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
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

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {

            @Override
            public void onRefresh()
            {

            }
        });
        mSwipeRefreshLayout.post(new Runnable()
        {

            @Override
            public void run()
            {

                mSwipeRefreshLayout.setRefreshing(true);
                initData();
            }
        });

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new GankMeiziRecyclerAdapter(mRecyclerView, meizis);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData()
    {

        RetrofitHelper.getGankMeiziApi()
                .getMeiziInfos(20, 1)
                .filter(new Func1<MeiziInfo,Boolean>()
                {

                    @Override
                    public Boolean call(MeiziInfo meiziInfo)
                    {

                        return !meiziInfo.isError();
                    }
                })
                .map(new Func1<MeiziInfo,List<MeiziInfo.ResultsBean>>()
                {

                    @Override
                    public List<MeiziInfo.ResultsBean> call(MeiziInfo meiziInfo)
                    {

                        return meiziInfo.getResults();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<MeiziInfo.ResultsBean>>()
                {

                    @Override
                    public void call(List<MeiziInfo.ResultsBean> resultsBeans)
                    {

                        meizis.addAll(resultsBeans);
                        finishTask();
                    }
                }, new Action1<Throwable>()
                {

                    @Override
                    public void call(Throwable throwable)
                    {

                        Log.i(TAG, throwable.getMessage());
                    }
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
