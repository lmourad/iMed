package com.example.imed;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClasseDAO {

    private Conexão conexão;
    private SQLiteDatabase banco;

    public ClasseDAO(Context context){
        conexão = new Conexão(context);
        banco = conexão.getReadableDatabase();
    }

    public void inserir(Paciente paciente){
        ContentValues values = new ContentValues();
        values.put("cpf", paciente.getCpf());
        values.put("nome", paciente.getNome());
        values.put("senha", paciente.getSenha());
        banco.insert("Paciente", null, values);
    }

    public String busca(String cpf){
        String sql_busca_paciente = "select cpf from paciente where cpf = '" + cpf +"'";
        Cursor cursor = banco.rawQuery(sql_busca_paciente, null);

        while(cursor.moveToNext()){
            TesteDB testeDB = new TesteDB();
            testeDB.setTesteCpf(cursor.getString(cursor.getColumnIndex("cpf")));
        }
        banco.close();
        cursor.close();
        return sql_busca_paciente;
    }



}
