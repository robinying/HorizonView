package com.yubin.horizonview.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * author : Yubin.Ying
 * tieme : 2018/8/1
 */
public class HorizonScrollView extends HorizontalScrollView {
    private View mSyncView;

    public HorizonScrollView(Context context) {
        super(context);
    }

    public HorizonScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizonScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HorizonScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(mSyncView != null) {
            mSyncView.scrollTo(l, t);
        }
    }


    public View getSyncView() {
        return mSyncView;
    }

    public void setSyncView(View mSyncView) {
        this.mSyncView = mSyncView;
    }


}
