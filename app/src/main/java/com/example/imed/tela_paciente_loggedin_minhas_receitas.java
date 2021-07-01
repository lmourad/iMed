package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tela_paciente_loggedin_minhas_receitas extends AppCompatActivity {

    ImageButton imageButton_go_back_tela_paciente_loggedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_paciente_loggedin_minhas_receitas);

        imageButton_go_back_tela_paciente_loggedin = findViewById(R.id.imageButton_go_back_tela_paciente_loggedin);


        imageButton_go_back_tela_paciente_loggedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_loggedin_minhas_receitas.this, tela_paciente_loggedin.class);
                startActivity(intent);
            }
        });
    }
}