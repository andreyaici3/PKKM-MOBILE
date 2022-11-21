package com.andrey.tugas2_pkkm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etBahasaIndonesia = (EditText) findViewById(R.id.bIndonesia);
        EditText etBahasaSunda = (EditText) findViewById(R.id.bSunda);
        Button btnTerjemahkan = (Button) findViewById(R.id.btnTerjemahkan);

        DBBahasa db = new DBBahasa(this);

        btnTerjemahkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModelBahasa mb = db.findKata(etBahasaIndonesia.getText().toString());

                etBahasaSunda.setText(mb.getBahasa_sunda().toString());
            }
        });







    }
}