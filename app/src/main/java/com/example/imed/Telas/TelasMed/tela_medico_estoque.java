package com.example.imed.Telas.TelasMed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.imed.Banco.ClasseDAO;
import com.example.imed.Receita.Medicamentos;
import com.example.imed.R;

import java.util.List;

public class tela_medico_estoque extends AppCompatActivity {

    ImageButton imageButton_go_back_estoque_medico;
    ListView ListaMedicamentosDisponivel;

    private List<Medicamentos> listaMedicamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_medico_estoque);

        imageButton_go_back_estoque_medico = findViewById(R.id.imageButton_go_back_estoque_medico);

        ListaMedicamentosDisponivel = findViewById(R.id.ListaMedicamentosDisponivel);
        listaMedicamentos = dao.obterListaMedicamentos();

        ArrayAdapter<Medicamentos> adapterMedicamentos= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listaMedicamentos);
        ListaMedicamentosDisponivel.setAdapter(adapterMedicamentos);

        imageButton_go_back_estoque_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_estoque.this, tela_medico_inicio.class);
                startActivity(intent);
            }
        });
    }
}