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
public class EServiço {
private int IDS =0;
private String Descriçao="";
private String Nome="";
private String Profissional="";
private String Tempo="";
private double valor=0;

    public int getIDS() {
        return IDS;
    }

    public void setIDS(int IDS) {
        this.IDS = IDS;
    }

    public String getDescriçao() {
        return Descriçao;
    }

    public void setDescriçao(String Descriçao) {
        this.Descriçao = Descriçao;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getProfissional() {
        return Profissional;
    }

    public void setProfissional(String Profissional) {
        this.Profissional = Profissional;
    }

    public String getTempo() {
        return Tempo;
    }

    public void setTempo(String Tempo) {
        this.Tempo = Tempo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


}
