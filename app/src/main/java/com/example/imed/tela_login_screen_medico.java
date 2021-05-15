package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class tela_login_screen_medico extends AppCompatActivity {

    ImageButton imgButton_back_tela_login_screen_medico;
    Button button_tela_login_screen_medico_entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_screen_medico);

        imgButton_back_tela_login_screen_medico = findViewById(R.id.imgButton_back_tela_login_screen_medico);
        imgButton_back_tela_login_screen_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_screen_medico.this, MainActivity.class);
                startActivity(intent);
            }
        });


        button_tela_login_screen_medico_entrar = findViewById(R.id.button_tela_login_screen_medico_entrar);
        button_tela_login_screen_medico_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_screen_medico.this, tela_medico_loggedin.class);
                startActivity(intent);
            }
        });

    }
}