package com.dolphkon.wanandroidclient.ui;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dolphkon.httplib.base.BaseMvpActivity;
import com.dolphkon.httplib.utils.LoadingDialog;
import com.dolphkon.httplib.utils.ToastUtils;
import com.dolphkon.wanandroidclient.ClearEditText;
import com.dolphkon.wanandroidclient.R;
import com.dolphkon.wanandroidclient.bean.RegisterResp;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.wanandroidclient.ui
 * ClassName：LoginActivity
 * Author: kongdexi
 * Date: 2020/10/29 11:30
 * Description:TODO
 * *****************************************************
 */
public class LoginActivity extends BaseMvpActivity<LoginContract.Presenter> implements LoginContract.View {
    @BindView(R.id.edit_account)
    ClearEditText editAccount;
    @BindView(R.id.edit_password)
    ClearEditText editPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.ll_repassword)
    LinearLayout llRepassword;
    @BindView(R.id.edit_repassword)
    ClearEditText editRepassword;
    private boolean isLogin = true;
    private String account;
    private String password;
    private String rePassword;
    private LoadingDialog dialog;

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getResourceId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginContract.Presenter createPresenter() {
        return new LoginPresenter(this, this);
    }


    @OnClick({R.id.btn_login, R.id.tv_register})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (!isLogin) {
                    RegisterVerification();
                    return;

                }
                loginVerification();

                break;
            case R.id.tv_register:
                llRepassword.setVisibility(View.VISIBLE);
                isLogin = false;
                btnLogin.setText("注册");
                tvRegister.setVisibility(View.GONE);
                break;
        }
    }


    private void RegisterVerification(){
        account = editAccount.getText().toString().trim();
        password = editPassword.getText().toString().trim();
        rePassword = editRepassword.getText().toString().trim();
        if (TextUtils.isEmpty(account)){
            ToastUtils.showToast("请输入用户名");
            return;
        }

        if (TextUtils.isEmpty(password)){
            ToastUtils.showToast("请输入密码");
            return;
        }

        if (TextUtils.isEmpty(rePassword)){
            ToastUtils.showToast("请再次输入密码");
            return;
        }
        mPresenter.register(account,password,rePassword);
    }
    /***
     *  注册成功
     * */
    @Override
    public void updateRegisterView(RegisterResp registerResp) {
        ToastUtils.showToast("注册成功");
    }

    @Override
    public void login(RegisterResp registerResp) {
        ToastUtils.showToast("开始登陆");
    }


    private void loginVerification(){
        account = editAccount.getText().toString().trim();
        password = editPassword.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            ToastUtils.showToast("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtils.showToast("请输入密码");
            return;
        }
      mPresenter.login(account,password);
    }
}
