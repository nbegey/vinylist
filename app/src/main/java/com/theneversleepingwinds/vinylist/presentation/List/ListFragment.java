package com.theneversleepingwinds.vinylist.presentation.List;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.airbnb.epoxy.EpoxyRecyclerView;
import com.theneversleepingwinds.vinylist.R;
import com.theneversleepingwinds.vinylist.presentation.ListViewModelLiveData;
import com.theneversleepingwinds.vinylist.presentation.epoxy.ListVinylController;
import com.theneversleepingwinds.vinylist.presentation.fragment.BaseFragment;
import com.theneversleepingwinds.vinylist.presentation.model.VinylPresentation;

import java.util.UUID;

import butterknife.BindView;

/**
 * @author Nicolas BEGEY
 */
public class ListFragment extends BaseFragment{

    public static final String TAG = ListFragment.class.getSimpleName();

    private static final int LAYOUT = R.layout.fragment_list;

    @BindView(R.id.fragment_list_recyclerview) EpoxyRecyclerView mRecyclerView;
    @BindView(R.id.fragment_list_add_vinyl) Button mAddVinylButton;

    private final ListVinylController mController = new ListVinylController();

    private ListViewModelLiveData mListViewModel;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListViewModel = ViewModelProviders.of(this).get(ListViewModelLiveData.class);
        setContentView(LAYOUT);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mController.getAdapter());

        mAddVinylButton.setOnClickListener(v -> {
            Log.i("a", "clic");

            VinylPresentation vinylmock = new VinylPresentation();
            vinylmock.artist = "test";
            vinylmock.title = "add";
            vinylmock.id = UUID.randomUUID().toString();

            mListViewModel.addVinyl(vinylmock);

            updateController();
        });

        addMockVinyl();
    }

    private void addMockVinyl() {

        VinylPresentation vinylmock;
        for (int i = 0 ; i < 10 ; i++){
            vinylmock = new VinylPresentation();
            vinylmock.artist = "Green";
            vinylmock.title = "lalala";
            vinylmock.id = UUID.randomUUID().toString();

            mListViewModel.addVinyl(vinylmock);
        }

        updateController();
    }

    private void updateController() {
        Log.e("items : ", mListViewModel.getVinyls().getValue().size()+"");
        mController.setData(mListViewModel);
    }

}
