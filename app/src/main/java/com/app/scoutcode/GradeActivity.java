package com.app.scoutcode;


import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class GradeActivity extends AppCompatActivity{
    TextView txtdes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtdes = (TextView)findViewById(R.id.txtdes);
        initControls();
    }

    public void initControls() {
        DBAdapter db = new DBAdapter(this);
        TableLayout tv=(TableLayout) findViewById(R.id.tbgrade);
        int no=1;



        db.open();

        Cursor s = db.selectorder("tb_grade", "*", "id_grade desc");
        if (s.moveToFirst()) {
            TableRow tr = new TableRow(this);
            try {

                tr.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tr.setPadding(5 ,5, 5, 5);
                tr.setBackgroundColor(Color.parseColor("#9b59b6"));

                TextView b3 = new TextView(this);
                b3.setText("NO");
                b3.setTextColor(Color.WHITE);
                b3.setTextSize(15);
                tr.addView(b3);

                TextView b4 = new TextView(this);
                b4.setPadding(10, 0, 0, 0);
                b4.setTextSize(15);
                b4.setText("Latihan");
                b4.setTextColor(Color.WHITE);
                tr.addView(b4);


                TextView b6 = new TextView(this);
                b6.setPadding(10, 0, 0, 0);
                b6.setText("Grade");
                b6.setTextColor(Color.WHITE);
                b6.setTextSize(15);
                tr.addView(b6);
                tv.addView(tr);

            }catch (Exception ex){
                Toast.makeText(getApplicationContext(), "Error !\n" + ex.toString(), Toast.LENGTH_LONG).show();
            }
            do {

                try {

                String jenis="";
                switch (s.getString(1)){
                    case "1" : jenis = "Semaphore"; break;
                    case "2" : jenis = "Morse"; break;
                    case "3" : jenis = "Sandi Rumput"; break;
                    case "4" : jenis = "Sandi Kotak"; break;
                    case "5" : jenis = "Sandi Kotak Ganda"; break;
                    case "6" : jenis = "Sandi Angka"; break;
                    case "7" : jenis = "Sandi AN"; break;
                    case "8" : jenis = "Sandi AZ"; break;
                    case "9" : jenis = "Sandi Kardinal"; break;
                }
                    TableRow tr2 = new TableRow(this);
                    TextView b = new TextView(this);
                    String str = String.valueOf(no);
                    b.setText(str);
                    b.setTextSize(15);
                    tr2.addView(b);

                    TextView b1 = new TextView(this);
                    b1.setPadding(10, 0, 0, 0);
                    b1.setTextSize(15);
                    b1.setText(Html.fromHtml("<b>" + jenis + " " + s.getString(2) + "</b><br><font style='size:9px;color:#dddddd'>" + s.getString(4) + "</font>"));
                    tr2.addView(b1);

                    TextView B7 = new TextView(this);
                    B7.setPadding(10, 0, 0, 0);
                    B7.setText(s.getString(3));
                    B7.setTextSize(15);
                    tr2.addView(B7);
                    tv.addView(tr2);
                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(), "Error !\n" + ex.toString(), Toast.LENGTH_LONG).show();
                }
                        
                no++;
            } while (s.moveToNext());


        }

        TextView txtgrade = (TextView) findViewById(R.id.txtgrade);
        txtgrade.setText(getGrade());
        db.close();

        if(Integer.parseInt(getGrade())==0){
            txtdes.setText("Anda belum memiliki point grade. Silahkan coba latihan - latihan untuk mendapatkan point grade dan tingkatkan terus point grade anda untuk melatih keterampilan anda dalam bidang sandi - sandi pramuka.");
        }else if(Integer.parseInt(getGrade())<300){
            txtdes.setText("Ayo tingkatkan terus point grade anda untuk melatih keterampilan anda dalam bidang sandi - sandi pramuka. Tetap semangat.");
        }else {
            txtdes.setText("Luar Biasa !\nAyo tingkatkan terus point grade anda untuk melatih keterampilan anda dalam bidang sandi - sandi pramuka. Tetap semangat.");
        }
    }

    public String getGrade(){
        DBAdapter db = new DBAdapter(this);
        db.open();
        int hasil = 0;
        int[][] jnilai = new int[11][6];

        for (int j = 1; j < 10; j++) {
            for (int i = 1; i <= 5; i++) {
                jnilai[j][i] = 0;
            }
        }
        Cursor s = db.selectorder("tb_grade", "*", "id_grade desc");
        if (s.moveToFirst()) {
            do {
                int idjenis = 0;
                if(!s.getString(1).equals("")) idjenis = Integer.valueOf(s.getString(1));
                int idlevel = 0;
                if(!s.getString(2).equals("")) idlevel = Integer.valueOf(s.getString(2));
                int idgrade = 0;
                if(!s.getString(3).equals("")) idgrade = Integer.valueOf(s.getString(3));
                if(jnilai[idjenis][idlevel] < idgrade){
                    jnilai[idjenis][idlevel] = idgrade;
                }
            } while (s.moveToNext());
        }

        try {
            for (int j=1; j<10; j++){
                for (int i=1; i<=5;i++){
                    if(jnilai[j][i]>0){
                        hasil = hasil + (jnilai[j][i]/10);
                    }
                }
            }
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), "Error !\n" + ex.toString(), Toast.LENGTH_LONG).show();
        }
        db.close();

        String grade = String.valueOf(hasil);
        return grade;
    }
}
