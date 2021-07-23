package com.gm.q.example.ui.materialshapeview;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ConvertUtils;
import com.gm.q.example.R;
import com.gm.q.example.databinding.FragmentTreatmentBinding;
import com.gm.q.example.ui.materialshapeview.corner.CutoutCornersTreatment;
import com.gm.q.example.ui.materialshapeview.edge.ArgEdgeTreatment;
import com.gm.q.example.ui.materialshapeview.edge.CurvedEdgeTreatment;
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.TriangleEdgeTreatment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import static com.google.android.material.shape.MaterialShapeDrawable.SHADOW_COMPAT_MODE_ALWAYS;

/**
 * <P>CornerTreatment</P>
 * roundedcornertreatment 圆角方案
 * CutCornerTreatment 折角方案
 * <P>EdgeTreatment</P>
 * TriangleEdgeTreatment 三角形
 * MarkerEdgeTreatment 类似于地图的兴趣点
 * OffsetEdgeTreatment 位移
 * BottomAppBarTopEdgeTreatment 应该是中间带有悬浮按钮的效果
 * <p>
 * 在使用中遇到一个问题，箭头向内有效果，但是箭头向下竟然没有效果，经查询需要在应用drawable的父类中增加如下参数：
 * <code>android:clipChildren="false" android:clipToPadding="false" </code>
 **/
public class TreatmentFragment extends Fragment {
    private FragmentTreatmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTreatmentBinding.inflate(inflater, container, false);
        binding.imageView1.setImageDrawable(TriangleEdgeTreatment());
        binding.imageView2.setImageDrawable(MarkerEdgeTreatment());
        binding.imageView3.setImageDrawable(CurvedEdgeTreatment());
        binding.imageView4.setImageDrawable(ArgEdgeTreatment());

        binding.imageView5.setShapeAppearanceModel(binding.imageView5.getShapeAppearanceModel().toBuilder().setTopEdge(BottomAppBarTopEdgeTreatment2()).build());
        ViewCompat.setBackground(binding.imageView5, BottomAppBarTopEdgeTreatment());
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public MaterialShapeDrawable TriangleEdgeTreatment() {
        ShapeAppearanceModel appearanceModel = ShapeAppearanceModel.builder()
                .setAllCornerSizes(ConvertUtils.dp2px(8F))//RoundedCornerTreatment 默认圆角
                .setBottomEdge(new OffsetEdgeTreatment(new TriangleEdgeTreatment(ConvertUtils.dp2px(8F), false), ConvertUtils.dp2px(-36F)))//中心偏移多少
//                .setBottomEdge(new TriangleEdgeTreatment(ConvertUtils.dp2px(8F), false))
                .build();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(appearanceModel);
        materialShapeDrawable.setTint(R.attr.colorPrimary);
        materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
        return materialShapeDrawable;
    }

    public MaterialShapeDrawable MarkerEdgeTreatment() {
        ShapeAppearanceModel appearanceModel = ShapeAppearanceModel.builder()
                .setAllCorners(new CutCornerTreatment())//角
                .setAllCornerSizes(ConvertUtils.dp2px(8F))
                .setBottomEdge(new MarkerEdgeTreatment(ConvertUtils.dp2px(16F)))//边
                .build();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(appearanceModel);
        materialShapeDrawable.setTint(R.attr.colorPrimary);
        materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
        return materialShapeDrawable;
    }

    public MaterialShapeDrawable BottomAppBarTopEdgeTreatment() {
        ShapeAppearanceModel appearanceModel = ShapeAppearanceModel.builder()
                .setAllCornerSizes(ConvertUtils.dp2px(0f))
                //距离 切多大 偏移多少
                .setTopEdge(new BottomAppBarTopEdgeTreatment(ConvertUtils.dp2px(8F), ConvertUtils.dp2px(8F), ConvertUtils.dp2px(2F)))//边
                .build();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(appearanceModel);
        materialShapeDrawable.setShapeAppearanceModel(appearanceModel);
        materialShapeDrawable.setShadowCompatibilityMode(SHADOW_COMPAT_MODE_ALWAYS);
        materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
        materialShapeDrawable.initializeElevationOverlay(getContext());
        return materialShapeDrawable;
    }

    public BottomAppBarTopEdgeTreatment BottomAppBarTopEdgeTreatment2() {
        return new BottomAppBarTopEdgeTreatment(ConvertUtils.dp2px(8F), ConvertUtils.dp2px(8F), ConvertUtils.dp2px(2F));//边
    }


    /**
     * 自定义
     *
     */
    public MaterialShapeDrawable CurvedEdgeTreatment() {
        ShapeAppearanceModel appearanceModel = ShapeAppearanceModel.builder()
                .setAllCorners(new CutoutCornersTreatment(ConvertUtils.dp2px(8F)))//角
                .setAllEdges(new CurvedEdgeTreatment(ConvertUtils.dp2px(16F)))//边
                .build();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.setTint(R.attr.colorPrimary);
        return materialShapeDrawable;
    }

    /**
     * 自定义
     *
     */
    public MaterialShapeDrawable ArgEdgeTreatment() {
        ShapeAppearanceModel appearanceModel = ShapeAppearanceModel.builder()
                .setAllEdges(new ArgEdgeTreatment(ConvertUtils.dp2px(16F),true))//边
                .build();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(appearanceModel);
        materialShapeDrawable.setTint(R.attr.colorPrimary);
        return materialShapeDrawable;
    }

}