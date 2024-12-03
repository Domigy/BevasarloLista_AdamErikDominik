package com.example.bevasarlolista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private List<Item> productList;

    public ProductAdapter(Context context, List<Item> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.items_list_views, parent, false);
        }

        Item product = productList.get(position);

        TextView tvName = convertView.findViewById(R.id.tvProductName);
        TextView tvQuantity = convertView.findViewById(R.id.tvProductQuantity);

        tvName.setText(product.getName());
        tvQuantity.setText("Ár: " + product.getAr());

        return convertView;
    }
}

