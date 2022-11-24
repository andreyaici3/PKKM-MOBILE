    package com.andrey.inovasipembelajaran;

import androidx.appcompat.app.AppCompatActivity;

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
                Intent i = new Intent(MainActivity.this, TujuanActivity.class);
                startActivity(i);
            }
        });

        pemantik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PertanyaanPemantik.class);
                startActivity(i);
            }
        });

        petaKonsep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PetaKonsep.class);
                startActivity(i);
            }
        });

        materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Materi.class);
                startActivity(i);
            }
        });

        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TentangActivity.class);
                startActivity(i);
            }
        });

    }

    void init(){
        tujuan = (Button) findViewById(R.id.tujuanPembelajaran);
        pemantik = (Button) findViewById(R.id.pertanyaanPemantik);
        petaKonsep = (Button) findViewById(R.id.petaKonsep);
        materi = (Button) findViewById(R.id.materi);
        tentang = (Button) findViewById(R.id.tentangAplikasi);
    }


}