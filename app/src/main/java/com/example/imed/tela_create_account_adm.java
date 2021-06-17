package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class tela_create_account_adm extends AppCompatActivity {

    ImageButton imageButton_tela_create_account_adm_back;
    RadioButton radioButton_medico, radioButton_farmaceutico;


        // Método criado para ir para a tela anterior
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_create_account_adm);

        imageButton_tela_create_account_adm_back = findViewById(R.id.imageButton_tela_create_account_adm_back);

        imageButton_tela_create_account_adm_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_create_account_adm.this, tela_adm_loggedin.class);
                startActivity(intent);
            }

        });
        // Fim do para ir para a tela anterior


        // Método criado para selecionar apenas um dos radioButtons
        radioButton_farmaceutico = findViewById(R.id.radioButton_farmaceutico);
        radioButton_medico = findViewById(R.id.radioButton_medico);

        radioButton_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton_medico.isChecked()){
                    radioButton_farmaceutico.setChecked(false);
                }
            }
        });

        radioButton_farmaceutico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton_farmaceutico.isChecked()){
                    radioButton_medico.setChecked(false);
                }
            }
        });
        // Fim do método de selecionar apenas um dos radioButtons



    }
}