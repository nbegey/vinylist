package com.theneversleepingwinds.vinylist.presentation.view;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author Nicolas BEGEY
 */
public class ListAdapter extends RecyclerView.Adapter<VinylViewHolder> {
    private List<VinylViewItem> mVinylItems;

    public ListAdapter(List<VinylViewItem> vinyls){
        this.mVinylItems = vinyls;
    }

    public VinylViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VinylViewHolder((new VinylCard(parent.getContext())));
    }

    public void onBindViewHolder(VinylViewHolder holder, int position) {
        VinylViewItem item = this.mVinylItems.get(position);
        item.bind(holder);
    }

    @Override
    public int getItemCount() {
        return mVinylItems.size();
    }
}
