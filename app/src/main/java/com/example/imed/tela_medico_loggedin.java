package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tela_medico_loggedin extends AppCompatActivity {

    ImageButton imageButton_tela_login_screen_medico_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_medico_loggedin);


        imageButton_tela_login_screen_medico_back = findViewById(R.id.imageButton_tela_login_screen_medico_back);
        imageButton_tela_login_screen_medico_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_loggedin.this, tela_login_screen_medico.class);
                startActivity(intent);

            }
        });

    }
}