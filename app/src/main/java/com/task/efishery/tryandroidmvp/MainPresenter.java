package com.task.efishery.tryandroidmvp;

/**
 * Created by syauqi on 07/09/17.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.LoginView mView;
    private boolean isLoggedIn;
    private LoginManager mLoginManager;

    public MainPresenter(MainContract.LoginView view){
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
