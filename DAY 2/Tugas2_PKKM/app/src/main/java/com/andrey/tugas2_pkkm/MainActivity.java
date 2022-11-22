package com.andrey.tugas2_pkkm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;
    String url = "https://apps.priludestudio.com/pelatihan/daftar_produk.php";
    ListView lvProduk;
    ArrayList<ModelProduk> modelProduks;
    TextView status, message;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modelProduks = new ArrayList<>();
        message = (TextView) findViewById(R.id.pesan);
        status = (TextView) findViewById(R.id.statusAmbilData);

        lvProduk = (ListView) findViewById(R.id.lvProduk);

        GetData();



    }

    void GetData(){
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );

        queue.add(stringRequest);
    }

    void parseJson(String response){
        try {
            JSONObject dataJson = new JSONObject(response);
            JSONObject produkJson = dataJson.getJSONObject("produk");
            status.setText(produkJson.getString("status"));
            message.setText(produkJson.getString("message"));
            if (produkJson.getString("status").equals("success")){
                JSONArray ja = produkJson.getJSONArray("data");
                for (int i=0; i<ja.length(); i++){
                    ModelProduk modelProduk = new ModelProduk();
                    JSONObject h = ja.getJSONObject(i);
                    modelProduk.setImage(h.getString("image"));
                    modelProduk.setNama(h.getString("nama"));
                    modelProduk.setDeskripsi(h.getString("deskripsi"));
                    modelProduks.add(modelProduk);
                }
                setAdapter(modelProduks);
            } else {
                Log.d("Message", "data kosong");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void setAdapter(ArrayList<ModelProduk> modelProduks){
        ProdukAdapter customAdapter = new ProdukAdapter(getApplicationContext(), modelProduks);
        lvProduk.setAdapter(customAdapter);
    }
}