package com.example.imed.Telas.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.imed.Banco.ClasseDAO;
import com.example.imed.R;

public class tela_farmaceutico_checar_receita extends AppCompatActivity {

    ImageButton imageButton_tela_verifica_receita_back;
    EditText editText_verifica_receita;
    Button button_verificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        Intent intent = getIntent();
        String valor = intent.getStringExtra("FarmCrf");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_checar_receita);

        imageButton_tela_verifica_receita_back = findViewById(R.id.imageButton_tela_verifica_receita_back);
        editText_verifica_receita = findViewById(R.id.editText_verifica_receita);
        button_verificar = findViewById(R.id.button_verificar);


        imageButton_tela_verifica_receita_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(tela_farmaceutico_checar_receita.this, tela_farmaceutico_inicio.class);
                startActivity(intent);
            }
        });

        button_verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int id = Integer.parseInt(editText_verifica_receita.getText().toString());
                    Log.i("aqui", "" + id);
                    dao.inserirFkFarm(valor, id);
                    Intent intent = new Intent(tela_farmaceutico_checar_receita.this, tela_farmaceutico_apresentacao_receita.class);
                    startActivity(intent);
                }catch (NumberFormatException e){
                    Toast.makeText(tela_farmaceutico_checar_receita.this, "Dados incorretos", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}