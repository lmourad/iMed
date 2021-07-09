package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tela_lista_meus_medicamentos extends AppCompatActivity {

    ImageButton imageButton_go_back_lista_medicamentos_to_meus_medicamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_zlista_meus_medicamentos);


        imageButton_go_back_lista_medicamentos_to_meus_medicamentos = findViewById(R.id.imageButton_go_back_lista_medicamentos_to_meus_medicamentos);


        imageButton_go_back_lista_medicamentos_to_meus_medicamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_lista_meus_medicamentos.this, tela_zexcluir_paciente_meus_medicamentos.class);
                startActivity(intent);
            }
        });
    }
}