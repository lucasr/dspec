/*
 * Copyright (C) 2014 Lucas Rocha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lucasr.dspec;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Utility container that simplifies the use of {@link DesignSpec} on arbitrary
 * {@link android.view.View}s.
 *
 * Enclose your target {@link android.view.View} with a {@link DesignSpecFrameLayout} and
 * use the {@code designSpec} custom attribute to populate the associated {@link DesignSpec}
 * with keylines and spacing markers defined in a raw JSON resource.
 *
 * @see DesignSpec
 */
public class DesignSpecFrameLayout extends FrameLayout {
    private final DesignSpec mDesignSpec;

    public DesignSpecFrameLayout(Context context) {
        this(context, null);
    }

    public DesignSpecFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DesignSpecFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        final TypedArray a =
                context.obtainStyledAttributes(attrs, R.styleable.DesignSpecFrameLayout, defStyle, 0);

        final int resId = a.getResourceId(R.styleable.DesignSpecFrameLayout_designSpec, 0);
        mDesignSpec = DesignSpec.fromResource(this, resId);
        mDesignSpec.setCallback(this);

        a.recycle();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        if (mDesignSpec != null) {
            mDesignSpec.draw(canvas);
        }
    }

    @Override
    public void invalidateDrawable(Drawable dr) {
        if (dr == mDesignSpec) {
            invalidate();
        } else {
            super.invalidateDrawable(dr);
        }
    }

    public DesignSpec getDesignSpec() {
        return mDesignSpec;
    }
}
