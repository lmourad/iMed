package com.example.imed;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClasseDAO {

    private Conexão conexão;
    private SQLiteDatabase banco;

    public ClasseDAO(Context context) {

        try {
            conexão = new Conexão(context);
            banco = conexão.getWritableDatabase();
        }catch (Exception e){
            Toast.makeText(context, "Conexão com o banco falhou", Toast.LENGTH_SHORT).show();
        }

    }

    public void abrir(){

    }


    public void inserirPaciente(Paciente paciente){
        ContentValues values = new ContentValues();
        values.put("cpf", paciente.getCpf());
        values.put("paciente_nome", paciente.getNome());
        values.put("paciente_senha", paciente.getSenha());
        banco.insertOrThrow("paciente",null,values);
    }

    public void inserirMedico(Medico medico) {

        ContentValues values = new ContentValues();
        values.put("crm", medico.getCrm());
        values.put("med_nome", medico.getNome());
        values.put("med_senha", medico.getSenha());
        values.put("fk_adm_med", "Conta adm");
        banco.insertOrThrow("medico",null,values);
    }

    public void inserirFarmaceutico(Farmaceutico farmaceutico){
        ContentValues values = new ContentValues();
        values.put("crf", farmaceutico.getCrf());
        values.put("farm_nome",farmaceutico.getNome());
        values.put("farm_senha", farmaceutico.getSenha());
        values.put("fk_adm_farm", "Conta adm");
        banco.insertOrThrow("farmaceutico",null,values);
    }

//    public List<Paciente> obterPaciente(){
//        ArrayList<Paciente> pacientes = new ArrayList<>();
//        Cursor cursor = banco.query("paciente", new String[]{"cpf","paciente_nome","paciente_senha"}, null,null,null,null,null);
//        while(cursor.moveToNext()){
//            Paciente p = new Paciente();
//            p.setCpf(cursor.getString(cursor.getColumnIndex("cpf")));
//            p.setNome(cursor.getString(cursor.getColumnIndex("paciente_nome")));
//            p.setSenha(cursor.getString(cursor.getColumnIndex("paciente_senha")));
//
//            pacientes.add(p);
//        }
//        return pacientes;
//    }

//    public void excluirPaciente(Paciente p){
//        banco.delete("paciente", "id = ?", new String []{p.getCpf().toString()});
//    }



}
