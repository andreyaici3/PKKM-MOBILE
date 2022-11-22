package com.andrey.tugas2_pkkm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProdukAdapter extends BaseAdapter {
    Context context;
    ArrayList<ModelProduk> modelProduks;
    LayoutInflater inflater;

    public ProdukAdapter(Context applicationContext, ArrayList<ModelProduk> modelProduks){
        this.context = applicationContext;
        this.modelProduks = modelProduks;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return modelProduks.size();
    }

    @Override
    public Object getItem(int i) {
        return  modelProduks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.list_produk, null);
        TextView tvNamaProduk = (TextView) view.findViewById(R.id.tvNamaProduk);
        TextView tvDeskripsiProduk = (TextView) view.findViewById(R.id.tvDeskripsiProduk);
        tvNamaProduk.setText(modelProduks.get(i).getNama());
        tvDeskripsiProduk.setText(modelProduks.get(i).getDeskripsi());
        return view;
    }
}
