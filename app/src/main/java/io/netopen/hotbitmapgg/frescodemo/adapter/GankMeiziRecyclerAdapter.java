package io.netopen.hotbitmapgg.frescodemo.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import io.netopen.hotbitmapgg.frescodemo.R;
import io.netopen.hotbitmapgg.frescodemo.entity.MeiziInfo;

/**
 * Created by hcc on 2016/11/27 12:09
 * 100332338@qq.com
 */

public class GankMeiziRecyclerAdapter extends AbsRecyclerViewAdapter
{

    private List<MeiziInfo.ResultsBean> meizis;

    public GankMeiziRecyclerAdapter(RecyclerView recyclerView, List<MeiziInfo.ResultsBean> meizis)
    {

        super(recyclerView);
        this.meizis = meizis;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_meizi, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ViewHolder)
        {
            ViewHolder viewHolder = (ViewHolder) holder;
            MeiziInfo.ResultsBean resultsBean = meizis.get(position);
            //设置url加载图片
            viewHolder.mSimpleDraweeView.setImageURI(Uri.parse(resultsBean.getUrl()));
            //设置图片加载控制器
            AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                    //重试之后要加载的图片url地址
                    .setUri(resultsBean.getUrl())
                    //设置点击重试是否开启
                    .setTapToRetryEnabled(true)
                    //设置旧的Controller
                    .setOldController(viewHolder.mSimpleDraweeView.getController())
                    .build();

            viewHolder.mSimpleDraweeView.setController(controller);
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return meizis.size();
    }

    private class ViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        SimpleDraweeView mSimpleDraweeView;

        ViewHolder(View itemView)
        {

            super(itemView);
            mSimpleDraweeView = $(R.id.item_image);
        }
    }
}
