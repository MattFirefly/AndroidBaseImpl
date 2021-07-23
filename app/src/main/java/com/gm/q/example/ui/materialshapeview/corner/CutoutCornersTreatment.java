package com.gm.q.example.ui.materialshapeview.corner;

import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.ShapePath;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;

/**
 * 项目名称：AndroidBaseImpl
 * 类描述：
 * 创建人：zhanggangmin
 * 创建时间：2021/7/17 15:45
 * 修改人：zhanggangmin
 * 修改时间：2021/7/17 15:45
 * 修改备注：
 */
public class CutoutCornersTreatment extends CornerTreatment {
    private float size;

    public CutoutCornersTreatment(float size) {
        this.size = size;
    }

    @Override
    public void getCornerPath(@NonNull @NotNull ShapePath shapePath, float angle, float interpolation, float radius) {
        super.getCornerPath(shapePath, angle, interpolation, radius);
        shapePath.reset(0.0f, size * interpolation);
        shapePath.lineTo(size * interpolation, size * interpolation);
        shapePath.lineTo(size * interpolation, 0f);
    }
}
