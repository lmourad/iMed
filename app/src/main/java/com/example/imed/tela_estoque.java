package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tela_estoque extends AppCompatActivity {

    ImageButton imageButton_go_back_estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_estoque);

        imageButton_go_back_estoque = findViewById(R.id.imageButton_go_back_estoque);
        imageButton_go_back_estoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_estoque.this, tela_farmaceutico_loggedin.class);
                startActivity(intent);
            }
        });
    }
}