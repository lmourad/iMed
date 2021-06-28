package com.example.imed;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ClasseDAO {

    private Conexão conexão;
    private SQLiteDatabase banco;

    public ClasseDAO(Context context) {
        try {
            conexão = new Conexão(context);
            banco = conexão.getReadableDatabase();
        }catch (Exception e){
           System.out.println(e);
        }
    }

    public void inserirPaciente(Paciente paciente){
        ContentValues values = new ContentValues();
        values.put("cpf", paciente.getCpf());
        values.put("nome", paciente.getNome());
        values.put("senha", paciente.getSenha());
        banco.insert("Paciente", null, values);
    }

    public List<Paciente> obterPaciente(){
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Cursor cursor = banco.query("paciente", new String[]{"cpf","nome","senha"}, null,null,null,null,null);
        while(cursor.moveToNext()){
            Paciente p = new Paciente();
            p.setCpf(cursor.getString(cursor.getColumnIndex("cpf")));
            p.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            p.setSenha(cursor.getString(cursor.getColumnIndex("senha")));

            pacientes.add(p);
        }
        return pacientes;
    }

    public void excluirPaciente(Paciente p){
        banco.delete("Paciente", "id = ?", new String []{p.getCpf().toString()});
    }



}
