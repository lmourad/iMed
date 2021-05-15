package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.VisualVoicemailService;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton button_paciente;
    ImageButton imageButton_medico;
    ImageButton imageButton_farmaceutico;
    Button button_adm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button_paciente = findViewById(R.id.button_paciente);
        button_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tela_login_paciente.class);
                startActivity(intent);
            }
        });


        imageButton_medico = findViewById(R.id.imageButton_medico);
        imageButton_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tela_login_screen_medico.class);
                startActivity(intent);
            }
        });


        button_adm = findViewById(R.id.button_adm);
        button_adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tela_login_adm.class);
                startActivity(intent);
            }
        });


        imageButton_farmaceutico = findViewById(R.id.imageButton_farmaceutico);
        imageButton_farmaceutico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tela_login_farmaceutico.class);
                startActivity(intent);
            }
        });


    }
}