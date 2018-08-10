package com.app.scoutcode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
    private final static String DATABASE_NAME = "dbscoutcode";
    private final static int DATABASE_VERSION = 1;
    private final static String USER_TABLE = "tb_modul";
    private final static String KEY_ID = "id";
    private final static String KEY_JUDUL = "judul";
    private final static String KEY_ISI = "isi";
    static final String SQL_CREATE_TABLE = "create table "+USER_TABLE+" ("+
            KEY_ID+" integer primary key autoincrement, "+
            KEY_JUDUL+" text not null, "+
            KEY_ISI+" text not null )";

    static final String CREATE_TB_SOAL = "create table if not exists tb_soal (" +
            "  id_soal integer primary key," +
            "  soal text not null," +
            "  status text not null," +
            "  jawab text not null)";

    static final String CREATE_TB_JAWABAN = "create table if not exists tb_jawaban (" +
            "  id_jawaban integer primary key autoincrement," +
            "  id_soal integer," +
            "  jawaban text not null," +
            "  value text not null)";

    static final String CREATE_TB_GRADE = "create table if not exists tb_grade (" +
            "  id_grade text not null," +
            "  jenis text not null," +
            "  level text not null," +
            "  grade text not null," +
            "  tgl text not null)";

    static final String TAG = "DBAdapter";

    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null,
                    DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(SQL_CREATE_TABLE);
                db.execSQL(CREATE_TB_SOAL);
                db.execSQL(CREATE_TB_JAWABAN);
                db.execSQL(CREATE_TB_GRADE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            Log.w(TAG, "Memutakhirkan database dari versi " +
                    oldVersion
                    + " to " + newVersion
                    + ", proses ini akan menghapus semua data");
            db.execSQL("DROP TABLE IF EXISTS tb_modul");
            onCreate(db);
        }
    }
    // ---Membuka database---
    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }
    // ---Menutup database---
    public void close() {
        DBHelper.close();
    }
    // ---memasukan data---
    public long isidata(String judul, String isi) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_JUDUL, judul);
        initialValues.put(KEY_ISI, isi);
        return db.insert(USER_TABLE, null, initialValues);
    }

    public long isisoal(String id_soal, String soal, String status) {
        ContentValues initialValues = new ContentValues();
        initialValues.put("id_soal", id_soal);
        initialValues.put("soal", soal);
        initialValues.put("status", status);
        initialValues.put("jawab", "");
        return db.insert("tb_soal", null, initialValues);
    }

    public long isijawaban(String id_soal, String jawaban, String value) {
        ContentValues initialValues = new ContentValues();
        initialValues.put("id_soal", id_soal);
        initialValues.put("jawaban", jawaban);
        initialValues.put("value", value);
        return db.insert("tb_jawaban", null, initialValues);
    }

    public long isigrade(String id_grade, String jenis, String level, String grade, String tgl) {
        ContentValues initialValues = new ContentValues();
        initialValues.put("id_grade", id_grade);
        initialValues.put("jenis", jenis);
        initialValues.put("level", level);
        initialValues.put("grade", grade);
        initialValues.put("tgl", tgl);
        return db.insert("tb_grade", null, initialValues);
    }

    public boolean hapusdata(String judul) {

        return db.delete(USER_TABLE, "judul='" + judul+"'", null) > 0;
    }

    public void buattabel() {
        try{
            db.execSQL("drop table tb_soal");
            db.execSQL("drop table tb_jawaban");
        }catch (Exception ex){

        }

        db.execSQL(CREATE_TB_SOAL);
        db.execSQL(CREATE_TB_JAWABAN);
    }

    public void buattabelgrade() {
        db.execSQL(CREATE_TB_GRADE);
    }

    public void hapustabelgrade() {
        try{
            db.execSQL("drop table tb_grade");

        }catch (Exception ex){

        }

    }

    public void kosongkantabel(String tabel) {
        db.execSQL("delete from "+tabel);
    }

    public Cursor selecttable(String tabel, String field) {
        return db.query(tabel, new String[] { field }, null, null, null, null, null);
    }

    public Cursor selectorder(String tabel, String field, String order) {
        return db.query(tabel, new String[] { field }, null, null, null, null, order,null);
    }
    // ---Mengambil data mahasiswa tertentu---
    public Cursor ambildata(String judul) throws SQLException {
        Cursor mCursor = db.query(true, USER_TABLE, new
                        String[] { KEY_JUDUL,
                        KEY_ISI }, KEY_JUDUL + "='" + judul+"'",
                null, null, null,
                null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor selectdata(String tabel, String fieldambil, String field, String value) throws SQLException {
        Cursor mCursor = db.query(true, tabel, new
                        String[] {
                        fieldambil }, field + "='" + value+"'",
                null, null, null,
                null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor selectsoal(String tabel, String fieldambil, String field, String value) throws SQLException {
        Cursor mCursor = db.query(true, tabel, new
                        String[] { field,
                        fieldambil }, field + "!='" + value+"'",
                null, null, null,
                null, "1");
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }




    public boolean ubahsoalstatus(String id_soal,String field, String value) {
        ContentValues args = new ContentValues();
        args.put(field, value);
        return db.update("tb_soal", args, "id_soal" + "=" +
                id_soal, null) > 0;
    }



}
