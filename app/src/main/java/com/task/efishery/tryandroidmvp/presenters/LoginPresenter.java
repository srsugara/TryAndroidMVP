package com.task.efishery.tryandroidmvp.presenters;

import com.task.efishery.tryandroidmvp.views.LoginContract;
import com.task.efishery.tryandroidmvp.models.LoginManager;

/**
 * Created by syauqi on 07/09/17.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.LoginView mView;
    private boolean isLoggedIn;
    private LoginManager mLoginManager;

    public LoginPresenter(LoginContract.LoginView view){
        mView = view;
        mLoginManager = LoginManager.getInstance();
    }

    @Override
    public void doLogin(String username, String password) {
        if (!isLoggedIn) {
           if(mLoginManager.validate(username,password)) {
               isLoggedIn = true;
               mView.loginSuccess("Logout");
               mView.showMessage("Login Berhasil");
           }else{
               mView.showMessage("Login Gagal");
           }
        }else{
            isLoggedIn = false;
            mView.logout("Login");
            mView.showMessage("Logout Berhasil");
        }
    }

    public void detachView(){
        mView = null;
    }
}
