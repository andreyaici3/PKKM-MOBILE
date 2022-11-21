package com.andrey.tugas2_pkkm;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Debug;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBBahasa extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "kamus_sunda_indo.db";
    private static final int DATABASE_VERSION = 1;
    private static final String NAMA_TABEL = "indo_to_sunda";
    private static final String KEY_ID="id";
    private static final String KEY_INDONESIA="bahasa_indonesia";
    private static final String KEY_SUNDA="bahasa_sunda";

    public DBBahasa(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public boolean isNull(){
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT count(*) FROM "+ NAMA_TABEL +"";
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        db.close();
        return icount <= 0;
    }

    @SuppressLint("Range")
    public ModelBahasa findKata(String bahasaIndonesia){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(NAMA_TABEL,new  String[]{KEY_ID,KEY_INDONESIA, KEY_SUNDA},"bahasa_indonesia = ?",new String[]{bahasaIndonesia},null,null,null);
        ModelBahasa bahasa = new ModelBahasa();


        if (cursor!=null && cursor.moveToFirst())
        {
            cursor.moveToFirst();
            bahasa.setId(cursor.getInt(cursor.getColumnIndex("id")));
            bahasa.setBahasa_indonesia(cursor.getString(cursor.getColumnIndex("bahasa_indonesia")));
            bahasa.setBahasa_sunda(cursor.getString(cursor.getColumnIndex("bahasa_sunda")));

        }else
        {
            bahasa.setId(0);
            bahasa.setBahasa_sunda("");
            bahasa.setBahasa_indonesia("");
        }
        db.close();

        return bahasa;

    }










}
