package com.basic2.componts.ux;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

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

    private float margin;

    public ImageText(Context context) {
        super(context);
    }

    public ImageText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //TODO
        TypedArray t = getContext().obtainStyledAttributes(attrs, R.styleable.ImageTextAttr);
        margin = t.getDimension(R.styleable.ImageTextAttr_image_text_margin, 10);

        t.recycle();
    }
}
