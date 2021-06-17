package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class tela_create_account_paciente extends AppCompatActivity {

    ImageButton imageButton_tela_create_account_login_paciente_back;
    TextView textView_tela_loggedin_paciente_senha;
    TextView textView_tela_loggedin_paciente_senha_repeat;
    ImageView imageView_warning;
    Button button_create_account_paciente;
    String senha, senha_repeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_create_account_paciente);

        textView_tela_loggedin_paciente_senha = findViewById(R.id.textView_tela_loggedin_paciente_senha);
        textView_tela_loggedin_paciente_senha_repeat = findViewById(R.id.textView_tela_loggedin_paciente_senha_repeat);
        button_create_account_paciente = findViewById(R.id.button_create_account_paciente);
        imageButton_tela_create_account_login_paciente_back = findViewById(R.id.imageButton_tela_create_account_login_paciente_back);
        imageView_warning = findViewById(R.id.imageView_warning);

        senha = textView_tela_loggedin_paciente_senha.getText().toString();
        senha_repeat = textView_tela_loggedin_paciente_senha_repeat.getText().toString();


        imageButton_tela_create_account_login_paciente_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_create_account_paciente.this, tela_login_paciente.class);
                startActivity(intent);
            }
        });

        button_create_account_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(senha.equals(senha_repeat)){
                    imageView_warning.setImageResource(R.drawable.thumbs_up_icon);
                }
                else{
                    imageView_warning.setImageResource(R.drawable.warning_icon);
                }

            }

        });


    }
}