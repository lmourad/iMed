package com.example.imed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class tela_farmaceutico_loggedin_cadastrar_medicamento extends AppCompatActivity {

    Medicamentos medicamentos = new Medicamentos();

    private ImageButton imageButton_tela_cadastrar_medicamento_back;
    private Button Button_cadastrar_medicamentos;
    private EditText editText_catmat,editText_pr_ativo,editText_concentracao,editText_forma_farm,editText_fornecimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_farmaceutico_loggedin_cadastrar_medicamento);


        imageButton_tela_cadastrar_medicamento_back = findViewById(R.id.imageButton_tela_cadastrar_medicamento_back);
        imageButton_tela_cadastrar_medicamento_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_loggedin_cadastrar_medicamento.this, tela_farmaceutico_loggedin.class);
                startActivity(intent);

            }

        });



        editText_catmat = findViewById(R.id.editText_catmat);
        editText_pr_ativo = findViewById(R.id.editText_pr_ativo);
        editText_concentracao = findViewById(R.id.editText_concentracao);
        editText_forma_farm = findViewById(R.id.editText_forma_farm);
        editText_fornecimento = findViewById(R.id.editText_fornecimento);



        Button_cadastrar_medicamentos = findViewById(R.id.Button_cadastrar_medicamentos);
        Button_cadastrar_medicamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    medicamentos.setCatmat(editText_catmat.getText().toString());
                    medicamentos.setConcentracao(editText_concentracao.getText().toString());
                    medicamentos.setPr_ativo(editText_pr_ativo.getText().toString());
                    medicamentos.setForma_farm(editText_forma_farm.getText().toString());
                    medicamentos.setFornecimento(editText_fornecimento.getText().toString());

                    dao.inserirMedicamentos(medicamentos);

                }catch (SQLiteConstraintException e){
                    Toast.makeText(tela_farmaceutico_loggedin_cadastrar_medicamento.this, "Esse medicamento já está cadastrado", Toast.LENGTH_SHORT).show();
                }
            }
        });








    }
}