package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

public class tela_delete_account extends AppCompatActivity {

    private List<Paciente> listaPacientes;
    private List<Paciente> listaPacienteFiltrada;

    ImageButton imageButton_tela_adm_delete_account_go_back;
    ListView Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_delete_account);

        //==============================================//

        imageButton_tela_adm_delete_account_go_back = findViewById(R.id.imageButton_tela_adm_delete_account_go_back);

        //==============================================//


        //==============================================//

        Lista = findViewById(R.id.Lista);

        ClasseDAO dao = new ClasseDAO(this);
        listaPacientes = dao.obterPaciente();
        //listaPacienteFiltrada.addAll(listaPacientes);
        ArrayAdapter<Paciente> adapter = new ArrayAdapter<Paciente>(this, android.R.layout.simple_list_item_1, listaPacientes);
        Lista.setAdapter(adapter);


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