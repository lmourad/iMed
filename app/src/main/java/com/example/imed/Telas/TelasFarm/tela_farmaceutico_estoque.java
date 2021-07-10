package com.example.imed.Telas.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.imed.Banco.ClasseDAO;
import com.example.imed.Receita.Medicamentos;
import com.example.imed.R;

import java.util.List;

public class tela_farmaceutico_estoque extends AppCompatActivity {

    ImageButton imageButton_go_back_estoque;
    ListView ListaMedicamentos;
    SearchView SearchView_medicamentos;

    private List<Medicamentos> medicamentos;
    private  ArrayAdapter<Medicamentos> adapterMedicamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_estoque);

        Intent intent = getIntent();
        String valor = intent.getStringExtra("FarmCrf");

        ListaMedicamentos = findViewById(R.id.ListaMedicamentos);
        medicamentos = dao.obterListaMedicamentos();

        adapterMedicamentos = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, medicamentos);
        ListaMedicamentos.setAdapter(adapterMedicamentos);

        //==================================================//
        SearchView_medicamentos = findViewById(R.id.SearchView_contas);
        SearchView_medicamentos.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tela_farmaceutico_estoque.this.adapterMedicamentos.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                tela_farmaceutico_estoque.this.adapterMedicamentos.getFilter().filter(newText);
                return false;
            }
        });
        //==================================================//




        imageButton_go_back_estoque = findViewById(R.id.imageButton_go_back_estoque);
        imageButton_go_back_estoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_estoque.this, tela_farmaceutico_inicio.class);
                intent.putExtra("FarmCrf", valor);
                startActivity(intent);
            }
        });
    }

}