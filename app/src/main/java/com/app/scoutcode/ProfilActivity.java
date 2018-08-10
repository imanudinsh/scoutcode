package com.app.scoutcode;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class ProfilActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    TextView txtnama,txtemail;
    ImageView  icuser;
    int sign=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = LayoutInflater.from(this).inflate(R.layout.nav_header_main, null);
        navigationView.addHeaderView(header);
        txtnama = (TextView) header.findViewById(R.id.txtnama);
        txtemail = (TextView) header.findViewById(R.id.txtemail);
        icuser =(ImageView)header.findViewById(R.id.icuser);
        setuser();

        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.nav_grade).setTitle(getGrade());
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_grade) {
            Intent set = new Intent(getBaseContext(),
                    GradeActivity.class);
            startActivity(set);
        } else if (id == R.id.nav_logout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Apakah anda yakin ingin logout?")
                    .setCancelable(false)
                    .setPositiveButton("Ya",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    logout();
                                    Intent i = new Intent(getBaseContext(),
                                            MainActivity.class);
                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(i);
                                }
                            })
                    .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int id) {
                            dialog.cancel();

                        }
                    }).show();

        }

        return true;
    }

    public void logout(){
        DBAdapter db = new DBAdapter(this);
        db.open();
        db.hapustabelgrade();
        db.buattabelgrade();
        db.hapusdata("iduser");
        db.hapusdata("namauser");
        db.hapusdata("emailuser");
        db.hapusdata("fotouser");
        db.close();
    }
    private void  setuser() {
        DBAdapter db = new DBAdapter(this);
        db.open();
        Cursor c = db.ambildata("namauser");
        if (c.moveToFirst()) {
            sign =1;
            do {
                txtnama.setText(c.getString(1));
            } while (c.moveToNext());

        }else {
            txtnama.setText("Login");
        }

        Cursor d = db.ambildata("emailuser");
        if (d.moveToFirst()) {
            do {
                txtemail.setText(d.getString(1));
            } while (d.moveToNext());

        }else {
            txtemail.setText("");
        }

        Cursor e = db.ambildata("fotouser");
        String foto;
        if (e.moveToFirst()) {
            do {
                foto = e.getString(1);
            } while (e.moveToNext());

            try {
                Picasso.with(this).load(foto).placeholder(R.drawable.ic_user).into(icuser);
            }catch (Exception exx) {

            }
        }

        db.close();

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
