package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.MaskFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class tela_create_account_paciente extends AppCompatActivity {

    Paciente paciente = new Paciente();

    private ImageButton imageButton_tela_create_account_login_paciente_back;
    private Button Button_criar_conta_paciente;
    private TextView textView_nome_paciente, textView_cpf_paciente, textView_senha_paciente, textView_repetir_senha_paciente;
    private ClasseDAO dao;


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

        textView_nome_paciente = findViewById(R.id.textView_nome_paciente);
        textView_cpf_paciente = findViewById(R.id.textView_cpf_paciente);
        textView_senha_paciente = findViewById(R.id.textView_senha_paciente);
        textView_repetir_senha_paciente = findViewById(R.id.textView_repetir_senha_paciente);

        dao = new ClasseDAO(this);


        Button_criar_conta_paciente = findViewById(R.id.Button_criar_conta_paciente);
        Button_criar_conta_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                paciente.setNome(textView_nome_paciente.getText().toString()) ;
                paciente.setSenha(textView_senha_paciente.getText().toString());
                paciente.setCpf(textView_cpf_paciente.getText().toString());

                dao.inserirPaciente(paciente);


                Context context = getApplicationContext();
                CharSequence text = "Conta criada com sucesso!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                
                Intent intent = new Intent(tela_create_account_paciente.this, tela_login_paciente.class);
                startActivity(intent);

            }
        });



    }
}