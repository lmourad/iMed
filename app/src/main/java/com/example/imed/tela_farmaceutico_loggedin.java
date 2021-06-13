package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tela_farmaceutico_loggedin extends AppCompatActivity {


    ImageButton ImageButton_tela_login_screen_medico_back, imageButtont_tela_farmaceutico_cadastrar_medicamento_entrar, imageButton_tela_farmaceutico_verifica_receita_entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_farmaceutico_loggedin);

        ImageButton_tela_login_screen_medico_back = findViewById(R.id.ImageButton_tela_login_screen_medico_back);
        ImageButton_tela_login_screen_medico_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_loggedin.this, tela_login_farmaceutico.class);
                startActivity(intent);
            }
        });

        imageButtont_tela_farmaceutico_cadastrar_medicamento_entrar = findViewById(R.id.imageButtont_tela_farmaceutico_cadastrar_medicamento_entrar);
        imageButtont_tela_farmaceutico_cadastrar_medicamento_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_loggedin.this, tela_farmaceutico_loggedin_cadastrar_medicamento.class);
                startActivity(intent);
            }
        });

        imageButton_tela_farmaceutico_verifica_receita_entrar = findViewById(R.id.imageButton_tela_farmaceutico_verifica_receita_entrar);
        imageButton_tela_farmaceutico_verifica_receita_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_loggedin.this, tela_farmaceutico_loggedin_verifica_receita.class);
                startActivity(intent);
            }
        });

    }
}