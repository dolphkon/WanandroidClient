package com.dolphkon.httplib.base;
import android.os.Bundle;
import androidx.annotation.Nullable;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：BaseMvpActivity
 * Author: kongdexi
 * Date: 2020/10/12 20:23
 * Description:TODO
 * *****************************************************
 */
public abstract class BaseMvpActivity<P> extends BaseActivity implements BaseView{
    public P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }

        if (mPresenter == null) {
            throw new NullPointerException("mPresenter 不能为空!");
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        mPresenter=null;
        super.onDestroy();
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
        showProgressDialog();
    }

    @Override
    public void showLoading(String msg) {
        showProgressDialog(msg);
    }

    @Override
    public void showLoading(int msgid) {
        showProgressDialog(msgid);
    }

    @Override
    public void hideLoading() {
        dismissProgressDialog();
    }
}