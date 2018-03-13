package com.theneversleepingwinds.vinylist.presentation.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.theneversleepingwinds.vinylist.R;
import com.theneversleepingwinds.vinylist.presentation.List.ListFragment;

public class ListActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list);

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(new ListFragment(), ListFragment.TAG)
                    .commit();
        }
    }
}
