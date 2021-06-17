package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tela_delete_account extends AppCompatActivity {

    ImageButton imageButton_tela_adm_delete_account_go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_delete_account);

        //==============================================//

        imageButton_tela_adm_delete_account_go_back = findViewById(R.id.imageButton_tela_adm_delete_account_go_back);

        //==============================================//

        imageButton_tela_adm_delete_account_go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_delete_account.this, tela_adm_loggedin.class);
                startActivity(intent);
            }
        });







    }
}