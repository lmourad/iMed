package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tela_estoque_medico extends AppCompatActivity {

    ImageButton imageButton_go_back_estoque_medico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_estoque_medico);

        imageButton_go_back_estoque_medico = findViewById(R.id.imageButton_go_back_estoque_medico);
        imageButton_go_back_estoque_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_estoque_medico.this, tela_medico_loggedin.class);
                startActivity(intent);
            }
        });
    }
}