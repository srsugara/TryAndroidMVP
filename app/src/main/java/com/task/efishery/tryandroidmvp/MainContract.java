package com.task.efishery.tryandroidmvp;

/**
 * Created by syauqi on 07/09/17.
 */

public interface MainContract {
    interface LoginView {
        void loginSuccess(String title);
        void logout(String title);
        void showMessage(String message);
    }
    interface Presenter {
        void doLogin(String username, String password);
    }
}
