package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tela_farmaceutico_loggedin_cadastrar_medicamento extends AppCompatActivity {

    ImageButton imageButton_tela_cadastrar_medicamento_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_farmaceutico_loggedin_cadastrar_medicamento);


        imageButton_tela_cadastrar_medicamento_back = findViewById(R.id.imageButton_tela_cadastrar_medicamento_back);
        imageButton_tela_cadastrar_medicamento_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_loggedin_cadastrar_medicamento.this, tela_farmaceutico_loggedin.class);
                startActivity(intent);
            }
        });
    }
}