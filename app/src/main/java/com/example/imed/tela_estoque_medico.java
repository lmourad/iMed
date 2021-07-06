package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.Calendar;
import java.util.List;

public class tela_estoque_medico extends AppCompatActivity {

    ImageButton imageButton_go_back_estoque_medico;
    ListView ListaMedicamentosDisponivel;

    private List<Medicamentos> listaMedicamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_estoque_medico);

        imageButton_go_back_estoque_medico = findViewById(R.id.imageButton_go_back_estoque_medico);

        ListaMedicamentosDisponivel = findViewById(R.id.ListaMedicamentosDisponivel);
        listaMedicamentos = dao.obterListaMedicamentos();

        ArrayAdapter<Medicamentos> adapterMedicamentos= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listaMedicamentos);
        ListaMedicamentosDisponivel.setAdapter(adapterMedicamentos);

        imageButton_go_back_estoque_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_estoque_medico.this, tela_medico_loggedin.class);
                startActivity(intent);
            }
        });
    }
}