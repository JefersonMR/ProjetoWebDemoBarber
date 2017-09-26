/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Persistencia;

import br.com.Entidade.Serviço;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class PServiço {
    
    private Connection connection;
    
    public PServiço(){
        connection = br.com.Util.Conexao.getConexao();  
    }
    
    public void incluirSer(Serviço ser)throws Exception{
         //Cria a string com o sql para ser executado
        String sql = "INSERT INTO Produto ( nome,"
                + "descriçao, " + "profissional, " + "tempo, " + "valor) VALUES (?, ?, ?, ?, ?)";
    
    //Cria o objeto para executar os comandos "contra" o banco
        PreparedStatement prd = connection.prepareStatement(sql);

        //Seta os valores recebidos como parametro para a string SQL
         prd.setString(1, ser.getNome());
         prd.setString(2, ser.getDescriçao());
         prd.setString(3, ser.getProfissional());
         prd.setString(4, ser.getTempo());
         prd.setFloat(5, ser.getValor());
         prd.executeUpdate();
    }
    
    public void deleteSer(Serviço ser)throws Exception{
        try {
        PreparedStatement prd= connection.prepareStatement("DELETE * FROM Serviço WHERE idS=?");
        prd.setInt(1, ser.getIDS());
        prd.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
   public void alterarSer(Serviço ser)throws Exception{
       try {
           
       PreparedStatement prd = connection.prepareStatement("UPDATE Serviço SET nome=?, descriçao=?, profissional=?, tempo=?, valor=?");
       prd.setString(1, ser.getNome());
       prd.setString(1, ser.getDescriçao());
       prd.setString(1, ser.getProfissional());
       prd.setString(1, ser.getTempo());
       prd.setFloat(5, ser.getValor());
       
       prd.executeUpdate();
       } catch (SQLException e) {
       }
   }
   
   public list<Serviço> listarSer(){
       
   }
    
    
    
    
    
    
    
    
    
    
    
    
}
