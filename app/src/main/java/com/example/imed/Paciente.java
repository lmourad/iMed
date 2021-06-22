package com.example.imed;

public class Paciente extends Usuario {

    String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString(){
        return "nome: "+ getNome() + "\ncpf: " + cpf + "\nsenha: " + getSenha();
    }

}
