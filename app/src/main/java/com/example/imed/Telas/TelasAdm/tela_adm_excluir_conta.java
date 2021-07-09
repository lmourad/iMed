package com.example.imed.Telas.TelasAdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.imed.Banco.ClasseDAO;
import com.example.imed.R;
import com.example.imed.Usuarios.Farmaceutico;
import com.example.imed.Usuarios.Medico;

import java.util.List;

public class tela_adm_excluir_conta extends AppCompatActivity {



    ImageButton imageButton_tela_adm_delete_account_go_back, imageButton_tela_adm_loggedin_delete,imageButton_excluir,imageButton_update;
    RadioButton radioButton_farmaceutico_lista,radioButton_medico_lista;
    ListView ListaContas;


    private List<Farmaceutico> farmaceuticos;
    private List<Medico> medicos;
    private View previousColor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_adm_excluir_conta);

        //==============================================//
        imageButton_tela_adm_delete_account_go_back = findViewById(R.id.imageButton_tela_adm_delete_account_go_back);
        imageButton_tela_adm_loggedin_delete = findViewById(R.id.imageButton_excluir);
        radioButton_farmaceutico_lista = findViewById(R.id.radioButton_farmaceutico_lista);
        radioButton_medico_lista = findViewById(R.id.radioButton_medico_lista);
        ListaContas = findViewById(R.id.ListaContas);
        //==============================================//

        radioButton_farmaceutico_lista.setChecked(true);

        medicos = dao.obterListaMedico();
        ArrayAdapter<Medico> adapterMedico = new ArrayAdapter<Medico>(this, android.R.layout.simple_list_item_1, medicos);

        farmaceuticos = dao.obterListaFarmaceutico();
        ArrayAdapter<Farmaceutico> adapterFarmaceutico = new ArrayAdapter<Farmaceutico>(this, android.R.layout.simple_list_item_1,farmaceuticos);
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


        //==============================================//

            ListaContas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String item = ListaContas.getItemAtPosition(position).toString();
                    Drawable corAnterior = view.getBackground();
                    if(previousColor!= null){
                        previousColor.setBackground(corAnterior);
                    }
                    previousColor = view;
                    view.setBackgroundColor(Color.parseColor("#00d165"));
                }
            });

        //==============================================//



        imageButton_tela_adm_loggedin_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        //==============================================//

        imageButton_tela_adm_delete_account_go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_adm_excluir_conta.this, tela_adm_inicio.class);
                startActivity(intent);
            }
        });







    }
}