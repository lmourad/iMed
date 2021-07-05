package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

public class tela_paciente_loggedin_minhas_receitas extends AppCompatActivity {

    ImageButton imageButton_go_back_tela_paciente_loggedin;
    ListView ListaReceitas;

    private List<Receita> receitas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_paciente_loggedin_minhas_receitas);

        imageButton_go_back_tela_paciente_loggedin = findViewById(R.id.imageButton_go_back_tela_paciente_loggedin);
        ListaReceitas = findViewById(R.id.ListaReceitas);

        receitas = dao.obterListaReceita();
        ArrayAdapter<Receita> adapterReceita = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, receitas);
        ListaReceitas.setAdapter(adapterReceita);


        imageButton_go_back_tela_paciente_loggedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_loggedin_minhas_receitas.this, tela_paciente_loggedin.class);
                startActivity(intent);
            }
        });
    }
}