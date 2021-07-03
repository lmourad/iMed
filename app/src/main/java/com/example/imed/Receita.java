package com.example.imed;

public class Receita {
    int idReceita;
    String nome_remedio,horario,dosagem,instrucoes, fk_paciente_rec,fk_farm,fk_med;

    public void setFk_paciente_rec(String fk_paciente_rec) { this.fk_paciente_rec = fk_paciente_rec; }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public void setNome_remedio(String nome_remedio) {
        this.nome_remedio = nome_remedio;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }

    public void setFk_farm(String fk_farm) { this.fk_farm = fk_farm; }

    public void setFk_med(String fk_med) { this.fk_med = fk_med; }

    public int getIdReceita() {
        return idReceita;
    }

    public String getNome_remedio() {
        return nome_remedio;
    }

    public String getHorario() {
        return horario;
    }

    public String getDosagem() {
        return dosagem;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public String getFk_paciente_rec() { return fk_paciente_rec; }

    public String getFk_farm() {
        return fk_farm;
    }

    public String getFk_med() {
        return fk_med;
    }
}
