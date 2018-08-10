package com.app.scoutcode;

import android.app.Activity;
import android.database.Cursor;
import android.widget.Toast;

public class UserData extends Activity {
    String iduser, nama, email, foto;

    public UserData(){
        DBAdapter db = new DBAdapter(this);
        db.open();
        Cursor b = db.ambildata("iduser");
        if (b.moveToFirst()) {
            do {
                this.iduser = b.getString(1);
            } while (b.moveToNext());

        }else {
            this.iduser = "";
        }

        Cursor c = db.ambildata("namauser");
        if (c.moveToFirst()) {
            do {
                this.nama = c.getString(1);
            } while (c.moveToNext());

        }else {
            this.nama = "";
        }

        Cursor d = db.ambildata("emailuser");
        if (d.moveToFirst()) {
            do {
                this.email = d.getString(1);
            } while (d.moveToNext());

        }else {
            this.email = "";
        }

        Cursor e = db.ambildata("fotouser");
        String foto;
        if (e.moveToFirst()) {
            do {
                this.foto = e.getString(1);
            } while (e.moveToNext());

        }else{
            this.foto = "";
        }

        db.close();
    }

    public String getIduser() {
        return iduser;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getFoto() {
        return foto;
    }
}
