package com.andrey.tugas1_pkkm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBUser extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "my_first_db.db";
    private static final int DATABASE_VERSION = 1;
    private static final String NAMA_TABEL = "pengguna";
    private static final String KEY_ID="id_pengguna";
    private static final String KEY_USERNAME="username";

    public DBUser(Context context){
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

    public void selct(){
        String countQuery = "SELECT  * FROM " + NAMA_TABEL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int rowCount = cursor.getCount();
        db.close();
        cursor.close();

        Log.d("hmzz", String.valueOf(rowCount));

    }

    public User findUser()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(NAMA_TABEL,new  String[]{KEY_ID,KEY_USERNAME},null,null,null,null,null);
        User u = new User();
        if (cursor!=null && cursor.moveToFirst())
        {
            cursor.moveToFirst();
            u.setUserId(cursor.getInt(cursor.getColumnIndex("id_pengguna")));
            u.setUsername(cursor.getString(cursor.getColumnIndex("username")));
        }else
        {
            u.setUserId(0);
            u.setUsername("");
        }
        db.close();


        return u;
    }

    public void delete()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(NAMA_TABEL, null, null);
        db.close();
    }

    public void update(User user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_ID,user.getUserId());
        values.put(KEY_USERNAME,user.getUsername());
        db.update(NAMA_TABEL, values, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getUserId())
                });
        db.close();
    }
}
