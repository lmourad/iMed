package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tela_create_account_adm extends AppCompatActivity {

    ImageButton imageButton_tela_create_account_adm_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_create_account_adm);

        imageButton_tela_create_account_adm_back = findViewById(R.id.imageButton_tela_create_account_adm_back);
        imageButton_tela_create_account_adm_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_create_account_adm.this, tela_adm_loggedin.class);
                startActivity(intent);
            }
        });

    }
}