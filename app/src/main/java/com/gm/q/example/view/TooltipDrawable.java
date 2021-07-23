package com.gm.q.example.view;

import com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;

import androidx.annotation.RestrictTo;

import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * 项目名称：AndroidBaseImpl
 * 类描述：
 * 创建人：zhanggangmin
 * 创建时间：2021/7/17 12:13
 * 修改人：zhanggangmin
 * 修改时间：2021/7/17 12:13
 * 修改备注：
 */
@RestrictTo(LIBRARY_GROUP)
public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableDelegate {
    @Override
    public void onTextSizeChange() {

    }

    @Override
    public boolean onStateChange(int[] state) {
        return false;
    }
}
