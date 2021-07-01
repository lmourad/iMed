package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class tela_login_adm extends AppCompatActivity {

    ImageButton imgButton_back_tela_login_screen_adm;
    Button button_tela_login_adm_entrar;
    TextView textNumber_tela_login_screen_adm_login,textPassword_tela_login_screen_adm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_adm);

        textNumber_tela_login_screen_adm_login = findViewById(R.id.textNumber_tela_login_screen_adm_login);
        textPassword_tela_login_screen_adm = findViewById(R.id.textPassword_tela_login_screen_adm);


        imgButton_back_tela_login_screen_adm = findViewById(R.id.imgButton_back_tela_login_screen_adm);
        imgButton_back_tela_login_screen_adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_adm.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button_tela_login_adm_entrar = findViewById(R.id.button_tela_login_adm_entrar);
        button_tela_login_adm_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    if(dao.obterLoginAdm(textNumber_tela_login_screen_adm_login.getText().toString())[0].toString().equals(textPassword_tela_login_screen_adm.getText().toString())){
                        Toast.makeText(tela_login_adm.this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(tela_login_adm.this, tela_adm_loggedin.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(tela_login_adm.this, "Dados incorretos!", Toast.LENGTH_SHORT).show();
                    }
                }catch (NullPointerException e){
                    Toast.makeText(tela_login_adm.this, "Dados incorretos!", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }
}