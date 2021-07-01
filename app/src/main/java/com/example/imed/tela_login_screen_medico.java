package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.media.Image;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class tela_login_screen_medico extends AppCompatActivity {

    ImageButton imgButton_back_tela_login_screen_medico;
    Button button_tela_login_screen_medico_entrar;
    TextView textField_tela_login_screen_medico_crm,textPassword_tela_login_screen_medico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_screen_medico);

        imgButton_back_tela_login_screen_medico = findViewById(R.id.imgButton_back_tela_login_screen_medico);

        textField_tela_login_screen_medico_crm = findViewById(R.id.textField_tela_login_screen_medico_crm);
        textField_tela_login_screen_medico_crm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});

        textPassword_tela_login_screen_medico = findViewById(R.id.textPassword_tela_login_screen_medico);



        imgButton_back_tela_login_screen_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_login_screen_medico.this, MainActivity.class);
                startActivity(intent);
            }
        });


        button_tela_login_screen_medico_entrar = findViewById(R.id.button_tela_login_screen_medico_entrar);
        button_tela_login_screen_medico_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(dao.obterLoginMedico(textField_tela_login_screen_medico_crm.getText().toString())[0].toString().equals(textPassword_tela_login_screen_medico.getText().toString())){
                        Toast.makeText(tela_login_screen_medico.this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(tela_login_screen_medico.this, tela_medico_loggedin.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(tela_login_screen_medico.this, "Dados incorretos", Toast.LENGTH_SHORT).show();
                    }

                }catch (NullPointerException e){
                    Toast.makeText(tela_login_screen_medico.this, "Dados incorretos", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}