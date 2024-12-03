package com.example.bevasarlolista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Item> productList = new ArrayList<>();
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etProductName = findViewById(R.id.etProductName);
        EditText etProductQuantity = findViewById(R.id.etProductQuantity);
        Button btnAdd = findViewById(R.id.btnAdd);
        ListView lvProducts = findViewById(R.id.lvProducts);

        adapter = new ProductAdapter(this, productList);
        lvProducts.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {
            String name = etProductName.getText().toString();
            String quantity = etProductQuantity.getText().toString();
            if (!name.isEmpty() && !quantity.isEmpty()) {
                productList.add(new Item(name, Integer.parseInt(quantity)));
                adapter.notifyDataSetChanged();
                etProductName.setText("");
                etProductQuantity.setText("");
            }
        });

        lvProducts.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("productName", productList.get(position).getName());
            intent.putExtra("productQuantity", productList.get(position).getAr());
            startActivity(intent);
        });

        lvProducts.setOnItemLongClickListener((parent, view, position, id) -> {
            productList.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
    }
}
