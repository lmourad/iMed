package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tela_farmaceutico_loggedin_verifica_receita extends AppCompatActivity {

    ImageButton imageButton_tela_verifica_receita_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_farmaceutico_loggedin_verifica_receita);

        imageButton_tela_verifica_receita_back = findViewById(R.id.imageButton_tela_verifica_receita_back);
        imageButton_tela_verifica_receita_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_loggedin_verifica_receita.this, tela_farmaceutico_loggedin.class);
                startActivity(intent);
            }
        });

    }
}