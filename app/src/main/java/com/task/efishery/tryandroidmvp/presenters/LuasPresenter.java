package com.task.efishery.tryandroidmvp.presenters;

import com.task.efishery.tryandroidmvp.models.LuasModel;
import com.task.efishery.tryandroidmvp.views.LuasView;

/**
 * Created by syauqi on 07/09/17.
 */

public class LuasPresenter {
    private LuasView mLuasView;
    private LuasModel mLuasModel;

    public LuasPresenter(LuasView luasView){
        mLuasView = luasView;
    }

    public void hitungLuas(int panjang, int lebar){
        int luas = luasPersegi(panjang,lebar);
        mLuasModel = new LuasModel(luas);
        mLuasView.tampilkanLuas(mLuasModel);
    }

    private int luasPersegi(int panjang, int lebar){
        return panjang*lebar;
    }

    public void detachView(){
        mLuasView = null;
    }
}
