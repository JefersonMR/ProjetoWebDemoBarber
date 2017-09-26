/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Persistencia;

import br.com.Entidade.ECliente;
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
    public void incluirCli(ECliente cli) throws Exception{
        //Cria a string com o sql para ser executado
        String sql = "INSERT INTO Cliente ( cpf,"
                + "nome, " + "email, " + "fone, " + "endereco) VALUES (?, ?, ?, ?, ?)";
    
    //Cria o objeto para executar os comandos "contra" o banco
        PreparedStatement prd = connection.prepareStatement(sql);

        //Seta os valores recebidos como parametro para a string SQL
         prd.setString(1, cli.getCpf());
         prd.setString(2, cli.getNome());
         prd.setString(3, cli.getEmail());
         prd.setString(4, cli.getFone());
         prd.setString(5, cli.getEndereco());
         prd.executeUpdate();
    }
    
    public void excluirCli(ECliente cli ) throws Exception{
        try {
        
        PreparedStatement ps= connection.prepareStatement("DELETE FROM * cliente WHERE idcliente=?");
        ps.setInt(1, cli.getIDC());
        ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void alterarCli(ECliente cli) throws Exception{
        try {
         PreparedStatement ps= connection.prepareStatement("UPDATE cliente SET cpf=?, nome=?, email=?, fone=?, endereco=?");
         ps.setString(1, cli.getCpf());
         ps.setString(2, cli.getNome());
         ps.setString(3,cli.getEmail());
         ps.setString(4, cli.getFone());
         ps.setString(5,cli.getEndereco());
         ps.executeUpdate();
           
        } catch (SQLException e) {
        }
    }
    
    public List<ECliente>listarCli(){
        List<ECliente> cli = new ArrayList<ECliente>();
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM cliente");
            
            while(rs.next()){
                ECliente clt=new ECliente();
                clt.setIDC(rs.getInt("idcliente"));
                clt.setCpf(rs.getString("cpf"));
                clt.setNome(rs.getString("nome"));
                clt.setEmail(rs.getString("email"));
                clt.setFone(rs.getString("fone"));
                clt.setEndereco(rs.getString("endereco"));
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return cli;
    }
            
    
}
