package com.example.imed.Telas.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.R;

public class tela_farmaceutico_apresentacao_receita extends AppCompatActivity {

    ImageButton imageButton_go_back_checar_receita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_apresentacao_receita);


        imageButton_go_back_checar_receita = findViewById(R.id.imageButton_go_back_checar_receita);


        imageButton_go_back_checar_receita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_apresentacao_receita.this, tela_farmaceutico_checar_receita.class);
                startActivity(intent);
            }
        });
    }
}