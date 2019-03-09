package com.xuhuawei.bannerviewpagerdemo.adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xuhuawei.bannerviewpagerdemo.R;
import com.xuhuawei.bannerviewpagerdemo.beans.BannerItem;
import com.xuhuawei.bannerviewpagerdemo.views.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

public class BannerViewAdapter extends PagerAdapter {
    private  BannerViewPager bannerViewPager;
    private List<View> mViews;
    private List<BannerItem> mData;
    public BannerViewAdapter(BannerViewPager bannerViewPager) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        this.bannerViewPager = bannerViewPager;
    }
    public void addCardItemAll(List<BannerItem> list) {
        if (list!=null&&list.size()>0){
            for (BannerItem bean : list) {
                addCardItem(bean);
            }
        }
    }

    public void addCardItem(BannerItem item) {
        mViews.add(null);
        mData.add(item);
    }

    public View getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        int size=mData.size();
        return size;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.adapter_banner_viewpager, container, false);
        container.addView(view);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setOnClickListener(listener);
        view.setTag(position);
        mViews.set(position, view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
