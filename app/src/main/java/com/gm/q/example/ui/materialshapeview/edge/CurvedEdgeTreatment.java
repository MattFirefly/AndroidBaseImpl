package com.gm.q.example.ui.materialshapeview.edge;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;

/**
 * 项目名称：AndroidBaseImpl
 * 类描述：
 * 创建人：zhanggangmin
 * 创建时间：2021/7/17 15:39
 * 修改人：zhanggangmin
 * 修改时间：2021/7/17 15:39
 * 修改备注：
 */
public class CurvedEdgeTreatment extends EdgeTreatment {

    private final float radius;

    public CurvedEdgeTreatment(float radius) {
        this.radius = radius ;
    }

    @Override
    public void getEdgePath(float length, float center, float interpolation, @NonNull @NotNull ShapePath shapePath) {
        //shapePath.quadToPoint(length / 2f, radius * interpolation, length, 0f);
        shapePath.quadToPoint(center, radius * interpolation, length, 0f);
    }
}
