package com.dolphkon.httplib.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dolphkon.httplib.utils.LoadingDialog;
import com.dolphkon.httplib.utils.ToastUtils;
import com.trello.rxlifecycle3.components.RxFragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：BaseFragment
 * Author: kongdexi
 * Date: 2020/10/12 20:38
 * Description:TODO
 * *****************************************************
 */
public abstract class BaseFragment extends Fragment {
    protected abstract void initView();
    protected abstract void initData();
    protected abstract int getResourceId();
    Unbinder unbinder;
    public View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getResourceId(), null);
        unbinder = ButterKnife.bind(this, mView);
        initView();
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }


    /**
     * toast
     *
     * @param msg
     */
    protected void toast(String msg) {
        ToastUtils.showToast( msg);
    }


    protected void toast(int strId) {
        ToastUtils.showToast(strId);
    }


    /**
     * 加载对话框
     */
    LoadingDialog dialog;
    public void showProgressDialog() {
        showProgressDialog("");
    }

    protected void showProgressDialog(int msgId) {
        showProgressDialog(getString(msgId));

    }

    protected void showProgressDialog(String msg) {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        if (dialog == null) {
            dialog = new LoadingDialog(getActivity());
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
        }
        dialog.show();
        if (msg != null) {
            dialog.setMessage(msg);
        }

    }

    public void dismissProgressDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}

