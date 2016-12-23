package io.netopen.hotbitmapgg.frescodemo.adapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import io.netopen.hotbitmapgg.frescodemo.R;
import io.netopen.hotbitmapgg.frescodemo.entity.MeiziInfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by hcc on 2016/11/27 12:09
 * 100332338@qq.com
 */

public class GankMeiziRecyclerAdapter extends AbsRecyclerViewAdapter<MeiziInfo.ResultsBean> {

  @Override
  public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    bindContext(parent.getContext());
    return new ViewHolder(
        LayoutInflater.from(getContext()).inflate(R.layout.item_meizi, parent, false));
  }


  @Override
  public void onBindViewHolder(ClickableViewHolder holder, int position) {

    if (holder instanceof ViewHolder) {
      ViewHolder viewHolder = (ViewHolder) holder;
      MeiziInfo.ResultsBean resultsBean = mDataSources.get(position);

      Glide.with(getContext())
          .load(resultsBean.getUrl())
          .centerCrop()
          .diskCacheStrategy(DiskCacheStrategy.ALL)
          .into(viewHolder.mImageView);

      // //设置url加载图片
      // viewHolder.mSimpleDraweeView.setImageURI(Uri.parse(resultsBean.getUrl()));
      // //设置图片加载控制器
      // AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
      //     //重试之后要加载的图片url地址
      //     .setUri(resultsBean.getUrl())
      //     //设置点击重试是否开启
      //     .setTapToRetryEnabled(true)
      //     //设置旧的Controller
      //     .setOldController(viewHolder.mSimpleDraweeView.getController())
      //     .build();
      //
      // viewHolder.mSimpleDraweeView.setController(controller);
    }
    super.onBindViewHolder(holder, position);
  }


  private class ViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

    ImageView mImageView;


    ViewHolder(View itemView) {

      super(itemView);
      mImageView = $(R.id.item_image);
    }
  }
}
