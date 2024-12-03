package com.example.bevasarlolista;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView tvName = findViewById(R.id.tvDetailProductName);
        TextView tvQuantity = findViewById(R.id.tvDetailProductQuantity);
        Button btnBack = findViewById(R.id.btnBack);

        String name = getIntent().getStringExtra("productName");
        int quantity = getIntent().getIntExtra("productQuantity", 0);

        tvName.setText(name);
        tvQuantity.setText("Quantity: " + quantity);

        btnBack.setOnClickListener(v -> finish());

    }
};