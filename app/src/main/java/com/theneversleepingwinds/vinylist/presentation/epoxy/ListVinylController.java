package com.theneversleepingwinds.vinylist.presentation.epoxy;

import com.theneversleepingwinds.vinylist.presentation.List.view.VinylCardModel_;
import com.theneversleepingwinds.vinylist.presentation.ListViewModelLiveData;
import com.theneversleepingwinds.vinylist.presentation.model.VinylPresentation;

/**
 * @Author Nicolas BEGEY - 18-03-07.
 */

public class ListVinylController extends BaseTypedEpoxyController<ListViewModelLiveData> {

    @Override
    protected void buildModels(ListViewModelLiveData data) {
        for(VinylPresentation vinyl : data.getVinyls().getValue()){
            addVinylItem(vinyl);
        }
    }

    private void addVinylItem(VinylPresentation vinyl) {
        new VinylCardModel_()
                .id(vinyl.id)
                .artistName(vinyl.artist)
                .title(vinyl.title);
    }
}
