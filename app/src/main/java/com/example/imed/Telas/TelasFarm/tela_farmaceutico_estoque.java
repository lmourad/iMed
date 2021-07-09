package com.example.imed.Telas.TelasFarm;

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

public class tela_farmaceutico_estoque extends AppCompatActivity {

    ImageButton imageButton_go_back_estoque;
    ListView ListaMedicamentos;

    private List<Medicamentos> medicamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_estoque);


        ListaMedicamentos = findViewById(R.id.ListaMedicamentos);
        medicamentos = dao.obterListaMedicamentos();

        ArrayAdapter<Medicamentos> adapterMedicamentos= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, medicamentos);
        ListaMedicamentos.setAdapter(adapterMedicamentos);

        imageButton_go_back_estoque = findViewById(R.id.imageButton_go_back_estoque);
        imageButton_go_back_estoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_estoque.this, tela_farmaceutico_inicio.class);
                startActivity(intent);
            }
        });
    }
}