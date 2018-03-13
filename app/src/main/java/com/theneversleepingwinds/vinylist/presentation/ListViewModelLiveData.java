package com.theneversleepingwinds.vinylist.presentation;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.theneversleepingwinds.vinylist.presentation.model.VinylPresentation;

import java.util.ArrayList;

/**
 * @Author Nicolas BEGEY - 18-03-08.
 */

public class ListViewModelLiveData extends ViewModel {
    private MutableLiveData<ArrayList<VinylPresentation>> mVinyls;

    public MutableLiveData<ArrayList<VinylPresentation>> getVinyls(){
        if(mVinyls == null){
            mVinyls = new MutableLiveData<>();
            mVinyls.setValue(new ArrayList<>());
        }

        return mVinyls;
    }

    public void addVinyl(VinylPresentation vinylPresentation){
        getVinyls().getValue().add(vinylPresentation);
    }
}