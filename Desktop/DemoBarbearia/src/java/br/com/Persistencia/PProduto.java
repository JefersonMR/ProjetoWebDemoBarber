/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Persistencia;

import br.com.Entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aluno
 */
public class PProduto {
    //Cria o objeto de conexão com o banco pra galera usar
    private Connection connection;
    
    public PProduto(){
    connection = br.com.Util.Conexao.getConexao();
}
    public void incluirPro(Produto pd) throws Exception{
        //Cria a string com o sql para ser executado
        String sql = "INSERT INTO Produto ( marca,"
                + "nome, " + "descriçao, " + "fabricaçao, " + "validade) VALUES (?, ?, ?, ?, ?)";
    
    //Cria o objeto para executar os comandos "contra" o banco
        PreparedStatement prd = connection.prepareStatement(sql);

        //Seta os valores recebidos como parametro para a string SQL
         prd.setString(1, pd.getMarca());
         prd.setString(2, pd.getNome());
         prd.setString(3, pd.getDescriçao());
         prd.setDate(4, (java.sql.Date) pd.getFabricaçao());
         prd.setDate(5, (java.sql.Date) pd.getValidade());
         prd.executeUpdate();
    }
    
    public void excluirPro(Produto pd ) throws Exception{
        try {
        
        PreparedStatement ps= connection.prepareStatement("DELETE FROM * Produto WHERE idP=?");
        ps.setInt(1, pd.getCod());
        ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void alterarPro(Produto pd) throws Exception{
        try {
         PreparedStatement ps= connection.prepareStatement("UPDATE Produto SET marca=?, nome=?, descriçao=?, fabricaçao=?, validade=?");
         ps.setString(1, pd.getMarca());
         ps.setString(2, pd.getNome());
         ps.setString(3,pd.getDescriçao());
         ps.setDate(4, (java.sql.Date) pd.getFabricaçao());
         ps.setDate(5, (java.sql.Date)pd.getValidade());
         ps.executeUpdate();
           
        } catch (SQLException e) {
        }
    }
    
    public List<Produto>listarPro(){
        List<Produto> prdt = new ArrayList<Produto>();
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM Produto");
            
            while(rs.next()){
                Produto pro=new Produto();
                pro.setCod(rs.getInt("idP"));
                pro.setMarca(rs.getString("marca"));
                pro.setNome(rs.getString("nome"));
                pro.setDescriçao(rs.getString("descriçao"));
                pro.setFabricaçao(rs.getDate("fabricaçao"));
                pro.setValidade(rs.getDate("validade"));
                
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return prdt;
    }
             
}
