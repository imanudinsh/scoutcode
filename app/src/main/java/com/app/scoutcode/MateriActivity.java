package com.app.scoutcode;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MateriActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<FeddProperties> tMateri ;
    private RecyclerView.Adapter mAdapter;
    private Toolbar toolbar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle("Materi");
        collapsingToolbar.setBackgroundResource(R.drawable.bgmateri);
        initContrls();

    }

    private void initContrls() {


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        final String[] namaMateri =  { "Semaphore", "Morse", "Sandi Rumput", "Sandi Kotak", "Sandi Kotak Ganda", "Sandi Angka", "Sandi AN", "Sandi AZ", "Sandi Kardinal","Sandi Internasional"};
        final int[] icons = {R.drawable.openpage, R.drawable.openpage, R.drawable.openpage, R.drawable.openpage, R.drawable.openpage, R.drawable.openpage, R.drawable.openpage, R.drawable.openpage, R.drawable.openpage, R.drawable.openpage};


        tMateri = new ArrayList<FeddProperties>();

        for (int i = 0; i < namaMateri.length; i++) {
            FeddProperties feed = new FeddProperties();

            feed.setTitle(namaMateri[i]);
            feed.setThumbnail(icons[i]);
            tMateri.add(feed);
        }

        recyclerView.setHasFixedSize(true);

        // ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Grid View
        // recyclerView.setLayoutManager(new GridLayoutManager(this,2,1,false));

        //StaggeredGridView
        // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));

        // create an Object for Adapter
        mAdapter = new CardViewDataAdapter(tMateri, "Materi");

        // set the adapter object to the Recyclerview
        recyclerView.setAdapter(mAdapter);



    }
}
