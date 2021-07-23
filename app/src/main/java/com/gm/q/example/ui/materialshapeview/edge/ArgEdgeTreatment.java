package com.gm.q.example.ui.materialshapeview.edge;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;

/**
 * 项目名称：AndroidBaseImpl
 * 类描述：
 * 创建人：zhanggangmin
 * 创建时间：2021/7/17 16:21
 * 修改人：zhanggangmin
 * 修改时间：2021/7/17 16:21
 * 修改备注：
 */
public class ArgEdgeTreatment extends EdgeTreatment {
    private float size;
    private boolean inside;

    public ArgEdgeTreatment(float size) {
        this.size = size;
    }

    public ArgEdgeTreatment(float size, boolean inside) {
        this.size = size;
        this.inside = inside;
    }

    @Override
    public void getEdgePath(float length, float center, float interpolation, @NonNull @NotNull ShapePath shapePath) {
        float radius = size * interpolation;
        shapePath.lineTo(center - radius, 0f);
        shapePath.addArc(
                center - radius, -radius,
                center + radius, radius,
                180f,
                inside ? -180f : 180f);
        shapePath.lineTo(length, 0f);
    }
}
