package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class tela_paciente_meus_medicamentos extends AppCompatActivity {

    ImageButton imageButton_go_back_meus_medicamentos_to_paciente_loggedin;
    Button button_procurar_meus_medicamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_paciente_meus_medicamentos);


        //===========================================================//

        imageButton_go_back_meus_medicamentos_to_paciente_loggedin = findViewById(R.id.imageButton_go_back_meus_medicamentos_to_paciente_loggedin);
        button_procurar_meus_medicamentos = findViewById(R.id.button_procurar_meus_medicamentos);

        //===========================================================//



        imageButton_go_back_meus_medicamentos_to_paciente_loggedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_meus_medicamentos.this, tela_paciente_loggedin.class);
                startActivity(intent);
            }
        });


        button_procurar_meus_medicamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_meus_medicamentos.this, tela_lista_meus_medicamentos.class);
                startActivity(intent);
            }
        });
    }
}