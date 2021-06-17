package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class tela_login_paciente extends AppCompatActivity {

    ImageButton imageButton_tela_login_paciente_back;
    Button button_tela_paciente_entrar, button_tela_paciente_criar_conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_paciente);

        imageButton_tela_login_paciente_back = findViewById(R.id.imageButton_tela_login_paciente_back);
        imageButton_tela_login_paciente_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_paciente.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button_tela_paciente_entrar = findViewById(R.id.button_tela_paciente_entrar);
        button_tela_paciente_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_paciente.this, tela_paciente_loggedin.class);
                startActivity(intent);
            }
        });

        button_tela_paciente_criar_conta = findViewById(R.id.button_tela_paciente_criar_conta);
        button_tela_paciente_criar_conta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_paciente.this, tela_create_account_paciente.class);
                startActivity(intent);
            }
        });


    }


}