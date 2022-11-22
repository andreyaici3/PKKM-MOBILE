package com.andrey.belajarkoneksi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity {
    TextView tvMessage;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        ambilData();
    }

    public void  ambilData(){
        queue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://apps.priludestudio.com/pelatihan/";

        StringRequest jsonObjReq = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject priludeObj = jsonObject.getJSONObject("prilude");
                    String message = priludeObj.getString("message");
                    tvMessage.setText(message);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }
        ){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-wwwform-urlencoded");
                return params;
            }
        };
        final int DEFAULT_MAX_RETRIES = 1;
        final float DEFAULT_BACKOFF_MULT = 1f;
        jsonObjReq.setRetryPolicy( new DefaultRetryPolicy( (int) TimeUnit.SECONDS.toMillis(20), DEFAULT_MAX_RETRIES, DEFAULT_BACKOFF_MULT));
        queue.add(jsonObjReq);

    }
}