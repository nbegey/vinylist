package com.theneversleepingwinds.vinylist.presentation.epoxy;

import android.support.annotation.NonNull;

import com.airbnb.epoxy.TypedEpoxyController;
import com.theneversleepingwinds.vinylist.BuildConfig;

/**
 * @Author Nicolas BEGEY - 18-03-07.
 */

public abstract class BaseTypedEpoxyController<T> extends TypedEpoxyController<T> {

    public BaseTypedEpoxyController() {
        setFilterDuplicates(!BuildConfig.DEBUG);
    }

    @Override
    protected void onExceptionSwallowed(@NonNull RuntimeException exception) {
        super.onExceptionSwallowed(exception);


        //Timber.e(exception, "Exception when building RecyclerView Items with Epoxy.");
    }
}