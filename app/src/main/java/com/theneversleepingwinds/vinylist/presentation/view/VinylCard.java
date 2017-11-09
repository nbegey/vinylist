package com.theneversleepingwinds.vinylist.presentation.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.theneversleepingwinds.vinylist.R;
import com.theneversleepingwinds.vinylist.presentation.model.VinylPresentation;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Nicolas BEGEY
 */
public class VinylCard extends ConstraintLayout {

    private static final int LAYOUT = R.layout.vinyl_item;

    @BindView(R.id.vinyl_item_artist) TextView artist;
    @BindView(R.id.vinyl_item_tilte) TextView title;

    private Listener mListener;

    public VinylCard(@NonNull Context context) {
        super(context);
        init();
    }

    public VinylCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VinylCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        View view = inflate(getContext(), LAYOUT, this);
        ButterKnife.bind(this, view);

        artist.setText("lalalal");
    }

    public void setModel(VinylPresentation vinylPresentation){
        artist.setText(vinylPresentation.artist);
        title.setText(vinylPresentation.title);
    }

    public void setListener(Listener listener){
        this.mListener = listener;
    }

    public interface Listener{}
}
