package com.example.imed;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

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

    //Método para cadastrar um paciente
    public void inserirPaciente(Paciente paciente){
        ContentValues values = new ContentValues();
        values.put("cpf", paciente.getCpf());
        values.put("paciente_nome", paciente.getNome());
        values.put("paciente_senha", paciente.getSenha());
        banco.insertOrThrow("paciente",null,values);
    }

    //Método para cadastrar um medico
    public void inserirMedico(Medico medico) {

        ContentValues values = new ContentValues();
        values.put("crm", medico.getCrm());
        values.put("med_nome", medico.getNome());
        values.put("med_senha", medico.getSenha());
        values.put("fk_adm_med", "adm");
        banco.insertOrThrow("medico",null,values);
    }

    //Método para cadastrar um farmaceutico
    public void inserirFarmaceutico(Farmaceutico farmaceutico){
        ContentValues values = new ContentValues();
        values.put("crf", farmaceutico.getCrf());
        values.put("farm_nome",farmaceutico.getNome());
        values.put("farm_senha", farmaceutico.getSenha());


        values.put("fk_adm_farm", "adm");///Corrigir!!!!

        banco.insertOrThrow("farmaceutico",null,values);
    }

    //Método para criar um cadastro de medicamentos
    public void inserirMedicamentos(Medicamentos medicamentos){
        ContentValues values = new ContentValues();
        values.put("catmat", medicamentos.getCatmat());
        values.put("pr_ativo", medicamentos.getPr_ativo());
        values.put("concentracao", medicamentos.getConcentracao());
        values.put("fornecimento", medicamentos.getFornecimento());
        values.put("forma_farm",medicamentos.getForma_farm());

        values.put("quantidade", 1);
        values.put("fk_idReceita", 1);
        values.put("fk_crm_med", ""); ///Corrigir!!!!
        values.put("fk_crf_farm","");

        banco.insertOrThrow("medicamento", null, values);
    }

    //Método para gerar receitas
    public void gerarReceita(Receita receita){
        ContentValues values = new ContentValues();
        values.put("idReceita",receita.getIdReceita());
        values.put("nome_remedio", receita.getNome_remedio());
        values.put("horario", receita.getHorario());
        values.put("dosagem", receita.getDosagem());
        values.put("instrucoes", receita.getInstrucoes());

        values.put("fk_paciente_rec", receita.getFk_paciente_rec());
        values.put("fk_farm", "");              //Corrigir!!!!!!!!
        values.put("fk_med", receita.getFk_med());

       banco.insertOrThrow("receita",null,values);
    }

    //Método para obter o login dos pacientes
    public Object[] obterLoginPaciente(String cpf){
        Object[] objeto = new Object[1];

        String busca = "select paciente_senha from paciente where cpf = " + "'" + cpf + "'";
        Cursor cursor = banco.rawQuery(busca, null);
        while (cursor.moveToNext()) {
            objeto[0] = cursor.getString(cursor.getColumnIndex("paciente_senha"));
        }
        return objeto;
    }

    //Método para obter o login dos médicos
    public Object[] obterLoginMedico(String crm){
        Object[] objeto = new Object[1];

        String busca = "select med_senha from medico where crm =" + "'"+ crm +"'";
        Cursor cursor = banco.rawQuery(busca,null);
        while (cursor.moveToNext()) {
            objeto[0] = cursor.getString(cursor.getColumnIndex("med_senha"));
        }
        return objeto;
    }

    //Método para obter o login do farmacêutico
    public Object[] obterLoginFarmaceutico(String crf){
        Object[] objeto = new Object[1];
        String busca = "select farm_senha from farmaceutico where crf =" + "'" + crf + "'";
        Cursor cursor = banco.rawQuery(busca,null);

        while (cursor.moveToNext()) {
            objeto[0] = cursor.getString(cursor.getColumnIndex("farm_senha"));
        }
        return objeto;
    }

    //Método para obter a senha do adm
    public Object[] obterLoginAdm(String nome){
        Object[] objeto = new Object[1];

        String busca = "select adm_senha from adm where adm_nome = " + "'" + nome + "'";
        Cursor cursor = banco.rawQuery(busca,null);

        while (cursor.moveToNext()) {
            objeto[0] = cursor.getString(cursor.getColumnIndex("adm_senha"));
        }

        return objeto;
    }
    //Método para o cpf do paciente
    public String retornaCPF(String cpf){
        String retornaCpf="";
        String busca ="select cpf from paciente where cpf=" + "'" + cpf + "'";
        Cursor cursor = banco.rawQuery(busca,null);
        while(cursor.moveToNext()){
            retornaCpf = cursor.getString(cursor.getColumnIndex("cpf"));
        }
        return  retornaCpf;
    }

//    //Método para o crm do médico
//    public String retornaCRM(String crm){
//        String retornaCrm = "";
//        String busca = "select crm from medico where crm = '" +crm + "'";
//        Cursor cursor = banco.rawQuery(busca, null);
//        while(cursor.moveToNext()){
//            retornaCrm = cursor.getString(cursor.getColumnIndex("crm"));
//        }
//        return retornaCrm;
//    }

    //Método para o crf do farmacêutico
    public String retornCRF(String crf){
        String retornaCrf = "";
        String busca = "select crf from farmaceutico where crf = '" +crf+"'";
        Cursor cursor = banco.rawQuery(busca,null);
        while(cursor.moveToNext()){
            retornaCrf=cursor.getString(cursor.getColumnIndex("crf"));
        }
        return retornaCrf;
    }



    //Método para obter a lista de farmacêuticos
    public List<Farmaceutico> obterListaFarmaceutico(){
        ArrayList<Farmaceutico> farmaceuticos = new ArrayList<>();
        Cursor cursor = banco.query("farmaceutico", new String[]{"crf","farm_nome"},null,null,null,null,null);
        while(cursor.moveToNext()) {
            Farmaceutico f = new Farmaceutico();
            f.setCrf(cursor.getString(cursor.getColumnIndex("crf")));
            f.setNome(cursor.getString(cursor.getColumnIndex("farm_nome")));
            farmaceuticos.add(f);
        }

        return farmaceuticos;
    }
    //Método para obter a lista de médicos
    public List<Medico> obterListaMedico(){
        ArrayList<Medico> medicos = new ArrayList<>();
        Cursor cursor = banco.query("medico", new String[]{"crm", "med_nome"},null,null,null,null,null);

        while(cursor.moveToNext()){
            Medico m = new Medico();
            m.setCrm(cursor.getString(cursor.getColumnIndex("crm")));
            m.setNome(cursor.getString(cursor.getColumnIndex("med_nome")));
            medicos.add(m);
        }
        return medicos;
    }

    public List<Receita> obterListaReceita(){
        ArrayList<Receita> receitas = new ArrayList<>();
        Cursor cursor = banco.query("receita", new String[]{"idReceita","nome_remedio", "horario", "dosagem", "instrucoes" , "fk_med"},null,null,null,null,null);

        while(cursor.moveToNext()){
            Receita r = new Receita();
            r.setIdReceita(cursor.getString(cursor.getColumnIndex("idReceita")));
            r.setNome_remedio(cursor.getString(cursor.getColumnIndex("nome_remedio")));
            r.setDosagem(cursor.getString(cursor.getColumnIndex("dosagem")));
            r.setHorario(cursor.getString(cursor.getColumnIndex("horario")));
            r.setInstrucoes(cursor.getString(cursor.getColumnIndex("instrucoes")));
            r.setFk_med(cursor.getString(cursor.getColumnIndex("fk_med")));
            receitas.add(r);
        }
        return receitas;
    }



//    public void excluirPaciente(Paciente p){
//        banco.delete("paciente", "id = ?", new String []{p.getCpf().toString()});
//    }



}
