package com.example.imed.Telas.TelasPaciente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imed.Banco.ClasseDAO;
import com.example.imed.R;
import com.example.imed.Telas.Main.MainActivity;

public class tela_paciente_login extends AppCompatActivity {

    ImageButton imageButton_tela_login_paciente_back;
    Button button_tela_paciente_entrar, button_tela_paciente_criar_conta;
    TextView textView_tela_login_paciente_cpf,textView_tela_login_paciente_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paciente_login);

        imageButton_tela_login_paciente_back = findViewById(R.id.imageButton_tela_login_paciente_back);
        imageButton_tela_login_paciente_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_login.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button_tela_paciente_entrar = findViewById(R.id.button_tela_paciente_entrar);

        textView_tela_login_paciente_cpf = findViewById(R.id.textView_tela_login_paciente_cpf);
        textView_tela_login_paciente_cpf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});

        textView_tela_login_paciente_senha = findViewById(R.id.textView_tela_login_paciente_senha);
        textView_tela_login_paciente_senha.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});


        button_tela_paciente_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    if(dao.obterLoginPaciente(textView_tela_login_paciente_cpf.getText().toString())[0].toString().equals(textView_tela_login_paciente_senha.getText().toString())){

                        Toast.makeText(tela_paciente_login.this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(tela_paciente_login.this, tela_paciente_inicio.class);
                        intent.putExtra("PacienteCpf", textView_tela_login_paciente_cpf.getText().toString());
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(tela_paciente_login.this, "Dados incorretos", Toast.LENGTH_SHORT).show();
                    }

                }catch (NullPointerException e){
                    Toast.makeText(tela_paciente_login.this, "Dados incorretos!", Toast.LENGTH_SHORT).show();
                }




            }
        });

        button_tela_paciente_criar_conta = findViewById(R.id.button_tela_paciente_criar_conta);
        button_tela_paciente_criar_conta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_login.this, tela_paciente_criar_conta.class);
                startActivity(intent);
            }
        });


    }


}