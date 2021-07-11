package com.example.imed.Telas.TelasAdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.imed.Banco.ClasseDAO;
import com.example.imed.R;
import com.example.imed.Usuarios.Farmaceutico;
import com.example.imed.Usuarios.Medico;

import java.util.List;

public class tela_adm_excluir_conta extends AppCompatActivity {



    ImageButton imageButton_tela_adm_delete_account_go_back,imageButton_excluir,imageButton_update;
    RadioButton radioButton_farmaceutico_lista,radioButton_medico_lista;
    ListView ListaContas;
    SearchView SearchView_contas;


    private List<Farmaceutico> farmaceuticos;
    private List<Medico> medicos;
    private View previousColor;

    private ArrayAdapter<Farmaceutico> adapterFarmaceutico;
    private ArrayAdapter<Medico> adapterMedico;

    private Farmaceutico itemFarm;
    private Medico itemMed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_adm_excluir_conta);

        Intent intent = getIntent();
        String valor = intent.getStringExtra("ContaAdm");


        //==============================================//
        imageButton_tela_adm_delete_account_go_back = findViewById(R.id.imageButton_tela_adm_delete_account_go_back);
        imageButton_excluir = findViewById(R.id.imageButton_excluir);
        radioButton_farmaceutico_lista = findViewById(R.id.radioButton_farmaceutico_lista);
        radioButton_medico_lista = findViewById(R.id.radioButton_medico_lista);
        ListaContas = findViewById(R.id.ListaContas);
        SearchView_contas = findViewById(R.id.SearchView_contas);
        imageButton_update = findViewById(R.id.imageButton_update);
        //==============================================//

        radioButton_farmaceutico_lista.setChecked(true);

        medicos = dao.obterListaMedico();
        adapterMedico = new ArrayAdapter<Medico>(this, android.R.layout.simple_list_item_1, medicos);

        farmaceuticos = dao.obterListaFarmaceutico();
        adapterFarmaceutico = new ArrayAdapter<Farmaceutico>(this, android.R.layout.simple_list_item_1,farmaceuticos);
        ListaContas.setAdapter(adapterFarmaceutico);

        radioButton_farmaceutico_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton_farmaceutico_lista.isChecked()){

                    radioButton_medico_lista.setChecked(false);
                    ListaContas.setAdapter(adapterFarmaceutico);

                }
            }
        });

        radioButton_medico_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton_medico_lista.isChecked()){

                    radioButton_farmaceutico_lista.setChecked(false);
                    ListaContas.setAdapter(adapterMedico);

                }
            }
        });

        //===============================================//
        SearchView_contas.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(radioButton_farmaceutico_lista.isChecked()){
                    tela_adm_excluir_conta.this.adapterFarmaceutico.getFilter().filter(query);
                }
                else {
                    tela_adm_excluir_conta.this.adapterMedico.getFilter().filter(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(radioButton_farmaceutico_lista.isChecked()){
                    tela_adm_excluir_conta.this.adapterFarmaceutico.getFilter().filter(newText);
                }
                else {
                    tela_adm_excluir_conta.this.adapterMedico.getFilter().filter(newText);
                }
                return false;
            }
        });
        //==============================================//

            ListaContas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Drawable corAnterior = view.getBackground();
                    if (previousColor != null) {
                        previousColor.setBackground(corAnterior);
                    }
                    previousColor = view;
                    view.setBackgroundColor(Color.parseColor("#00d165"));

                    if (radioButton_farmaceutico_lista.isChecked()) {
                        itemFarm = adapterFarmaceutico.getItem(position);
                    } else {
                        itemMed = adapterMedico.getItem(position);
                    }
                }
            });

        //==============================================//
        imageButton_excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton_farmaceutico_lista.isChecked()) {
                    System.out.println(itemFarm);
                    farmaceuticos.remove(itemFarm);
                    dao.deletarContaFarmaceutico(itemFarm.getCrf());
                }
                else{
                    System.out.println(itemMed);
                    medicos.remove(itemMed);
                    dao.deletarContaMedico(itemMed.getCrm());
                }
            }
        });

        imageButton_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton_farmaceutico_lista.isChecked()){
                    ListaContas.setAdapter(adapterFarmaceutico);
                }
                else{
                    ListaContas.setAdapter(adapterMedico);
                }
            }
        });

        //==============================================//

        imageButton_tela_adm_delete_account_go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_adm_excluir_conta.this, tela_adm_inicio.class);
                intent.putExtra("ContaAdm", valor);
                startActivity(intent);
            }
        });











    }
}