package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class tela_login_farmaceutico extends AppCompatActivity {

    ImageButton imageButton_back_tela_login_farmaceutico;
    Button tela_login_farmaceutico_entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_farmaceutico);

        imageButton_back_tela_login_farmaceutico = findViewById(R.id.imageButton_back_tela_login_farmaceutico);
        imageButton_back_tela_login_farmaceutico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_farmaceutico.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tela_login_farmaceutico_entrar = findViewById(R.id.tela_login_farmaceutico_entrar);
        tela_login_farmaceutico_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_farmaceutico.this, tela_farmaceutico_loggedin.class);
                startActivity(intent);
            }
        });


    }
}