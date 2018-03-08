package com.theneversleepingwinds.vinylist.presentation.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.theneversleepingwinds.vinylist.R;
import com.theneversleepingwinds.vinylist.presentation.ListViewModel;
import com.theneversleepingwinds.vinylist.presentation.contract.ListContract;
import com.theneversleepingwinds.vinylist.presentation.model.VinylPresentation;
import com.theneversleepingwinds.vinylist.presentation.presenter.ListPresenter;
import com.theneversleepingwinds.vinylist.presentation.view.ListAdapter;
import com.theneversleepingwinds.vinylist.presentation.view.VinylViewItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author Nicolas BEGEY
 */
public class ListFragment extends BaseFragment implements ListContract.View{

    public static final String TAG = ListFragment.class.getSimpleName();

    private static final int LAYOUT = R.layout.fragment_list;

    @BindView(R.id.fragment_list_recyclerview) RecyclerView mRecyclerView;

    private ListContract.Presenter mPresenter;
    private List<VinylViewItem> mVinyls;
    private ListAdapter mAdapter;

    private ListViewModel mListViewModel;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListViewModel = ViewModelProviders.of(this).get(ListViewModel.class);

        mPresenter = new ListPresenter(getContext());
        mPresenter.attachView(this);

        setContentView(LAYOUT);

        mVinyls = new ArrayList<>();
        mAdapter = new ListAdapter(mVinyls);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        addMockVinyl();
    }

    private void addMockVinyl() {
        mVinyls.clear();

        VinylPresentation vinylmock = new VinylPresentation();
        vinylmock.artist = "Green";
        vinylmock.title = "lalala";

        mVinyls.add(new VinylViewItem(vinylmock));

        mAdapter.notifyItemChanged(mVinyls.size() - 1);
    }

    @Override
    public void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
