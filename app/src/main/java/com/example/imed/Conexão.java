package com.example.imed;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Conexão extends SQLiteOpenHelper {
    public Conexão(@Nullable Context context) {
        super(context, name, null, version);
    }

    private static final String name = "banco.db";
    private static final int version = 2;

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Pragma foreign_keys = ON;");

        db.execSQL("create table adm(adm_nome varchar(50) primary key not null, " +
                "adm_senha varchar(45))");

        db.execSQL("create table medico(crm varchar (7) primary key not null, " +
                "med_nome varchar(50), " +
                "med_senha varchar(45) not null, " +
                "fk_adm_med varchar (50) not null," +
                "foreign key (fk_adm_med) references adm(adm_nome))");

        db.execSQL("create table farmaceutico(crf varchar(7) primary key not null, " +
                "farm_nome varchar(50)," +
                "farm_senha varchar(45) not null," +
                "fk_adm_farm varchar(50) not null," +
                "foreign key (fk_adm_farm) references adm(adm_nome))");

        db.execSQL("create table paciente(cpf varchar(11) primary key not null," +
                "paciente_nome varchar(45) ," +
                "paciente_senha varchar(45) not null)");

        db.execSQL("create table observacoes(idObservacoes integer primary key autoincrement not null," +
                "texto varchar (45)," +
                "fk_paciente varchar(11) not null," +
                "foreign key (fk_paciente) references paciente(cpf))");

        db.execSQL("create table receita(idReceita integer primary key not null," +
                "fk_paciente_rec varchar(11) not null," +
                "fk_farm varchar(20) not null," +
                "fk_med varchar(20) not null," +
                "foreign key(fk_paciente_rec) references paciente(cpf)," +
                "foreign key(fk_farm) references farmaceutico(crf)," +
                "foreign key(fk_med) references medico(crm))");

        db.execSQL("create table medicamento(catmat varchar(45) primary key not null," +
                "concentracao varchar(45) not null," +
                "pr_ativo varchar(45) not null, " +
                "fornecimento varchar(45) not null," +
                "forma_farm varchar(45) not null," +
                "quantidade integer not null," +
                "fk_idReceita integer not null," +
                "fk_crm_med varchar(20) not null," +
                "fk_crf_farm varchar(20) not null," +
                "foreign key(fk_idReceita) references receita(idReceita)," +
                "foreign key(fk_crm_med) references medico(crm)," +
                "foreign key(fk_crf_farm) references farmaceutico(crf))");

        db.execSQL("insert into adm(adm_nome, adm_senha) values('adm','123')");

      }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}
