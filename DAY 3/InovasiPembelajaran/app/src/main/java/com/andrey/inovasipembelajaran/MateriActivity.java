package com.andrey.inovasipembelajaran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.andrey.inovasipembelajaran.model.DBMateri;
import com.andrey.inovasipembelajaran.model.Materi;

public class MateriActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Materi");


        DBMateri dbMateri = new DBMateri(MateriActivity.this, "materi");
        if (dbMateri.isNull())
        {
            Log.d("test", "kosong");
        }else
        {
            Log.d("test","isi");
        }

        TextView isi = (TextView) findViewById(R.id.isi);
        TextView judul = (TextView) findViewById(R.id.judul);
        judul.setText("Materi Dari SQLite");
        isi.setText(dbMateri.findMateri().getIsi());

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}