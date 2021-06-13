package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tela_create_account_paciente extends AppCompatActivity {

    ImageButton imageButton_tela_create_account_login_paciente_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_create_account_paciente);

        imageButton_tela_create_account_login_paciente_back = findViewById(R.id.imageButton_tela_create_account_login_paciente_back);
        imageButton_tela_create_account_login_paciente_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_create_account_paciente.this, tela_login_paciente.class);
                startActivity(intent);

            }
        });


    }
}