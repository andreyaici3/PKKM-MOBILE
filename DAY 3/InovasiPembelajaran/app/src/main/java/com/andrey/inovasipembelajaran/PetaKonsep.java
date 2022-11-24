package com.andrey.inovasipembelajaran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PetaKonsep extends AppCompatActivity {

    private Button kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peta_konsep);

        setTitle("Peta Konsep");

        kembali = (Button) findViewById(R.id.buttonKembali);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PetaKonsep.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}