/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Persistencia;

import br.com.Entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeferson
 */
public class PCliente {
    //Cria o objeto de conexão com o banco pra galera usar
    private Connection connection;
    
    public PCliente(){
    connection = br.com.Util.Conexao.getConexao();
}
    public void incluirCli(Cliente cli) throws Exception{
        //Cria a string com o sql para ser executado
        String sql = "INSERT INTO Cliente ( cpf,"
                + "nome, " + "endereço, " + "fone, " + "email) VALUES (?, ?, ?, ?, ?)";
    
    //Cria o objeto para executar os comandos "contra" o banco
        PreparedStatement prd = connection.prepareStatement(sql);

        //Seta os valores recebidos como parametro para a string SQL
         prd.setString(1, cli.getCpf());
         prd.setString(2, cli.getNome());
         prd.setString(3, cli.getEnedereço());
         prd.setString(4, cli.getFone());
         prd.setString(5, cli.getEmail());
         prd.executeUpdate();
    }
    
    public void excluirCli(Cliente cli ) throws Exception{
        try {
        
        PreparedStatement ps= connection.prepareStatement("DELETE FROM * Cliente WHERE idC=?");
        ps.setInt(1, cli.getIDC());
        ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void alterarCli(Cliente cli) throws Exception{
        try {
         PreparedStatement ps= connection.prepareStatement("UPDATE Cliente set cpf=?, nome=?, endereço=?, fone=?, email=?");
         ps.setString(1, cli.getCpf());
         ps.setString(2, cli.getNome());
         ps.setString(3,cli.getEnedereço());
         ps.setString(4, cli.getFone());
         ps.executeUpdate();
           
        } catch (SQLException e) {
        }
    }
    
    public List<Cliente>listarCli(){
        List<Cliente> cli = new ArrayList<Cliente>();
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM Cliente");
            
            while(rs.next()){
                Cliente clt=new Cliente();
                clt.setIDC(rs.getInt("idC"));
                clt.setCpf(rs.getString("cpf"));
                clt.setNome(rs.getString("nome"));
                clt.setEnedereço(rs.getString("endereço"));
                clt.setFone(rs.getString("fone"));
                clt.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return cli;
    }
            
    
}
