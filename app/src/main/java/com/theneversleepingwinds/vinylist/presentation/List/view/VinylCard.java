package com.theneversleepingwinds.vinylist.presentation.List.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.ModelView;
import com.airbnb.epoxy.TextProp;
import com.theneversleepingwinds.vinylist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author Nicolas BEGEY - 18-03-07.
 */

@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT)
public class VinylCard extends CardView {

    private static final int LAYOUT = R.layout.vinyl_item;

    @BindView(R.id.vinyl_item_artist) TextView artist;
    @BindView(R.id.vinyl_item_tilte) TextView title;

    public VinylCard(Context context) {
        this(context, null);
    }

    public VinylCard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VinylCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = inflate(context, LAYOUT, this);
        ButterKnife.bind(this, view);
    }

    /**
     * Définit le nom de l'artiste.
     * @param artistName Nom de l'artiste
     */
    @TextProp
    public void setArtistName(CharSequence artistName) {
        artist.setText(artistName);
    }

    /**
     * Définit le titre.
     * @param vinylTitle Titre du vinyle
     */
    @TextProp
    public void setTitle(CharSequence vinylTitle) {
        title.setText(vinylTitle);
    }
}
