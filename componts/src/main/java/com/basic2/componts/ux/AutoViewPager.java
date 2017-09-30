package com.basic2.componts.ux;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.basic2.componts.R;

/*
 * Copyright (C) 2017 meikoz, http://basic2it.cc/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class AutoViewPager extends RelativeLayout implements AutoScroll {

    private ViewPager vpAd;
    private LinearLayout llIndexContainer;


    private final int AUTO_SCORLL = 1;
    private boolean isStart;
    private Handler mHandler;
    private PageScrollCallback scrollCallback;

    public AutoViewPager(Context context) {
        super(context);
        onInitView();
    }

    public AutoViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        onInitView();
    }

    public AutoViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInitView();
    }

    private void onInitView() {
        View view = View.inflate(getContext(), R.layout.auto_scroll_viewpager_indicator, this);
        vpAd = (ViewPager) view.findViewById(R.id.vp_ad);
        llIndexContainer = (LinearLayout) view.findViewById(R.id.ll_index_container);
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case AUTO_SCORLL:
                        if (isStart) {
                            if (vpAd.getChildCount() > 1) {
                                vpAd.setCurrentItem(vpAd.getCurrentItem() + 1, true);
                            }
                            mHandler.sendEmptyMessageDelayed(AUTO_SCORLL, 3000);
                        }
                        break;
                }
            }
        };
    }

    // 为ViewPager设置监听器
    private void setViewPagerChangeListener(final int size) {
        vpAd.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (size > 0) {
                    int newPosition = position % size;
                    for (int i = 0; i < size; i++) {
                        llIndexContainer.getChildAt(i).setEnabled(false);
                        if (i == newPosition) {
                            llIndexContainer.getChildAt(i).setEnabled(true);
                        }
                    }
                }
            }

            @Override
            public void onPageScrolled(int position, float arg1, int arg2) {
                if (scrollCallback != null) scrollCallback.scrollIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                int arg01 = arg0;
            }
        });
    }

    private void addIndicatorImageViews(int size) {
        llIndexContainer.removeAllViews();
        for (int i = 0; i < size; i++) {
            ImageView iv = new ImageView(getContext());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(Density.dp2px(getContext(), 9), Density.dp2px(getContext(), 9));
            if (i != 0) {
                lp.leftMargin = Density.dp2px(getContext(), 10);
            }
            iv.setLayoutParams(lp);
            //设置导航点的背景图片
            iv.setBackgroundResource(R.drawable.auto_scroll_indicator);
            iv.setEnabled(false);
            if (i == 0) {
                iv.setEnabled(true);
            }
            llIndexContainer.addView(iv);
        }
    }

    @Override
    public void addIndicatorView(int size) {
        addIndicatorImageViews(size);
        //设置点滚动时候颜色的变化
        setViewPagerChangeListener(size);
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        if (vpAd == null) {
            return;
        }
        vpAd.setAdapter(adapter);
    }

    @Override
    public void startScorll() {
        isStart = true;
        mHandler.sendEmptyMessageDelayed(AUTO_SCORLL, 3000);
    }

    @Override
    public void endScorll() {
        isStart = false;
        mHandler.removeMessages(AUTO_SCORLL);
    }

    @Override
    public void setPageScrollCallback(PageScrollCallback callback) {
        scrollCallback = callback;
    }
}
