package com.example.imed.Telas.TelasMed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imed.Banco.ClasseDAO;
import com.example.imed.R;
import com.example.imed.Telas.Main.MainActivity;

public class tela_medico_login extends AppCompatActivity {

    ImageButton imgButton_back_tela_login_screen_medico;
    Button button_tela_login_screen_medico_entrar;
    TextView textField_tela_login_screen_medico_crm,textPassword_tela_login_screen_medico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_medico_login);

        //==========================================================================//

        imgButton_back_tela_login_screen_medico = findViewById(R.id.imgButton_back_tela_login_screen_medico);
        textField_tela_login_screen_medico_crm = findViewById(R.id.textField_tela_login_screen_medico_crm);
        textField_tela_login_screen_medico_crm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});
        textPassword_tela_login_screen_medico = findViewById(R.id.textPassword_tela_login_screen_medico);
        button_tela_login_screen_medico_entrar = findViewById(R.id.button_tela_login_screen_medico_entrar);

        //==========================================================================//



        imgButton_back_tela_login_screen_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_login.this, MainActivity.class);
                startActivity(intent);
            }
        });



        button_tela_login_screen_medico_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(dao.obterLoginMedico(textField_tela_login_screen_medico_crm.getText().toString())[0].toString().equals(textPassword_tela_login_screen_medico.getText().toString())){
                        Toast.makeText(tela_medico_login.this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(tela_medico_login.this, tela_medico_inicio.class);
                        intent.putExtra("MedicoCrm", textField_tela_login_screen_medico_crm.getText().toString());
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(tela_medico_login.this, "Dados incorretos", Toast.LENGTH_SHORT).show();
                    }

                }catch (NullPointerException e){
                    Toast.makeText(tela_medico_login.this, "Dados incorretos", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}