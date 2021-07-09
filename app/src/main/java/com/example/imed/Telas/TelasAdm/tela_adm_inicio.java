package com.example.imed.Telas.TelasAdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.R;

public class tela_adm_inicio extends AppCompatActivity {

    ImageButton imageButton_tela_adm_loggedin_back;
    ImageButton imageButton_go_to_create_account;
    ImageButton imageButton_go_to_delete_account_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_adm_inicio);

        Intent intent = getIntent();
        String valor = intent.getStringExtra("ContaAdm");

        //==================================================//

        imageButton_go_to_delete_account_screen = findViewById(R.id.imageButton_go_to_delete_account_screen);
        imageButton_tela_adm_loggedin_back = findViewById(R.id.imageButton_tela_adm_loggedin_back);
        imageButton_go_to_create_account = findViewById(R.id.imageButton_go_to_create_account);

        //================================================//




        imageButton_tela_adm_loggedin_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_adm_inicio.this, tela_adm_login.class);
                startActivity(intent);
            }
        });


        imageButton_go_to_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_adm_inicio.this, tela_adm_criar_conta_farm_e_med.class);
                intent.putExtra("ContaAdm", valor);
                startActivity(intent);
            }
        });


        imageButton_go_to_delete_account_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_adm_inicio.this, tela_adm_excluir_conta.class);
                startActivity(intent);
            }
        });


    }
}