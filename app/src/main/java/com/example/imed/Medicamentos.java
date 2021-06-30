package com.example.imed;

public class Medicamentos {

    private String catmat, pr_ativo, concentracao, fornecimento, forma_farm;
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
}
