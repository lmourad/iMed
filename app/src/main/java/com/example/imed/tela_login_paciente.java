package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class tela_login_paciente extends AppCompatActivity {

    ImageButton imageButton_tela_login_paciente_back;
    Button button_tela_paciente_entrar, button_tela_paciente_criar_conta;
    TextView textView_tela_login_paciente_cpf,textView_tela_login_paciente_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_paciente);

        imageButton_tela_login_paciente_back = findViewById(R.id.imageButton_tela_login_paciente_back);
        imageButton_tela_login_paciente_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_paciente.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button_tela_paciente_entrar = findViewById(R.id.button_tela_paciente_entrar);
        textView_tela_login_paciente_cpf = findViewById(R.id.textView_tela_login_paciente_cpf);
        textView_tela_login_paciente_senha = findViewById(R.id.textView_tela_login_paciente_senha);

        button_tela_paciente_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    if(dao.obterLoginPaciente(textView_tela_login_paciente_cpf.getText().toString())[0].toString().equals(textView_tela_login_paciente_senha.getText().toString())){

                        Intent intent = new Intent(tela_login_paciente.this, tela_paciente_loggedin.class);
                        startActivity(intent);

                        Toast.makeText(tela_login_paciente.this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(tela_login_paciente.this, "Dados incorretos", Toast.LENGTH_SHORT).show();
                    }

                }catch (NullPointerException e){
                    Toast.makeText(tela_login_paciente.this, "Dados incorretos!", Toast.LENGTH_SHORT).show();
                }




            }
        });

        button_tela_paciente_criar_conta = findViewById(R.id.button_tela_paciente_criar_conta);
        button_tela_paciente_criar_conta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_paciente.this, tela_create_account_paciente.class);
                startActivity(intent);
            }
        });


    }


}