package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class tela_login_adm extends AppCompatActivity {

    ImageButton imgButton_back_tela_login_screen_adm;
    Button button_tela_login_adm_entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_adm);

        imgButton_back_tela_login_screen_adm = findViewById(R.id.imgButton_back_tela_login_screen_adm);
        imgButton_back_tela_login_screen_adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_adm.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button_tela_login_adm_entrar = findViewById(R.id.button_tela_login_adm_entrar);
        button_tela_login_adm_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_adm.this, tela_adm_loggedin.class);
                startActivity(intent);
            }
        });
    }
}