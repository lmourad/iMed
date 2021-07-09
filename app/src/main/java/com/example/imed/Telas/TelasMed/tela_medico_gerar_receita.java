
package com.example.imed.Telas.TelasMed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imed.Banco.ClasseDAO;
import com.example.imed.R;
import com.example.imed.Receita.Receita;

import java.util.Random;

public class tela_medico_gerar_receita extends AppCompatActivity {

    ImageButton imageButton_go_back_tela_medico_loggedin;
    Button button_gerar_receita_med;
    TextView textView_nome_remedio,textView_dosagem,textView_nome_horario,textView_instrucoes,textView_cpf_do_paciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Random random = new Random();
        ClasseDAO dao = new ClasseDAO(this  );
        Receita receita = new Receita();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_gerar_receita);

        Intent intent = getIntent();
        String valor = intent.getStringExtra("MedicoCrm");



        //==========================================================//
        imageButton_go_back_tela_medico_loggedin = findViewById(R.id.imageButton_go_back_tela_medico_loggedin);
        button_gerar_receita_med = findViewById(R.id.button_gerar_receita_med);
        textView_nome_remedio = findViewById(R.id.textView_nome_remedio);
        textView_dosagem = findViewById(R.id.textView_dosagem);
        textView_nome_horario = findViewById(R.id.textView_nome_horario);
        textView_instrucoes = findViewById(R.id.textView_instrucoes);
        textView_cpf_do_paciente = findViewById(R.id.textView_cpf_do_paciente);
        textView_cpf_do_paciente.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        //==========================================================//


        button_gerar_receita_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int idReceita = random.nextInt(5000) + 1000;

                    receita.setIdReceita(idReceita+"");
                    receita.setDosagem(textView_dosagem.getText().toString());
                    receita.setHorario(textView_nome_horario.getText().toString());
                    receita.setNome_remedio(textView_nome_remedio.getText().toString());
                    receita.setInstrucoes(textView_instrucoes.getText().toString());
                    receita.setFk_paciente_rec(textView_cpf_do_paciente.getText().toString());
                    receita.setFk_med(valor);

                    if(textView_nome_remedio.getText().toString().equals("") || textView_cpf_do_paciente.getText().toString().equals("") ||
                            textView_dosagem.getText().toString().equals("") || textView_nome_horario.getText().toString().equals("") ||
                            textView_instrucoes.getText().toString().equals("")){
                        Toast.makeText(tela_medico_gerar_receita.this, "Há campos vazios!", Toast.LENGTH_SHORT).show();
                    }
                    else if(textView_cpf_do_paciente.getText().toString().length()>0 && textView_cpf_do_paciente.getText().toString().length()<12) {
                        if(textView_cpf_do_paciente.getText().toString().equals(dao.retornaCPF(textView_cpf_do_paciente.getText().toString()))){
                            dao.gerarReceita(receita);
                            Toast.makeText(tela_medico_gerar_receita.this, "Receita criada com sucesso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(tela_medico_gerar_receita.this, tela_medico_inicio.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(tela_medico_gerar_receita.this, "CPF Ínvalido", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(tela_medico_gerar_receita.this, "CPF Ínvalido", Toast.LENGTH_SHORT).show();
                    }

                }
                catch (SQLiteConstraintException e){
                    int idReceita = random.nextInt(5000) + 1000;

                    receita.setIdReceita(idReceita+"");
                    receita.setDosagem(textView_dosagem.getText().toString());
                    receita.setHorario(textView_nome_horario.getText().toString());
                    receita.setNome_remedio(textView_nome_remedio.getText().toString());
                    receita.setInstrucoes(textView_instrucoes.getText().toString());
                    receita.setFk_paciente_rec(textView_cpf_do_paciente.getText().toString());
                    receita.setFk_med(valor);

                    if(textView_nome_remedio.getText().toString().equals("") || textView_cpf_do_paciente.getText().toString().equals("") ||
                            textView_dosagem.getText().toString().equals("") || textView_nome_horario.getText().toString().equals("") ||
                            textView_instrucoes.getText().toString().equals("")){
                        Toast.makeText(tela_medico_gerar_receita.this, "Há campos vazios!", Toast.LENGTH_SHORT).show();
                    }
                    else if(textView_cpf_do_paciente.getText().toString().length()>0 && textView_cpf_do_paciente.getText().toString().length()<12) {
                        if(textView_cpf_do_paciente.getText().toString().equals(dao.retornaCPF(textView_cpf_do_paciente.getText().toString()))){
                            dao.gerarReceita(receita);
                            Toast.makeText(tela_medico_gerar_receita.this, "Receita criada com sucesso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(tela_medico_gerar_receita.this, tela_medico_inicio.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(tela_medico_gerar_receita.this, "CPF Ínvalido", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(tela_medico_gerar_receita.this, "CPF Ínvalido", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        imageButton_go_back_tela_medico_loggedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_gerar_receita.this, tela_medico_inicio.class);
                startActivity(intent);
            }
        });



    }
}