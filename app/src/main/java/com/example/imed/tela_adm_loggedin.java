package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tela_adm_loggedin extends AppCompatActivity {

    ImageButton imageButton_tela_adm_loggedin_back;
    ImageButton imageButton_go_to_create_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_adm_loggedin);


        imageButton_tela_adm_loggedin_back = findViewById(R.id.imageButton_tela_adm_loggedin_back);
        imageButton_tela_adm_loggedin_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_adm_loggedin.this, tela_login_adm.class);
                startActivity(intent);
            }
        });

        imageButton_go_to_create_account = findViewById(R.id.imageButton_go_to_create_account);
        imageButton_go_to_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_adm_loggedin.this, tela_create_account_adm.class);
                startActivity(intent);
            }
        });


    }
}