package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class tela_create_account_adm extends AppCompatActivity {

    Medico medico = new Medico();
    Farmaceutico farmaceutico = new Farmaceutico();

    ImageButton imageButton_tela_create_account_adm_back;
    RadioButton radioButton_medico, radioButton_farmaceutico;
    Button button_criar_conta;
    TextView textView_nome_farm_med, textView_crm_crf, textView_senha_farm_med, textView_repetir_senha_farm_med;


        // Método criado para ir para a tela anterior
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        ClasseDAO dao = new ClasseDAO(this);

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

        //Método para criar conta farmacêutico/médico
        button_criar_conta = findViewById(R.id.button_criar_conta);

        textView_nome_farm_med = findViewById(R.id.textView_nome_farm_med);
        textView_crm_crf = findViewById(R.id.textView_crm_crf);
        textView_senha_farm_med = findViewById(R.id.textView_senha_farm_med);
        textView_repetir_senha_farm_med = findViewById(R.id.textView_repetir_senha_farm_med);


        button_criar_conta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(radioButton_farmaceutico.isChecked()){
                        farmaceutico.setNome(textView_nome_farm_med.getText().toString());
                        farmaceutico.setCrf(textView_crm_crf.getText().toString());
                        farmaceutico.setSenha(textView_senha_farm_med.getText().toString());

                        dao.inserirFarmaceutico(farmaceutico);
                    }
                    else{
                        medico.setNome(textView_nome_farm_med.getText().toString());
                        medico.setCrm(textView_crm_crf.getText().toString());
                        medico.setSenha(textView_senha_farm_med.getText().toString());

                        dao.inserirMedico(medico);
                    }

                }catch (SQLiteConstraintException e){
                    Toast.makeText(tela_create_account_adm.this, "Esse CRM/CRF já já foi cadastrado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Fim do método para criar conta farmacêutico/médico

    }
}