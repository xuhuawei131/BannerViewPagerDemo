package com.xuhuawei.bannerviewpagerdemo.anim;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.xuhuawei.bannerviewpagerdemo.adapters.BannerViewAdapter;


public class BannerTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer{
    private ViewPager viewPager;
    private BannerViewAdapter mAdapter;
    private float mLastOffset;
    public BannerTransformer(ViewPager viewPager, BannerViewAdapter adapter) {
        this.viewPager=viewPager;
        this.mAdapter=adapter;
        this.viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int realCurrentPosition;
        int nextPosition;
        float realOffset;
        boolean goingLeft = mLastOffset > positionOffset;

        // If we're going backwards, onPageScrolled receives the last position
        // instead of the current one
        if (goingLeft) {
            realCurrentPosition = position + 1;
            nextPosition = position;
            realOffset = 1 - positionOffset;
        } else {
            nextPosition = position + 1;
            realCurrentPosition = position;
            realOffset = positionOffset;
        }

        // Avoid crash on overscroll
        if (nextPosition > mAdapter.getCount() - 1
                || realCurrentPosition > mAdapter.getCount() - 1) {
            return;
        }

        View currentCard = mAdapter.getCardViewAt(realCurrentPosition);

        // This might be null if a fragment is being used
        // and the views weren't created yet
        if (currentCard != null) {
            currentCard.setScaleX((float) (1 + 0.1 * (1 - realOffset)));
            currentCard.setScaleY((float) (1 + 0.1 * (1 - realOffset)));
        }

        View nextCard = mAdapter.getCardViewAt(nextPosition);
        // We might be scrolling fast enough so that the next (or previous) card
        // was already destroyed or a fragment might not have been created yet
        if (nextCard != null) {
            nextCard.setScaleX((float) (1 + 0.1 * (realOffset)));
            nextCard.setScaleY((float) (1 + 0.1 * (realOffset)));
        }
        mLastOffset = positionOffset;
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void transformPage(@NonNull View view, float v) {

    }
}
