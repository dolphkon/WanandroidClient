package com.dolphkon.httplib.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/12 20:39
 * Description:TODO
 * *****************************************************
 */
public abstract class BaseMvpFragment<P> extends BaseFragment implements BaseView<P> {
    private P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        if (mPresenter == null) {
            throw new NullPointerException("mPresenter 不能为空!");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter = null;
    }

    protected abstract P createPresenter();

    @Override
    public void showToast(String msg) {
        toast(msg);
    }

    @Override
    public void showToast(int msgId) {
        toast(msgId);
    }

    @Override
    public void showLoading() {
        showLoading();
    }

    @Override
    public void showLoading(String msg) {
        showLoading(msg);
    }

    @Override
    public void showLoading(int msgId) {
        showLoading(msgId);
    }

    @Override
    public void hideLoading() {
        dismissProgressDialog();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


}
