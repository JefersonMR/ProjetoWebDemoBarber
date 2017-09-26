/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Entidade;

import java.util.Date;

/**
 *
 * @author Jeferson
 */
public class Produto {
private int Cod =0;
private String Marca="";
private String Nome="";
private String Descriçao="";
private Date fabricaçao;
private Date validade;

    public int getCod() {
        return Cod;
    }

    public void setCod(int Cod) {
        this.Cod = Cod;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDescriçao() {
        return Descriçao;
    }

    public void setDescriçao(String Descriçao) {
        this.Descriçao = Descriçao;
    }

    public Date getFabricaçao() {
        return fabricaçao;
    }

    public void setFabricaçao(Date fabricaçao) {
        this.fabricaçao = fabricaçao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }


}
