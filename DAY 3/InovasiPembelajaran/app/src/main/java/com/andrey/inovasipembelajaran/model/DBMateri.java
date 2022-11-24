package com.andrey.inovasipembelajaran.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBMateri extends SQLiteAssetHelper
{
    private static final String DATABASE_NAME="inovasi_pembelajaran.db";
    private static final int DATABASE_VERSION=1;
    private static final String KEY_ID="id";
    private static final String KEY_ISI ="isi";
    private String nama_tabel;
    public DBMateri(Context context, String nama_tabel){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.nama_tabel = nama_tabel;
    }

    public boolean isNull()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT count(*) FROM "+nama_tabel+"";
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        db.close();
        return icount <= 0;
    }

    @SuppressLint("Range")
    public Materi findMateri()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(nama_tabel,new
                String[]{KEY_ID, KEY_ISI},null,null,null,null,null);
        Materi u=new Materi();
        if (cursor!=null && cursor.moveToFirst())
        {
            cursor.moveToFirst();
            u.setId(cursor.getInt(cursor.getColumnIndex("id")));
            u.setIsi(cursor.getString(cursor.getColumnIndex("isi")));
            ;
        }else
        {
            u.setId(0);
            u.setIsi("");
        }
        db.close();
        return u;
    }
}
