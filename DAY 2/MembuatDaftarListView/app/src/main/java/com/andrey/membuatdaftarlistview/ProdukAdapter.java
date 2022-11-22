package com.andrey.membuatdaftarlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProdukAdapter extends BaseAdapter {
    Context context;
    String productList[];
    int imgProduk[];
    LayoutInflater inflater;

    public ProdukAdapter(Context applicationContext, String[] productList, int[] flags){
        this.context = applicationContext;
        this.productList = productList;
        this.imgProduk = flags;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return productList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.list_produk, null);
        TextView tvNamaProduk = (TextView) view.findViewById(R.id.tvNamaProduk);
        ImageView ivNamaProduk = (ImageView) view.findViewById(R.id.ivProduk);
        tvNamaProduk.setText(productList[i]);
        ivNamaProduk.setImageResource(imgProduk[i]);
        return view;
    }
}
