package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tela_paciente_loggedin extends AppCompatActivity {

    ImageButton imageButton_tela_login_paciente_loggedin_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_paciente_loggedin);


        imageButton_tela_login_paciente_loggedin_back = findViewById(R.id.imageButton_tela_login_paciente_loggedin_back);
        imageButton_tela_login_paciente_loggedin_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_loggedin.this, tela_login_paciente.class);
                startActivity(intent);

            }
        });
    }
}