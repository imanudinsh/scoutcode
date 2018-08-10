package com.app.scoutcode;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;


public class KerjakanLatihanActivity extends AppCompatActivity {
    private LinearLayout frameprogres;
    FlowLayout framesoal, framejawaban;
    private Toolbar toolbar;
    private ProgressBar progres;
    String jenis;
    String idjenis = null;
    String level = null;
    String myJSON;
    String iduser;
    String idsoal = null;
    int no = 0;
    int widthview;
    JSONArray soal = null;
    JSONArray info = null;
    CountDownLatihan cdl;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soallatihan);


        jenis = getIntent().getExtras().getString("jenis");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(jenis);


        framesoal = (FlowLayout) findViewById(R.id.framesoal);
        framejawaban = (FlowLayout) findViewById(R.id.framejawaban);
        frameprogres = (LinearLayout) findViewById(R.id.frameprogres);
        widthview = findViewById(R.id.scrollView5).getWidth();


        cdl = new CountDownLatihan(20000, 1000);
        DBAdapter db = new DBAdapter(this);
        db.open();
        Cursor c = db.ambildata("iduser");
        if (c.moveToFirst()) {
            do {
                iduser = c.getString(1);
            } while (c.moveToNext());

        }
        db.close();


        getSoal(jenis);

    }


    private void getSoal(String jenis) {
        class SetSoal extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            SignUser ruc = new SignUser();
            String jenis;

            public SetSoal(String jenis){
                this.jenis = jenis.replace(" ","%20");
            }


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = new ProgressDialog(KerjakanLatihanActivity.this);
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
                insertSoalJawaban(myJSON);
            }

            @Override
            protected String doInBackground(String... params) {
                HashMap<String, String> data = new HashMap<String,String>();


                String result = ruc.sendPostRequest("http://scoutcode.web.id/services/getsoal.php?q="+jenis, data);

                return  result;
            }
        }

        SetSoal sl = new SetSoal(jenis);
        sl.execute();

    }


    private void initContrls() {
        try {
            framesoal.removeAllViews();
            framejawaban.removeAllViews();
            DBAdapter db = new DBAdapter(this);
            db.open();
            Cursor c = db.selectsoal("tb_soal", "*", "status" , "1");
            if (c.moveToFirst()){
                cdl.start();
                do {
                    idsoal = c.getString(1);

                    LinearLayout lv = new LinearLayout(this);

                    TextView tv = new TextView(this);
                    if(idjenis.equals("1") && !level.equals("2")){
                        if(level.equals("1")) {
                            tv.setText(++no + ".  ");
                            tv.setTextSize(25);
                            lv.setPadding(5, 5, 5, 35);
                            lv.addView(tv);
                            insertsemaphore(c.getString(2), lv);
                        }else if(level.equals("3") || level.equals("3") || level.equals("4") || level.equals("5")) {
                            final String huruf = c.getString(2);
                            tv.setText(++no + ".  ");
                            tv.setTextSize(25);
                            lv.addView(tv);
                            lv.setPadding(5, 5, 5, 35);
                            final ImageView iv = new ImageView(this);
                            iv.setImageResource(R.drawable.sem_awal);
                            lv.addView(iv);
                            ImageButton btn = new ImageButton(this);
                            btn.setImageResource(R.drawable.ic_play);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    TranslitSemaphore ts = new TranslitSemaphore((huruf.length()+1) * 1000, 1000, huruf, iv);
                                    ts.start();
                                }
                            });
                            lv.addView(btn);
                        }

                    }else if(idjenis.equals("3") && level.equals("1")){
                        tv.setText(++no + ".  ");
                        tv.setTextSize(25);
                        lv.setPadding(5, 5, 5, 35);
                        lv.addView(tv);
                        insertimgrumput(c.getString(2), lv, 1);

                    }else if(idjenis.equals("4") && level.equals("1")){
                        tv.setText(++no + ".  ");
                        tv.setTextSize(25);
                        lv.setPadding(5, 5, 5, 35);
                        lv.addView(tv);
                        insertimgkotak(c.getString(2), lv);

                    }else if(idjenis.equals("5") && level.equals("1")){
                        tv.setText(++no + ".  ");
                        tv.setTextSize(25);
                        lv.setPadding(5, 5, 5, 35);
                        lv.addView(tv);
                        insertimgkotakganda(c.getString(2), lv);

                    }else if((level.equals("3") || level.equals("3") || level.equals("4") || level.equals("5")) && (idjenis.equals("3") || idjenis.equals("4") || idjenis.equals("5"))){
                        String huruf = c.getString(2);
                        tv.setText(++no + ".  ");
                        tv.setTextSize(25);
                        lv.setPadding(5, 5, 5, 35);
                        lv.addView(tv);
                        for (int i = 0; i < huruf.length(); i++){
                            Character inptext = huruf.charAt(i);
                            if(idjenis.equals("3")) {
                                if(i==huruf.length()-1){
                                    insertimgrumput(inptext.toString(), lv, 1);
                                }else{
                                    insertimgrumput(inptext.toString(), lv, 0);
                                }
                            }else if(idjenis.equals("4")) {
                                insertimgkotak(inptext.toString(), lv);
                            }else {
                                insertimgkotakganda(inptext.toString(), lv);
                            }
                        }

                    }else {
                        tv.setText(++no + ". ");

                        TextView tv2 = new TextView(this);
                        tv2.setText(Html.fromHtml("<b>" + c.getString(2)+"</b>"));
                        tv.setTextSize(25);

                        tv2.setTypeface(null, Typeface.BOLD);
                        tv2.setTextSize(30);
                        tv2.setPadding(10, 10, 10, 30);
                        lv.setPadding(5, 5, 5, 5);
                        lv.addView(tv);
                        lv.addView(tv2);
                    }

                    lv.setMinimumWidth(widthview);

                    framesoal.addView(lv);


                    Cursor d = db.selectdata("tb_jawaban", "*", "id_soal", c.getString(1));
                    int nojawab = 0;
                    if (d.moveToFirst()) {
                        do {
                            final String idjawab = d.getString(0);

                            if(level.equals("2") && idjenis.equals("1")){

                                ImageButton bt = new ImageButton(this);
                                optionsemaphore(d.getString(2), bt);
                                bt.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        DBAdapter dbq = new DBAdapter(getBaseContext());
                                        cdl.cancel();
                                        dbq.open();
                                        dbq.ubahsoalstatus(idsoal, "status", "1");
                                        dbq.ubahsoalstatus(idsoal, "jawab", idjawab);
                                        dbq.close();
                                        initContrls();
                                    }
                                });
                                framejawaban.addView(bt);
                            }else if(level.equals("2") && idjenis.equals("3")){

                                LinearLayout bt = new LinearLayout(this);
                                bt.setPadding(10,10,10,10);
                                bt.setClickable(true);
                                bt.setBackgroundColor(Color.parseColor("#dddddd"));

                                insertimgrumput(d.getString(2), bt, 1);
                                bt.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        DBAdapter dbq = new DBAdapter(getBaseContext());
                                        cdl.cancel();
                                        dbq.open();
                                        dbq.ubahsoalstatus(idsoal, "status", "1");
                                        dbq.ubahsoalstatus(idsoal, "jawab", idjawab);
                                        dbq.close();
                                        initContrls();
                                    }
                                });
                                framejawaban.addView(bt);
                            }else if(level.equals("2") && idjenis.equals("4")){

                                ImageButton bt = new ImageButton(this);
                                optionkotak(d.getString(2), bt);
                                bt.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        DBAdapter dbq = new DBAdapter(getBaseContext());
                                        cdl.cancel();
                                        dbq.open();
                                        dbq.ubahsoalstatus(idsoal, "status", "1");
                                        dbq.ubahsoalstatus(idsoal, "jawab", idjawab);
                                        dbq.close();
                                        initContrls();
                                    }
                                });
                                framejawaban.addView(bt);
                            }else if(level.equals("2") && idjenis.equals("5")){

                                ImageButton bt = new ImageButton(this);
                                optionkotakganda(d.getString(2), bt);
                                bt.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        DBAdapter dbq = new DBAdapter(getBaseContext());
                                        cdl.cancel();
                                        dbq.open();
                                        dbq.ubahsoalstatus(idsoal, "status", "1");
                                        dbq.ubahsoalstatus(idsoal, "jawab", idjawab);
                                        dbq.close();
                                        initContrls();
                                    }
                                });
                                framejawaban.addView(bt);
                            }else if(level.equals("3")){
                                if (nojawab==0) {
                                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(framejawaban.getWidth(),
                                            LinearLayout.LayoutParams.WRAP_CONTENT);
                                    final LinearLayout ll = new LinearLayout(this);
                                    ll.setOrientation(LinearLayout.VERTICAL);
                                    ll.setLayoutParams(lp);
                                    final EditText et = new EditText(this);
                                    et.setLayoutParams(lp);
                                    et.setId(R.id.txtinp);
                                    Button bt = new Button(this);
                                    bt.setText("Submit");
                                    bt.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            DBAdapter dbq = new DBAdapter(getBaseContext());
                                            cdl.cancel();
                                            dbq.open();
                                            dbq.ubahsoalstatus(idsoal, "status", "1");
                                            dbq.ubahsoalstatus(idsoal, "jawab", et.getText().toString());
                                            dbq.close();
                                            initContrls();
                                        }
                                    });
                                    ll.addView(et);
                                    ll.addView(bt);
                                    framejawaban.addView(ll);
                                }
                            }else {
                                Button bt = new Button(this);
                                bt.setText(d.getString(2));
                                bt.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        DBAdapter dbq = new DBAdapter(getBaseContext());
                                        cdl.cancel();
                                        dbq.open();
                                        dbq.ubahsoalstatus(idsoal, "status", "1");
                                        dbq.ubahsoalstatus(idsoal, "jawab", idjawab);
                                        dbq.close();
                                        initContrls();
                                    }
                                });
                                framejawaban.addView(bt);
                            }

                            nojawab++;
                        } while (d.moveToNext());
                    }
                } while (c.moveToNext());
            }else {
                int grade=0;
                Cursor s = db.selecttable("tb_soal", "*");
                if (s.moveToFirst()) {
                    do {
                        if(level.equals("3")){
                            Cursor j = db.selectdata("tb_jawaban", "*", "jawaban='"+s.getString(3).toLowerCase()+"' and id_soal", s.getString(0));
                            if (j.moveToFirst()) {
                                grade = grade + 10;
                            }
                        }else {
                            Cursor j = db.selectdata("tb_jawaban", "*", "value='1' and id_jawaban", s.getString(3).toLowerCase());
                            if (j.moveToFirst()) {
                                grade = grade + 10;
                            }
                        }
                    } while (s.moveToNext());
                }

                frameprogres.removeAllViews();
                grading(String.valueOf(grade));
            }
            db.close();


        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), "Error\n"+ex.toString(), Toast.LENGTH_LONG).show();
        }
    }

    private void insertSoalJawaban(String myJSON){
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            soal = jsonObj.getJSONArray("result");
            info = jsonObj.getJSONArray("info");

            DBAdapter db = new DBAdapter(this);
            db.open();
            db.buattabel();
            db.kosongkantabel("tb_soal");
            db.kosongkantabel("tb_jawaban");

            for (int i = 0; i < soal.length(); i++) {
                JSONObject c = soal.getJSONObject(i);
                db.isisoal(c.getString("id_soal"), c.getString("soal"), "0");

                db.isijawaban(c.getString("id_soal"), c.getString("jawab1").toLowerCase(), c.getString("value1"));
                db.isijawaban(c.getString("id_soal"), c.getString("jawab2").toLowerCase(), c.getString("value2"));
                db.isijawaban(c.getString("id_soal"), c.getString("jawab3").toLowerCase(), c.getString("value3"));
                db.isijawaban(c.getString("id_soal"), c.getString("jawab4").toLowerCase(), c.getString("value4"));

            }


            db.close();

            for (int i = 0; i < info.length(); i++) {
                JSONObject c = info.getJSONObject(i);
                idjenis = c.getString("jenis");
                level = c.getString("level");

            }


            progres = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            progres.getProgressDrawable().setColorFilter(Color.parseColor("#9b59b6"), PorterDuff.Mode.SRC_IN);
            progres.setProgress(0);
            progres.setMinimumWidth(widthview);
            frameprogres.addView(progres);
            initContrls();

        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), "Error open "+jenis+"\n"+ex.toString(), Toast.LENGTH_LONG).show();
        }
    }

    private void grading(String grade) {
        class sendGrade extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            SignUser ruc = new SignUser();
            String grade;
            String iduser;
            String idjenis;
            String level;
            public  sendGrade(String grade, String idjenis, String level, String iduser){
                this.grade = grade;
                this.idjenis = idjenis;
                this.level = level;
                this.iduser = iduser;
            }


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = new ProgressDialog(KerjakanLatihanActivity.this);
                loading.setMessage("Please wait...");
                loading.setIndeterminate(false);
                loading.setCancelable(true);
                loading.show();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                myJSON = s;
                setGrade(myJSON);
            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String,String>();

                String result = ruc.sendPostRequest("http://scoutcode.web.id/services/sendgrade.php?iduser="+iduser+"&jenis="+idjenis+"&level="+level+"&grade="+grade,data);

                return  result;
            }
        }

        sendGrade ru = new sendGrade(grade, idjenis, level, iduser);
        ru.execute();
    }

    public void setGrade(String myJSON){
        String jns;
        String lvl;
        String grd = myJSON;
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            JSONArray jo = jsonObj.getJSONArray("result");

            DBAdapter db = new DBAdapter(this);
            db.open();

            for (int i = 0; i < jo.length(); i++) {
                JSONObject c = jo.getJSONObject(i);
                jns = c.getString("jenis");
                lvl = c.getString("level");
                grd = c.getString("grade");
                db.isigrade(c.getString("id_grade"), c.getString("id_jenis"), c.getString("level"), c.getString("grade"), c.getString("tgl"));
            }

            db.close();

        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), "Error \n"+ex.toString(), Toast.LENGTH_LONG).show();
        }
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(framejawaban.getWidth(), LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout lv = new LinearLayout(getApplicationContext());
        lv.setOrientation(LinearLayout.VERTICAL);
        lv.setLayoutParams(lp);
        lv.setPadding(5, 5, 5, 5);

        TextView tv = new TextView(getApplicationContext());
        TextView tv2 = new TextView(getApplicationContext());
        tv.setText("Grade anda : \n");
        tv2.setText(grd+"\n");
        lv.setGravity(Gravity.CENTER);
        tv2.setGravity(Gravity.CENTER);
        tv.setTextSize(21);
        tv2.setTextSize(34);
        tv.setTextColor(getResources().getColor(R.color.grey));
        tv2.setTextColor(getResources().getColor(R.color.grey));
        lv.addView(tv);
        lv.addView(tv2);
        ImageView emoji = new ImageView(getApplicationContext());
        if(Integer.parseInt(grd)>=80){
            emoji.setImageResource(R.drawable.emoji1);
        }else if(Integer.parseInt(grd)>=50){
            emoji.setImageResource(R.drawable.emoji2);
        }else{
            emoji.setImageResource(R.drawable.emoji3);
        }
        lv.addView(emoji);
        framesoal.addView(lv);
    }

    public void insertimgrumput(String huruf, LinearLayout layout, int sts){
        
        switch (huruf) {
            case "a":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2); break;}
            case "b":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                    break;}
            case "c":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                break;}
            case "d":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                break;}
            case "e":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                break;}
            case "f":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                break;}
            case "g":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                break;}
            case "h":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                break;}
            case "i":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                break;}
            case "j":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.strip);layout.addView(iv4);
                break;}
            case "k":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                break;}
            case "l":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                break;}
            case "m":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                break;}
            case "n":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                break;}
            case "o":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                break;}
            case "p":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                break;}
            case "q":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.strip);layout.addView(iv4);
                break;}
            case "r":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                break;}
            case "s":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                break;}
            case "t":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                break;}
            case "u":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                break;}
            case "v":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.strip);layout.addView(iv4);
                break;}
            case "w":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                break;}
            case "x":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.strip);layout.addView(iv4);
                break;}
            case "y":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.strip);layout.addView(iv4);
                break;}
            case "z":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                break;}

            case "0":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.strip);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.strip);layout.addView(iv5);
                break;}
            case "1":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.strip);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.strip);layout.addView(iv5);
                break;}
            case "2":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.strip);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.strip);layout.addView(iv5);
                break;}
            case "3":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.strip);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.strip);layout.addView(iv5);
                break;}
            case "4":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.strip);layout.addView(iv5);
                break;}
            case "5":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.titik);layout.addView(iv5);
                break;}
            case "6":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.titik);layout.addView(iv5);
                break;}
            case "7":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.titik);layout.addView(iv5);
                break;}
            case "8":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.titik);layout.addView(iv5);
                break;}
            case "9":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.strip);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.titik);layout.addView(iv5);
                break;}
            case ".":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.titik);layout.addView(iv5);
                ImageView iv6= new ImageView(this);iv6.setImageResource(R.drawable.titik);layout.addView(iv6);
                break;}
            case ";":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.strip);layout.addView(iv5);
                ImageView iv6= new ImageView(this);iv6.setImageResource(R.drawable.titik);layout.addView(iv6);
                break;}
            case ",":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.titik);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.strip);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.titik);layout.addView(iv5);
                ImageView iv6= new ImageView(this);iv6.setImageResource(R.drawable.strip);layout.addView(iv6);
                break;}
            case "\"":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.strip);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.titik);layout.addView(iv5);
                break;}
            case "?":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.titik);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.titik);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.strip);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.titik);layout.addView(iv5);
                ImageView iv6= new ImageView(this);iv6.setImageResource(R.drawable.titik);layout.addView(iv6);
                break;}
            case ":":{
                ImageView iv1 = new ImageView(this);iv1.setImageResource(R.drawable.strip);layout.addView(iv1);
                ImageView iv2 = new ImageView(this);iv2.setImageResource(R.drawable.strip);layout.addView(iv2);
                ImageView iv3 = new ImageView(this);iv3.setImageResource(R.drawable.strip);layout.addView(iv3);
                ImageView iv4= new ImageView(this);iv4.setImageResource(R.drawable.titik);layout.addView(iv4);
                ImageView iv5= new ImageView(this);iv5.setImageResource(R.drawable.titik);layout.addView(iv5);
                ImageView iv6= new ImageView(this);iv6.setImageResource(R.drawable.titik);layout.addView(iv6);
                break;}

            default: {
                TextView iv1 = new TextView(this);
                iv1.setText("    ");
                layout.addView(iv1);
                break;
            }
        }

        if (sts != 1) {
            ImageView iv7 = new ImageView(this);
            iv7.setImageResource(R.drawable.spasi);
            layout.addView(iv7);
        }

        
    }

    public void insertsemaphore(String huruf, LinearLayout layout){
        ImageView iv = new ImageView(this);
        switch (huruf) {
            case "a":{iv.setImageResource(R.drawable.sem_a); break;}
            case "b":{iv.setImageResource(R.drawable.sem_b); break;}
            case "c":{iv.setImageResource(R.drawable.sem_c); break;}
            case "d":{iv.setImageResource(R.drawable.sem_d); break;}
            case "e":{iv.setImageResource(R.drawable.sem_e); break;}
            case "f":{iv.setImageResource(R.drawable.sem_f); break;}
            case "g":{iv.setImageResource(R.drawable.sem_g); break;}
            case "h":{iv.setImageResource(R.drawable.sem_h); break;}
            case "i":{iv.setImageResource(R.drawable.sem_i); break;}
            case "j":{iv.setImageResource(R.drawable.sem_j); break;}
            case "k":{iv.setImageResource(R.drawable.sem_k); break;}
            case "l":{iv.setImageResource(R.drawable.sem_l); break;}
            case "m":{iv.setImageResource(R.drawable.sem_m); break;}
            case "n":{iv.setImageResource(R.drawable.sem_n); break;}
            case "o":{iv.setImageResource(R.drawable.sem_o); break;}
            case "p":{iv.setImageResource(R.drawable.sem_p); break;}
            case "q":{iv.setImageResource(R.drawable.sem_q); break;}
            case "r":{iv.setImageResource(R.drawable.sem_r); break;}
            case "s":{iv.setImageResource(R.drawable.sem_s); break;}
            case "t":{iv.setImageResource(R.drawable.sem_t); break;}
            case "u":{iv.setImageResource(R.drawable.sem_u); break;}
            case "v":{iv.setImageResource(R.drawable.sem_v); break;}
            case "w":{iv.setImageResource(R.drawable.sem_w); break;}
            case "x":{iv.setImageResource(R.drawable.sem_x); break;}
            case "y":{iv.setImageResource(R.drawable.sem_y); break;}
            case "z":{iv.setImageResource(R.drawable.sem_z); break;}
            default :{iv.setImageResource(R.drawable.sem_awal); break;}
        }

        layout.addView(iv);
    }

    public void optionsemaphore(String huruf, ImageButton layout){
        switch (huruf) {
            case "a":{layout.setImageResource(R.drawable.sem_a); break;}
            case "b":{layout.setImageResource(R.drawable.sem_b); break;}
            case "c":{layout.setImageResource(R.drawable.sem_c); break;}
            case "d":{layout.setImageResource(R.drawable.sem_d); break;}
            case "e":{layout.setImageResource(R.drawable.sem_e); break;}
            case "f":{layout.setImageResource(R.drawable.sem_f); break;}
            case "g":{layout.setImageResource(R.drawable.sem_g); break;}
            case "h":{layout.setImageResource(R.drawable.sem_h); break;}
            case "i":{layout.setImageResource(R.drawable.sem_i); break;}
            case "j":{layout.setImageResource(R.drawable.sem_j); break;}
            case "k":{layout.setImageResource(R.drawable.sem_k); break;}
            case "l":{layout.setImageResource(R.drawable.sem_l); break;}
            case "m":{layout.setImageResource(R.drawable.sem_m); break;}
            case "n":{layout.setImageResource(R.drawable.sem_n); break;}
            case "o":{layout.setImageResource(R.drawable.sem_o); break;}
            case "p":{layout.setImageResource(R.drawable.sem_p); break;}
            case "q":{layout.setImageResource(R.drawable.sem_q); break;}
            case "r":{layout.setImageResource(R.drawable.sem_r); break;}
            case "s":{layout.setImageResource(R.drawable.sem_s); break;}
            case "t":{layout.setImageResource(R.drawable.sem_t); break;}
            case "u":{layout.setImageResource(R.drawable.sem_u); break;}
            case "v":{layout.setImageResource(R.drawable.sem_v); break;}
            case "w":{layout.setImageResource(R.drawable.sem_w); break;}
            case "x":{layout.setImageResource(R.drawable.sem_x); break;}
            case "y":{layout.setImageResource(R.drawable.sem_y); break;}
            case "z":{layout.setImageResource(R.drawable.sem_z); break;}
            default :{layout.setImageResource(R.drawable.sem_awal); break;}
        }
    }
    
    public void insertimgkotak(String huruf, LinearLayout layout){
        ImageView iv = new ImageView(this);
        switch (huruf)
        {
            case "a":{iv.setImageResource(R.drawable.kotaka); break;}
            case "b":{iv.setImageResource(R.drawable.kotakb); break;}
            case "c":{iv.setImageResource(R.drawable.kotakd); break;}
            case "d":{iv.setImageResource(R.drawable.kotake); break;}
            case "e":{iv.setImageResource(R.drawable.kotakg); break;}
            case "f":{iv.setImageResource(R.drawable.kotakh); break;}
            case "g":{iv.setImageResource(R.drawable.kotakj); break;}
            case "h":{iv.setImageResource(R.drawable.kotakk); break;}
            case "i":{iv.setImageResource(R.drawable.kotakm); break;}
            case "j":{iv.setImageResource(R.drawable.kotakn); break;}
            case "k":{iv.setImageResource(R.drawable.kotakp); break;}
            case "l":{iv.setImageResource(R.drawable.kotakq); break;}
            case "m":{iv.setImageResource(R.drawable.kotaks); break;}
            case "n":{iv.setImageResource(R.drawable.kotakt); break;}
            case "o":{iv.setImageResource(R.drawable.kotakv); break;}
            case "p":{iv.setImageResource(R.drawable.kotakw); break;}
            case "q":{iv.setImageResource(R.drawable.kotaky); break;}
            case "r":{iv.setImageResource(R.drawable.kotakz); break;}
            case "s":{iv.setImageResource(R.drawable.kotaks2); break;}
            case "t":{iv.setImageResource(R.drawable.kotakt2); break;}
            case "u":{iv.setImageResource(R.drawable.kotaku2); break;}
            case "v":{iv.setImageResource(R.drawable.kotakv2); break;}
            case "w":{iv.setImageResource(R.drawable.kotakw2); break;}
            case "x":{iv.setImageResource(R.drawable.kotakx2); break;}
            case "y":{iv.setImageResource(R.drawable.kotaky2); break;}
            case "z":{iv.setImageResource(R.drawable.kotakz2); break;}
        }

        layout.addView(iv);

    }

    public void optionkotak(String huruf, ImageButton layout){
        switch (huruf)
        {
            case "a":{layout.setImageResource(R.drawable.kotaka); break;}
            case "b":{layout.setImageResource(R.drawable.kotakb); break;}
            case "c":{layout.setImageResource(R.drawable.kotakd); break;}
            case "d":{layout.setImageResource(R.drawable.kotake); break;}
            case "e":{layout.setImageResource(R.drawable.kotakg); break;}
            case "f":{layout.setImageResource(R.drawable.kotakh); break;}
            case "g":{layout.setImageResource(R.drawable.kotakj); break;}
            case "h":{layout.setImageResource(R.drawable.kotakk); break;}
            case "i":{layout.setImageResource(R.drawable.kotakm); break;}
            case "j":{layout.setImageResource(R.drawable.kotakn); break;}
            case "k":{layout.setImageResource(R.drawable.kotakp); break;}
            case "l":{layout.setImageResource(R.drawable.kotakq); break;}
            case "m":{layout.setImageResource(R.drawable.kotaks); break;}
            case "n":{layout.setImageResource(R.drawable.kotakt); break;}
            case "o":{layout.setImageResource(R.drawable.kotakv); break;}
            case "p":{layout.setImageResource(R.drawable.kotakw); break;}
            case "q":{layout.setImageResource(R.drawable.kotaky); break;}
            case "r":{layout.setImageResource(R.drawable.kotakz); break;}
            case "s":{layout.setImageResource(R.drawable.kotaks2); break;}
            case "t":{layout.setImageResource(R.drawable.kotakt2); break;}
            case "u":{layout.setImageResource(R.drawable.kotaku2); break;}
            case "v":{layout.setImageResource(R.drawable.kotakv2); break;}
            case "w":{layout.setImageResource(R.drawable.kotakw2); break;}
            case "x":{layout.setImageResource(R.drawable.kotakx2); break;}
            case "y":{layout.setImageResource(R.drawable.kotaky2); break;}
            case "z":{layout.setImageResource(R.drawable.kotakz2); break;}
        }

    }

    public void insertimgkotakganda(String huruf, LinearLayout layout){
        ImageView iv = new ImageView(this);
        switch (huruf)
        {
            case "a":{iv.setImageResource(R.drawable.kotaka); break;}
            case "b":{iv.setImageResource(R.drawable.kotakb); break;}
            case "c":{iv.setImageResource(R.drawable.kotakc);  break;}
            case "d":{iv.setImageResource(R.drawable.kotakd); break;}
            case "e":{iv.setImageResource(R.drawable.kotake); break;}
            case "f":{iv.setImageResource(R.drawable.kotakf); break;}
            case "g":{iv.setImageResource(R.drawable.kotakg); break;}
            case "h":{iv.setImageResource(R.drawable.kotakh); break;}
            case "i":{iv.setImageResource(R.drawable.kotaki); break;}
            case "j":{iv.setImageResource(R.drawable.kotakj); break;}
            case "k":{iv.setImageResource(R.drawable.kotakk); break;}
            case "l":{iv.setImageResource(R.drawable.kotakl); break;}
            case "m":{iv.setImageResource(R.drawable.kotakm); break;}
            case "n":{iv.setImageResource(R.drawable.kotakn); break;}
            case "o":{iv.setImageResource(R.drawable.kotako); break;}
            case "p":{iv.setImageResource(R.drawable.kotakp); break;}
            case "q":{iv.setImageResource(R.drawable.kotakq); break;}
            case "r":{iv.setImageResource(R.drawable.kotakr); break;}
            case "s":{iv.setImageResource(R.drawable.kotaks); break;}
            case "t":{iv.setImageResource(R.drawable.kotakt); break;}
            case "u":{iv.setImageResource(R.drawable.kotaku); break;}
            case "v":{iv.setImageResource(R.drawable.kotakv); break;}
            case "w":{iv.setImageResource(R.drawable.kotakw); break;}
            case "x":{iv.setImageResource(R.drawable.kotakx); break;}
            case "y":{iv.setImageResource(R.drawable.kotaky); break;}
            case "z":{iv.setImageResource(R.drawable.kotakz); break;}
        }

        layout.addView(iv);

    }

    public void optionkotakganda(String huruf, ImageButton layout){
        switch (huruf)
        {
            case "a":{layout.setImageResource(R.drawable.kotaka); break;}
            case "b":{layout.setImageResource(R.drawable.kotakb); break;}
            case "c":{layout.setImageResource(R.drawable.kotakc);  break;}
            case "d":{layout.setImageResource(R.drawable.kotakd); break;}
            case "e":{layout.setImageResource(R.drawable.kotake); break;}
            case "f":{layout.setImageResource(R.drawable.kotakf); break;}
            case "g":{layout.setImageResource(R.drawable.kotakg); break;}
            case "h":{layout.setImageResource(R.drawable.kotakh); break;}
            case "i":{layout.setImageResource(R.drawable.kotaki); break;}
            case "j":{layout.setImageResource(R.drawable.kotakj); break;}
            case "k":{layout.setImageResource(R.drawable.kotakk); break;}
            case "l":{layout.setImageResource(R.drawable.kotakl); break;}
            case "m":{layout.setImageResource(R.drawable.kotakm); break;}
            case "n":{layout.setImageResource(R.drawable.kotakn); break;}
            case "o":{layout.setImageResource(R.drawable.kotako); break;}
            case "p":{layout.setImageResource(R.drawable.kotakp); break;}
            case "q":{layout.setImageResource(R.drawable.kotakq); break;}
            case "r":{layout.setImageResource(R.drawable.kotakr); break;}
            case "s":{layout.setImageResource(R.drawable.kotaks); break;}
            case "t":{layout.setImageResource(R.drawable.kotakt); break;}
            case "u":{layout.setImageResource(R.drawable.kotaku); break;}
            case "v":{layout.setImageResource(R.drawable.kotakv); break;}
            case "w":{layout.setImageResource(R.drawable.kotakw); break;}
            case "x":{layout.setImageResource(R.drawable.kotakx); break;}
            case "y":{layout.setImageResource(R.drawable.kotaky); break;}
            case "z":{layout.setImageResource(R.drawable.kotakz); break;}
        }

    }

    class TranslitSemaphore extends CountDownTimer {
        int i =0 ;
        String huruf;
        ImageView iv;

        public TranslitSemaphore(long millisInFuture, long countDownInterval, String huruf, ImageView iv) {
            super(millisInFuture, countDownInterval);
            this.huruf = huruf;
            this.iv = iv;
        }

        public void onFinish() {

            iv.setImageResource(R.drawable.sem_awal);
        }

        public void onTick(long millisUntilFinished) {

            switch (huruf.charAt(i)) {
                case 'a':
                    iv.setImageResource(R.drawable.sem_a);
                    break;

                case 'b':
                    iv.setImageResource(R.drawable.sem_b);
                    break;

                case 'c':
                    iv.setImageResource(R.drawable.sem_c);
                    break;

                case 'd':
                    iv.setImageResource(R.drawable.sem_d);
                    break;

                case 'e':
                    iv.setImageResource(R.drawable.sem_e);
                    break;

                case 'f':
                    iv.setImageResource(R.drawable.sem_f);
                    break;

                case 'g':
                    iv.setImageResource(R.drawable.sem_g);
                    break;

                case 'h':
                    iv.setImageResource(R.drawable.sem_h);
                    break;

                case 'i':
                    iv.setImageResource(R.drawable.sem_i);
                    break;

                case 'j':
                    iv.setImageResource(R.drawable.sem_j);
                    break;

                case 'k':
                    iv.setImageResource(R.drawable.sem_k);
                    break;

                case 'l':
                    iv.setImageResource(R.drawable.sem_l);
                    break;

                case 'm':
                    iv.setImageResource(R.drawable.sem_m);
                    break;

                case 'n':
                    iv.setImageResource(R.drawable.sem_n);
                    break;

                case 'o':
                    iv.setImageResource(R.drawable.sem_o);
                    break;

                case 'p':
                    iv.setImageResource(R.drawable.sem_p);
                    break;

                case 'q':
                    iv.setImageResource(R.drawable.sem_q);
                    break;

                case 'r':
                    iv.setImageResource(R.drawable.sem_r);
                    break;

                case 's':
                    iv.setImageResource(R.drawable.sem_s);
                    break;

                case 't':
                    iv.setImageResource(R.drawable.sem_t);
                    break;

                case 'u':
                    iv.setImageResource(R.drawable.sem_u);
                    break;

                case 'v':
                    iv.setImageResource(R.drawable.sem_v);
                    break;

                case 'w':
                    iv.setImageResource(R.drawable.sem_w);
                    break;

                case 'x':
                    iv.setImageResource(R.drawable.sem_x);
                    break;

                case 'y':
                    iv.setImageResource(R.drawable.sem_y);
                    break;

                case 'z':
                    iv.setImageResource(R.drawable.sem_z);
                    break;

                default:
                    iv.setImageResource(R.drawable.sem_awal);
                    break;
            }
            i++;
        }
    }



    public class CountDownLatihan extends CountDownTimer {

        public CountDownLatihan(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int progress = (int) ((20000-millisUntilFinished)/200);
            progres.setProgress(progress);
        }

        @Override
        public void onFinish() {
            progres.setProgress(100);
            DBAdapter dbq = new DBAdapter(getBaseContext());
            cdl.cancel();
            dbq.open();
            dbq.ubahsoalstatus(idsoal, "status", "1");
            if(level.equals("3")) {
                EditText et = (EditText) findViewById(R.id.txtinp);
                dbq.ubahsoalstatus(idsoal, "jawab", et.getText().toString());

            }else{
                dbq.ubahsoalstatus(idsoal, "jawab", "0");
            }
            dbq.close();
            initContrls();
        }

    }
    
    

}
