    package com.andrey.inovasipembelajaran;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

    public class MainActivity extends AppCompatActivity {

    private Button tujuan;
    private Button pemantik;
    private Button petaKonsep;
    private Button materi;
    private Button tentang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

        tujuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pindahIntent(TujuanActivity.class);
            }
        });

        pemantik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { pindahIntent(PertanyaanPemantik.class); }
        });

        petaKonsep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { pindahIntent(PetaKonsep.class); }
        });

        materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { pindahIntent(MateriActivity.class); }
        });

        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { pindahIntent(TentangActivity.class); }
        });

    }

    void init(){
        tujuan = (Button) findViewById(R.id.tujuanPembelajaran);
        pemantik = (Button) findViewById(R.id.pertanyaanPemantik);
        petaKonsep = (Button) findViewById(R.id.petaKonsep);
        materi = (Button) findViewById(R.id.materi);
        tentang = (Button) findViewById(R.id.tentangAplikasi);
    }

    void pindahIntent(Class java){
        Intent i = new Intent(MainActivity.this, java);
        startActivity(i);
    }


}