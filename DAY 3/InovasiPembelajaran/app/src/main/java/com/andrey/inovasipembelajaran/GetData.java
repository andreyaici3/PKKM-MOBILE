package com.andrey.inovasipembelajaran;

import android.content.Context;
import android.util.Log;

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

public class GetData {
    public RequestQueue queue;
    private String URL;
    public String jsonString;
    private Context context;

    public GetData(Context context, String url){
        this.URL = url;
        this.context = context;

    }






}
