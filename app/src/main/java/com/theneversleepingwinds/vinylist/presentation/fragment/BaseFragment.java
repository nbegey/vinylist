package com.theneversleepingwinds.vinylist.presentation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    private int mTitleResID;
    private int mLayoutResID;
    private int mMenuResID;

    protected void setTitle(@Nullable @StringRes Integer titleResID) {
        mTitleResID = titleResID != null ? titleResID : -1;
    }

    protected void setOptionsMenu(@MenuRes int menuResID) {
        setHasOptionsMenu(true);
        mMenuResID = menuResID;
    }

    protected void setContentView(@LayoutRes int layoutResID) {
        mLayoutResID = layoutResID;
    }

    @Nullable
    @Override
    final public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;

        if (mLayoutResID != 0) {
            view = inflater.inflate(mLayoutResID, container, false);
            onBindView(view);
        }

        return view;
    }

    protected void onBindView(View view) {
        ButterKnife.bind(this,view);
    }

    @Override
    final public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(mMenuResID, menu);
    }

    @Override
    public void onResume() {
        super.onResume();

        ActionBar actionBar = getAppCompatActivity().getSupportActionBar();

        if (mTitleResID != 0 && actionBar != null) {
            if (mTitleResID != -1) {
                actionBar.setTitle(mTitleResID);
            }
            else {
                actionBar.setTitle("");
            }
        }
    }
    protected AppCompatActivity getAppCompatActivity() {
        try {
            return (AppCompatActivity) getActivity();
        }
        catch (ClassCastException e) {
            throw new RuntimeException("Subclasses of BaseFragment MUST be used within an AppCompatActivity");
        }
    }
}
