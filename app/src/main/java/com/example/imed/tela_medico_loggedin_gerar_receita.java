package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class tela_medico_loggedin_gerar_receita extends AppCompatActivity {

    ImageButton imageButton_go_back_tela_medico_loggedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_medico_loggedin_gerar_receita);

        imageButton_go_back_tela_medico_loggedin = findViewById(R.id.imageButton_go_back_tela_medico_loggedin);


        imageButton_go_back_tela_medico_loggedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_loggedin_gerar_receita.this, tela_medico_loggedin.class);
                startActivity(intent);
            }
        });



    }
}