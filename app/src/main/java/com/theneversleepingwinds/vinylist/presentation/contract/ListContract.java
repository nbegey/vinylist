package com.theneversleepingwinds.vinylist.presentation.contract;

/**
 * @author Nicolas BEGEY
 */
public interface ListContract {
    interface View{

    }

    interface Presenter{
        void attachView(View view);
        void detachView();
    }
}
