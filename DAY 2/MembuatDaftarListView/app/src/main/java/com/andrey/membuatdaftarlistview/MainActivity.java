package com.andrey.membuatdaftarlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lvProduk;
    String daftarProduk[] = {"Indomie", "Mie Sedap", "Kecap Bango", "Kacang Garuda", "Masker KF", "Pasta Gigi Pepsodent"};
    int gambarProduk[] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,  R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProduk = (ListView) findViewById(R.id.lvProduk);
        ProdukAdapter customAdapter = new ProdukAdapter(getApplicationContext(), daftarProduk, gambarProduk);
        lvProduk.setAdapter(customAdapter);
    }
}