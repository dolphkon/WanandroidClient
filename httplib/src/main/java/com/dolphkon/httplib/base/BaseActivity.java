package com.dolphkon.httplib.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.dolphkon.httplib.R;
import com.dolphkon.httplib.utils.LoadingDialog;
import com.dolphkon.httplib.utils.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/12 15:36
 * Description:TODO
 * *****************************************************
 */
public abstract class BaseActivity extends FragmentActivity {

    public static LinkedList<Activity> mStackList = new LinkedList<Activity>();
    private Unbinder unbinder;
    private LoadingDialog dialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f)//顶部状态栏，如果顶部颜色不可变时，将显示灰色阴影，顶部状态栏全白
                .statusBarColor(R.color.transparent)
                .init();
        if (null != getActionBar()) {
            getActionBar().hide();
        }
        setContentView(getResourceId());
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
    }

    public abstract void initView();

    public abstract void initData();

    public abstract int getResourceId();

    @Override
    protected void onPause() {
        hideSoftKeyBoard();
        super.onPause();
    }


    /**
     * Toast msg
     * */
    protected void toast(String msg) {
        ToastUtils.showToast( msg);
    }


    protected void toast(int strId) {
        ToastUtils.showToast(strId);
    }

    /**
     *  显示加载对话框
     * */
    public void showProgressDialog(){
        showProgressDialog("");
    }


    protected void showProgressDialog(String msg) {
        if (dialog == null) {
            dialog = new LoadingDialog(this);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
        }
        dialog.show();
        if (msg != null) {
            dialog.setMessage(msg);
        }

    }

    protected void showProgressDialog(int msgId) {
        showProgressDialog(getString(msgId));
    }

    /**
     *  隐藏加载对话框
     * */
    public void dismissProgressDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

/**
 *  移除所有的activity
 * */
    public static void RemoveAll() {
        ArrayList<Activity> tempList = new ArrayList<Activity>();
        for (final Activity activity : mStackList) {
            tempList.add(activity);
        }
        for (final Activity activity : tempList) {
            activity.finish();
            RemoveActivity(activity);
        }
        tempList.clear();
    }

    /** 移除某个activity
     * */
    private static void RemoveActivity(Activity activity) {
        if (null!=activity){
            activity.finish();
            mStackList.remove(activity);
        }
    }

    /**
     * 判断某个Activity是否在栈中
     *
     * @param activityName
     * @return
     */
    public static boolean hasActivity(String activityName) {
        for (Activity activity : mStackList) {
            if (activity.getClass().getSimpleName().equals(activityName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 移除某个类别的所有Activity
     *
     * @param activityName 2015年6月11日上午10:22:01 by mukry
     */
    public void RemoveActivity(String activityName) {
        if (TextUtils.isEmpty(activityName)) {
            return;
        }
        ArrayList<Activity> tempList = new ArrayList<Activity>();
        for (Activity activity : mStackList) {
            if (activityName.equals(activity.getClass().getSimpleName())) {
                tempList.add(activity);
            }
        }
        for (final Activity activity : tempList) {
            activity.finish();
            mStackList.remove(activity);
        }
    }

    protected void hideSoftKeyBoard(){
        try{
            View view = getCurrentFocus();
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            if (view != null&&imm!=null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }catch (Exception e){

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStackList.remove(this);
        ImmersionBar.with(this).destroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
