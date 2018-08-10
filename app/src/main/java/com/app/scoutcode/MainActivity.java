package com.app.scoutcode;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout btnmateri, btntranslator, btnlatihan, btntentang;
    int sign=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),
                        MasukActivity.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = LayoutInflater.from(this).inflate(R.layout.nav_header_main, null);
        navigationView.addHeaderView(header);
        txtnama = (TextView) header.findViewById(R.id.txtnama);
        txtemail = (TextView) header.findViewById(R.id.txtemail);
        icuser =(ImageView)header.findViewById(R.id.icUser);
        */

        namauser();
        if(sign==1){
            //fab.setVisibility(View.GONE);
        }else {
            /*navigationView = (NavigationView) findViewById(R.id.nav_view);
            Menu nav_Menu = navigationView.getMenu();
            nav_Menu.findItem(R.id.nav_logout).setVisible(false);*/
        }

        btnmateri = (LinearLayout) findViewById(R.id.menumateri);
        btntentang = (LinearLayout) findViewById(R.id.menutentang);
        btntranslator = (LinearLayout) findViewById(R.id.menutranslator);
        btnlatihan = (LinearLayout) findViewById(R.id.menulatihan);
        btnmateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), MateriActivity.class);
                startActivity(i);
            }
        });
        btntranslator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), TranslatorActivity.class);
                startActivity(i);
            }
        });
        btnlatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sign == 1) {
                    Intent i = new Intent(getBaseContext(), LatihanActivity.class);
                    startActivity(i);
                }else{
                    Intent i = new Intent(getBaseContext(), MasukActivity.class);
                    startActivity(i);
                }
            }
        });
        btntentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), TentangActivity.class);
                startActivity(i);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem ml = menu.findItem(R.id.action_login);
        MenuItem mi = menu.findItem(R.id.action_settings);
        MenuItem mp = menu.findItem(R.id.action_profil);
        if(sign!=0){
            mp.setVisible(true);
            ml.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            try {
                Intent set = new Intent(getBaseContext(),
                        GradeActivity.class);
                startActivity(set);

            }catch (Exception ex){
                Toast.makeText(getApplicationContext(), "Error !\n" + ex.toString(), Toast.LENGTH_LONG).show();
            }
            return true;
        }else if (id == R.id.action_profil) {
            try {
                Intent set = new Intent(getBaseContext(),
                        ProfilActivity.class);
                startActivity(set);

            }catch (Exception ex){
                Toast.makeText(getApplicationContext(), "Error !\n" + ex.toString(), Toast.LENGTH_LONG).show();
            }
            return true;
        }else if(id == R.id.action_login){
            Intent i = new Intent(getBaseContext(),
                    MasukActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    /*
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_materi) {
            Intent i = new Intent(getBaseContext(),
                    MateriActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_translator) {
            Intent i = new Intent(getBaseContext(),
                    TranslatorActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_latihan) {
            if(sign==1) {
                Intent i = new Intent(getBaseContext(),
                        LatihanActivity.class);
                startActivity(i);
            }else{
                Intent i = new Intent(getBaseContext(),
                        MasukActivity.class);
                startActivity(i);
            }

        } else if (id == R.id.nav_tentang) {
            Intent i = new Intent(getBaseContext(),
                    TentangActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_logout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Apakah anda yakin ingin logout?")
                    .setCancelable(false)
                    .setPositiveButton("Ya",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    hapus();
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void clickMenu(View v) {
        switch (v.getId()) {
            case R.id.txtnama:
                Intent i = new Intent(getBaseContext(),
                        MasukActivity.class);
                startActivity(i);
                break;

        }
    }
    */

    private void  namauser() {
        DBAdapter db = new DBAdapter(this);
        db.open();
        Cursor c = db.ambildata("namauser");
        if (c.moveToFirst()) {
            sign =1;
            do {
                //txtnama.setText(c.getString(1));
            } while (c.moveToNext());

        }else {
            //txtnama.setText("Login");
        }
        /*
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
                new SetImageUser(icuser).execute(foto);
            }catch (Exception exx) {
                Toast.makeText(getApplicationContext(), exx.toString(),Toast.LENGTH_LONG).show();
            }
        }
        */
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
