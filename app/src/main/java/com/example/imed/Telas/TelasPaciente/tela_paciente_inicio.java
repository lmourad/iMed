package com.example.imed.Telas.TelasPaciente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.R;
import com.example.imed.tela_zexcluir_paciente_meus_medicamentos;

public class tela_paciente_inicio extends AppCompatActivity {

    ImageButton imageButton_tela_login_paciente_loggedin_back;
    ImageButton imageButton_go_to_minhas_receitas_paciente;
    ImageButton imageButton_go_to_meus_medicamentos_paciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_paciente_inicio);

        //========================================================================//

        imageButton_go_to_minhas_receitas_paciente = findViewById(R.id.imageButton_go_to_minhas_receitas_paciente);
        imageButton_tela_login_paciente_loggedin_back = findViewById(R.id.imageButton_tela_login_paciente_loggedin_back);
        imageButton_go_to_meus_medicamentos_paciente = findViewById(R.id.imageButton_go_to_meus_medicamentos_paciente);

        //========================================================================//


        imageButton_tela_login_paciente_loggedin_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_inicio.this, tela_paciente_login.class);
                startActivity(intent);

            }
        });


        imageButton_go_to_minhas_receitas_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_inicio.this, tela_paciente_examinar_receita.class);
                startActivity(intent);
            }
        });


        imageButton_go_to_meus_medicamentos_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_inicio.this, tela_zexcluir_paciente_meus_medicamentos.class);
                startActivity(intent);
            }
        });
    }
}