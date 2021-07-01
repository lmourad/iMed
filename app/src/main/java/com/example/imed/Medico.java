package com.example.imed;

public class Medico extends Usuario{

    String crm;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }


    @Override
    public String toString(){
        return "CRM-SP " + getCrm() + "   ---   " + "Nome: " + getNome();
    }
}
