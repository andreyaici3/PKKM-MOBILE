package com.andrey.inovasipembelajaran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.andrey.inovasipembelajaran.model.DBMateri;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PertanyaanPemantik extends AppCompatActivity {

    final String url = "https://apps.priludestudio.com/pelatihan/pemantik.php";
    RequestQueue queue;
    private TextView isi, judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan_pemantik);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        judul = (TextView) findViewById(R.id.judul);
        isi = (TextView) findViewById(R.id.isi);

        ambilData();


        setTitle("Pertanyaan Pemantik");



    }

    public void ambilData()
    {
        queue = Volley.newRequestQueue(PertanyaanPemantik.this);
        StringRequest jsonObjReq = new
                StringRequest(Request.Method.GET,
                        url,new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject mater = jsonObject.getJSONObject("materi");
                            Log.d("test", mater.getString("judul"));
                            judul.setText(mater.getString("judul"));
                            isi.setText(mater.getString("isi"));
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String,
                                String>();
                        return params;
                    }
                    @Override
                    public Map<String, String> getHeaders() throws
                            AuthFailureError {
                        Map<String, String> params = new HashMap<String,
                                String>();
                        params.put("Content-Type", "application/x-wwwform-urlencoded");
                        return params;
                    }
                };
        final int DEFAULT_MAX_RETRIES = 1;
        final float DEFAULT_BACKOFF_MULT = 1f;
        jsonObjReq.setRetryPolicy(
                new DefaultRetryPolicy(
                        (int) TimeUnit.SECONDS.toMillis(20),
                        DEFAULT_MAX_RETRIES,
                        DEFAULT_BACKOFF_MULT));
        queue.add(jsonObjReq);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}