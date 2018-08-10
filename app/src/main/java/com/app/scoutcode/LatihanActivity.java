package com.app.scoutcode;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class LatihanActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<FeddProperties> tLatihan ;
    private RecyclerView.Adapter mAdapter;
    private Toolbar toolbar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle("Latihan");
        collapsingToolbar.setBackgroundResource(R.drawable.bglatihan);

        initContrls();

    }

    private void initContrls() {


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        final String[] namaTranslator =  { "Semaphore", "Morse", "Sandi Rumput", "Sandi Kotak", "Sandi Kotak Ganda", "Sandi Angka", "Sandi AN", "Sandi AZ", "Sandi Kardinal", "Sandi Internasional"};
        final int[] icons = {R.drawable.task, R.drawable.task, R.drawable.task, R.drawable.task, R.drawable.task, R.drawable.task, R.drawable.task, R.drawable.task, R.drawable.task, R.drawable.task};


        tLatihan = new ArrayList<FeddProperties>();

        for (int i = 0; i < namaTranslator.length; i++) {
            FeddProperties feed = new FeddProperties();

            feed.setTitle(namaTranslator[i]);
            feed.setThumbnail(icons[i]);
            tLatihan.add(feed);
        }

        recyclerView.setHasFixedSize(true);

        // ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Grid View
        // recyclerView.setLayoutManager(new GridLayoutManager(this,2,1,false));

        //StaggeredGridView
        // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));

        // create an Object for Adapter
        mAdapter = new CardViewDataAdapter(tLatihan, "Latihan");

        // set the adapter object to the Recyclerview
        recyclerView.setAdapter(mAdapter);



    }
}



