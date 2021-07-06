package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class tela_login_farmaceutico extends AppCompatActivity {

    ImageButton imageButton_back_tela_login_farmaceutico;
    Button tela_login_farmaceutico_entrar;
    TextView textView_tela_login_farmaceutico_crf,textView_tela_login_farmaceutico_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_farmaceutico);

        textView_tela_login_farmaceutico_crf = findViewById(R.id.textView_tela_login_farmaceutico_crf);
        textView_tela_login_farmaceutico_crf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});


        textView_tela_login_farmaceutico_senha = findViewById(R.id.textView_tela_login_farmaceutico_senha);
        tela_login_farmaceutico_entrar = findViewById(R.id.tela_login_farmaceutico_entrar);


        imageButton_back_tela_login_farmaceutico = findViewById(R.id.imageButton_back_tela_login_farmaceutico);
        imageButton_back_tela_login_farmaceutico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_farmaceutico.this, MainActivity.class);
                startActivity(intent);
            }
        });



        tela_login_farmaceutico_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    if(dao.obterLoginFarmaceutico(textView_tela_login_farmaceutico_crf.getText().toString())[0].toString().equals(textView_tela_login_farmaceutico_senha.getText().toString())){
                        Toast.makeText(tela_login_farmaceutico.this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(tela_login_farmaceutico.this, tela_farmaceutico_loggedin.class);
                        intent.putExtra("FarmCrf", textView_tela_login_farmaceutico_crf.getText().toString());
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(tela_login_farmaceutico.this, "Dados incorretos!", Toast.LENGTH_SHORT).show();
                    }
                }catch (NullPointerException e){
                    Toast.makeText(tela_login_farmaceutico.this, "Dados incorretos!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}