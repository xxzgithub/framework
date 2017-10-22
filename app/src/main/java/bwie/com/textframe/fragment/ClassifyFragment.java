package bwie.com.textframe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bwie.com.textframe.R;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/8
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class ClassifyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_classify, container, false);
        return inflate;
    }
}
