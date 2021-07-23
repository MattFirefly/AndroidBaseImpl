package com.gm.q.example.ui.markdown;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 项目名称：AndroidBaseImpl
 * 类描述：
 * 创建人：zhanggangmin
 * 创建时间：2021/7/22 18:16
 * 修改人：zhanggangmin
 * 修改时间：2021/7/22 18:16
 * 修改备注：
 */
public class MarkDownViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    public MarkDownViewModel() {
        mText=new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}
