package com.app.scoutcode;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class TranslatorActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<FeddProperties> tTranslator ;
    private RecyclerView.Adapter mAdapter;
    private Toolbar toolbar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle("Translator");
        collapsingToolbar.setBackgroundResource(R.drawable.bgtranslator);

        initContrls();

    }

    private void initContrls() {


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        final String[] namaTranslator =  { "Semaphore", "Morse", "Sandi Rumput", "Sandi Kotak", "Sandi Kotak Ganda", "Sandi Angka", "Sandi AN", "Sandi AZ", "Sandi Kardinal", "Sandi Internasional"};
        final int[] icons = {R.drawable.translate, R.drawable.translate, R.drawable.translate, R.drawable.translate, R.drawable.translate, R.drawable.translate, R.drawable.translate, R.drawable.translate, R.drawable.translate, R.drawable.translate};


        tTranslator = new ArrayList<FeddProperties>();

        for (int i = 0; i < namaTranslator.length; i++) {
            FeddProperties feed = new FeddProperties();

            feed.setTitle(namaTranslator[i]);
            feed.setThumbnail(icons[i]);
            tTranslator.add(feed);
        }

        recyclerView.setHasFixedSize(true);

        // ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Grid View
        // recyclerView.setLayoutManager(new GridLayoutManager(this,2,1,false));

        //StaggeredGridView
        // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));

        // create an Object for Adapter
        mAdapter = new CardViewDataAdapter(tTranslator, "Translate");

        // set the adapter object to the Recyclerview
        recyclerView.setAdapter(mAdapter);



    }
}

class FeddProperties {


    private String title;
    private int thumbnail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

}

class CardViewDataAdapter extends RecyclerView.Adapter<CardViewDataAdapter.ViewHolder> {


    private static ArrayList<FeddProperties> dataSet;
    private static String jenis;

    public CardViewDataAdapter(ArrayList<FeddProperties> os_versions, String j) {

        dataSet = os_versions;
        jenis = j;
    }


    @Override
    public CardViewDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
// create a new view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.card_view, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewDataAdapter.ViewHolder viewHolder, int i) {

        FeddProperties fp = dataSet.get(i);

        viewHolder.tvVersionName.setText(fp.getTitle());
        viewHolder.iconView.setImageResource(fp.getThumbnail());
        viewHolder.feed = fp;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvVersionName;
        public ImageView iconView;

        private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.3F);

        public FeddProperties feed;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            tvVersionName = (TextView) itemLayoutView
                    .findViewById(R.id.tvVersionName);
            iconView = (ImageView) itemLayoutView
                    .findViewById(R.id.iconId);

            itemLayoutView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(jenis=="Latihan"){
                        Intent i = new Intent(v.getContext(),
                                LevelLatihanActivity.class);
                        i.putExtra("jlatihan", feed.getTitle());
                        v.getContext().startActivity(i);
                    }else if(jenis=="LevelLatihan"){
                        if(feed.getThumbnail()!=R.drawable.ic_lock) {
                            Intent i = new Intent(v.getContext(),
                                    PreLatihanActivity.class);
                            i.putExtra("jlatihan", feed.getTitle());
                            v.getContext().startActivity(i);
                        }
                    }else if(jenis=="Materi"){
                        Intent i = new Intent(v.getContext(),
                                DetailMateriActivity.class);
                        i.putExtra("jmateri", feed.getTitle());
                        v.getContext().startActivity(i);
                    }else{
                        switch (feed.getTitle()) {
                            case "Semaphore": {
                                Intent i = new Intent(v.getContext(),
                                        TSemaphoreActivity.class);
                                v.getContext().startActivity(i);
                                break;
                            }
                            case "Morse": {
                                Intent i = new Intent(v.getContext(),
                                        TMorseActivity.class);
                                v.getContext().startActivity(i);
                                break;
                            }
                            case "Sandi Kotak": {
                                Intent i = new Intent(v.getContext(),
                                        tSandiKotakActivity.class);
                                v.getContext().startActivity(i);
                                break;
                            }

                            case "Sandi Kotak Ganda": {
                                Intent i = new Intent(v.getContext(),
                                        TSandiKotakGandaActivity.class);
                                v.getContext().startActivity(i);
                                break;
                            }

                            case "Sandi Angka": {
                                Intent i = new Intent(v.getContext(),
                                        TSandiAngkaActivity.class);
                                v.getContext().startActivity(i);
                                break;
                            }
                            case "Sandi AN": {
                                Intent i = new Intent(v.getContext(),
                                        TSandiANActivity.class);
                                v.getContext().startActivity(i);
                                break;
                            }
                            case "Sandi AZ": {
                                Intent i = new Intent(v.getContext(),
                                        TSandiAZActivity.class);
                                v.getContext().startActivity(i);
                                break;
                            }
                            case "Sandi Kardinal": {
                                Intent i = new Intent(v.getContext(),
                                        TSandiKardinalActivity.class);
                                v.getContext().startActivity(i);
                                break;
                            }

                            case "Sandi Rumput": {
                                Intent i = new Intent(v.getContext(),
                                        TSandiRumputActivity.class);
                                v.getContext().startActivity(i);
                                break;
                            }

                            case "Sandi Internasional": {
                                Intent i = new Intent(v.getContext(),
                                        TSandiInternasionalActivity.class);
                                v.getContext().startActivity(i);
                                break;
                            }
                        }
                    }
                }
            });


        }

    }
}
