package com.example.imed;

public class Medicamentos {

    private String catmat, pr_ativo, concentracao, fornecimento, forma_farm,nome_medicamento,fk_idReceita,fk_crm_med,fk_crf_farm;
    private int quantidade;

    public void setCatmat(String catmat) {
        this.catmat = catmat;
    }

    public void setPr_ativo(String pr_ativo) {
        this.pr_ativo = pr_ativo;
    }

    public void setConcentracao(String concentracao) {
        this.concentracao = concentracao;
    }

    public void setFornecimento(String fornecimento) {
        this.fornecimento = fornecimento;
    }

    public void setForma_farm(String forma_farm) {
        this.forma_farm = forma_farm;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setNome_medicamento(String nome_medicamento) {
        this.nome_medicamento = nome_medicamento;
    }

    public void setFk_idReceita(String fk_idReceita) {
        this.fk_idReceita = fk_idReceita;
    }

    public void setFk_crm_med(String fk_crm_med) {
        this.fk_crm_med = fk_crm_med;
    }

    public void setFk_crf_farm(String fk_crf_farm) {
        this.fk_crf_farm = fk_crf_farm;
    }

    public String getFk_idReceita() {
        return fk_idReceita;
    }

    public String getFk_crm_med() {
        return fk_crm_med;
    }

    public String getFk_crf_farm() {
        return fk_crf_farm;
    }

    public String getNome_medicamento() {
        return nome_medicamento;
    }

    public String getCatmat() {
        return catmat;
    }

    public String getPr_ativo() {
        return pr_ativo;
    }

    public String getConcentracao() {
        return concentracao;
    }

    public String getFornecimento() {
        return fornecimento;
    }

    public String getForma_farm() {
        return forma_farm;
    }

    public int getQuantidade() {
        return quantidade;
    }


    @Override
    public  String toString(){
        return "Nome do Medicamento: " + getNome_medicamento() + "\nCódigo CATMAT: " + getCatmat() +
                "\nPrincípio ativo: " + getPr_ativo() + "\nConcentração: " + getConcentracao() +
                "\nFornecimento: " + getFornecimento() + "\nForma Farmacêutica: " + getForma_farm();
    }
}
