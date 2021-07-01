package com.example.imed;

public class Farmaceutico extends Usuario{

    String crf;

    public String getCrf() {
        return crf;
    }

    public void setCrf(String crf) {
        this.crf = crf;
    }

    @Override
    public String toString(){
        return "CRF-SP " + getCrf() + "   ---   " + "Nome: " +getNome();
    }
}
