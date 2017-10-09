package com.basic2.componts.ux;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

public class ImageText extends LinearLayout {

    private final int zero = 0;
    private ImageView mImageView;
    private TextView mTextView;

    public ImageText(Context context) {
        super(context);
        obtainAttrs(context, null);
    }

    public ImageText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        obtainAttrs(context, attrs);
    }

    private void obtainAttrs(Context context, AttributeSet attrs) {
        //TODO
        TypedArray t = getContext().obtainStyledAttributes(attrs, R.styleable.ImageTextAttr);
        int margin = t.getDimensionPixelSize(R.styleable.ImageTextAttr_image_text_margin, 10);
        int background = t.getResourceId(R.styleable.ImageTextAttr_image_background, 0);

        float textSize = t.getDimensionPixelSize(R.styleable.ImageTextAttr_text_size, 14);
        int textColor = t.getColor(R.styleable.ImageTextAttr_text_color, Color.GRAY);
        int textRes = t.getResourceId(R.styleable.ImageTextAttr_text, R.string.tip_image_text);
        CharSequence textString = t.getText(R.styleable.ImageTextAttr_text);

        t.recycle();

        mImageView = new ImageView(context);
        mImageView.setPadding(zero, zero, Density.px2dp(context, margin), zero);
        mImageView.setBackgroundResource(background);

        mTextView = new TextView(context);
        mTextView.setTextColor(textColor);
        mTextView.setTextSize(Density.px2dp(context, textSize));
        mTextView.setText(textRes);
        mTextView.setText(textString);

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);

        addView(mImageView);
        addView(mTextView);
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public TextView getTextView() {
        return mTextView;
    }
}
