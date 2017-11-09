package com.theneversleepingwinds.vinylist.presentation.view;

import com.theneversleepingwinds.vinylist.presentation.model.VinylPresentation;

/**
 * @author Nicolas BEGEY
 */
public class VinylViewItem {
    private VinylPresentation mVinyl;

    public VinylViewItem(VinylPresentation vinylPresentation){
        this.mVinyl = vinylPresentation;
    }

    public void bind(VinylViewHolder viewHolder){
        viewHolder.mVinylCard.setModel(mVinyl);
    }
}
