package com.theneversleepingwinds.vinylist.presentation.presenter;

import android.content.Context;

import com.theneversleepingwinds.vinylist.presentation.contract.ListContract;

/**
 * @author Nicolas BEGEY
 */
public class ListPresenter implements ListContract.Presenter {

    private ListContract.View mView;
    private Context mContext;

    public ListPresenter(final Context context){
        this.mContext = context;
    }

    @Override
    public void attachView(ListContract.View view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        mContext = null;
        this.mView = null;
    }
}
