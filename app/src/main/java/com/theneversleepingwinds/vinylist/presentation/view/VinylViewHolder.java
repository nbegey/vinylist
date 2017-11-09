package com.theneversleepingwinds.vinylist.presentation.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author Nicolas BEGEY
 */
public class VinylViewHolder extends RecyclerView.ViewHolder {
    protected VinylCard mVinylCard;

    public VinylViewHolder(View itemView) {
        super(itemView);

        mVinylCard = (VinylCard) itemView;
    }
}
