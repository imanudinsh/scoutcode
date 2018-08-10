package com.app.scoutcode;


import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class LevelLatihanActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<FeddProperties> tLevelLatihan;
    private RecyclerView.Adapter mAdapter;
    private Toolbar toolbar;
    String jlatihan;
    String myJSON;
    String iduser;
    JSONArray level = null;
    ArrayList<HashMap<String, String>> detaillevel;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);


        jlatihan = getIntent().getExtras().getString("jlatihan");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(jlatihan);


        String idjenis = null;
        switch (jlatihan) {
            case "Semaphore": idjenis = "1"; break;
            case "Morse": idjenis = "2"; break;
            case "Sandi Rumput": idjenis = "3"; break;
            case "Sandi Kotak": idjenis = "4"; break;
            case "Sandi Kotak Ganda": idjenis = "5"; break;
            case "Sandi Angka": idjenis = "6"; break;
            case "Sandi AN": idjenis = "7"; break;
            case "Sandi AZ": idjenis = "8"; break;
            case "Sandi Kardinal": idjenis = "9"; break;
            case "Sandi Internasional": idjenis = "10"; break;
        }

        DBAdapter db = new DBAdapter(this);
        db.open();
        Cursor c = db.ambildata("iduser");
        if (c.moveToFirst()) {
            do {
                iduser = c.getString(1);
            } while (c.moveToNext());

        }
        db.close();


        getLevel(idjenis);

    }

    private void initContrls(String jsonLevel) {
        try {
            JSONObject jsonObj = new JSONObject(jsonLevel);
            level = jsonObj.getJSONArray("result");

            final String namalevel[] = new String[level.length()];
            final int icons[] = new int[level.length()];
            final String levelno[] = new String[level.length()];

            for (int i = 0; i < level.length(); i++) {
                JSONObject c = level.getJSONObject(i);
                namalevel[i] = jlatihan+" "+c.getString("level");
                levelno[i] = c.getString("level");

                icons[i] = R.drawable.ic_lock;
                if(c.has("aktif")) {
                    icons[i] = R.drawable.task;
                }
            }


            recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


             


            tLevelLatihan = new ArrayList<FeddProperties>();

            for (int i = 0; i < namalevel.length; i++) {
                FeddProperties feed = new FeddProperties();

                feed.setTitle(namalevel[i]);
                feed.setThumbnail(icons[i]);
                tLevelLatihan.add(feed);
            }

            recyclerView.setHasFixedSize(true);

            // ListView
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            //Grid View
            // recyclerView.setLayoutManager(new GridLayoutManager(this,2,1,false));

            //StaggeredGridView
            // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));

            // create an Object for Adapter
            mAdapter = new CardViewDataAdapter(tLevelLatihan, "LevelLatihan");

            // set the adapter object to the Recyclerview
            recyclerView.setAdapter(mAdapter);

        }catch (Exception ex){

        }
    }

    private void getLevel(String idjenis) {
        class SetLevel extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            SignUser ruc = new SignUser();
            String idjenis;

            public SetLevel(String idjenis){
                this.idjenis = idjenis;
            }


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = new ProgressDialog(LevelLatihanActivity.this);
                loading.setMessage("Please wait...");
                loading.setIndeterminate(false);
                loading.setCancelable(true);
                loading.show();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                myJSON=s;
                initContrls(myJSON);
            }

            @Override
            protected String doInBackground(String... params) {
                HashMap<String, String> data = new HashMap<String,String>();


                String result = ruc.sendPostRequest("http://scoutcode.web.id/services/getlevel.php?id="+idjenis+"&user="+iduser, data);

                return  result;
            }
        }
        
        SetLevel sl = new SetLevel(idjenis);
        sl.execute();

    }
}
