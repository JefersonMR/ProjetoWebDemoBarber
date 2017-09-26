/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Entidade;

/**
 *
 * @author Jeferson
 */
public class Cliente {
    private int IDC=0;
    private String Cpf="";
    private String Nome="";
    private String Endereço="";
    private String Fone ="";
    private String Email="";

    public int getIDC() {
        return IDC;
    }

    public void setIDC(int cod) {
        this.IDC = cod;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        this.Cpf = cpf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getEnedereço() {
        return Endereço;
    }

    public void setEnedereço(String enedereço) {
        this.Endereço = enedereço;
    }

    public String getFone() {
        return Fone;
    }

    public void setFone(String fone) {
        this.Fone = fone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
    
   
}
