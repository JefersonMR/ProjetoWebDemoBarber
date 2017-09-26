/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Persistencia;

import br.com.Entidade.EServiço;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class PServiço {
    
    private Connection connection;
    
    public PServiço(){
        connection = br.com.Util.Conexao.getConexao();  
    }
    
    public void incluirSer(EServiço ser)throws Exception{
         //Cria a string com o sql para ser executado
        String sql = "INSERT INTO servico ( nome,"
                + "descricao, " + "profissional, " + "tempo, " + "valor) VALUES (?, ?, ?, ?, ?)";
    
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
    
    public void deleteSer(EServiço ser)throws Exception{
        try {
        PreparedStatement prd= connection.prepareStatement("DELETE * FROM servico WHERE idservico=?");
        prd.setInt(1, ser.getIDS());
        prd.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
   public void alterarSer(EServiço ser)throws Exception{
       try {
           
       PreparedStatement prd = connection.prepareStatement("UPDATE servico SET nome=?, descricao=?, profissional=?, tempo=?, valor=?");
       prd.setString(1, ser.getNome());
       prd.setString(1, ser.getDescriçao());
       prd.setString(1, ser.getProfissional());
       prd.setString(1, ser.getTempo());
       prd.setFloat(5, ser.getValor());
       
       prd.executeUpdate();
       } catch (SQLException e) {
       }
   }
   
   public List<EServiço>listarPro(){
        List<EServiço> prdt = new ArrayList<EServiço>();
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM servico");
            
            while(rs.next()){
                EServiço ser=new EServiço();
                ser.setIDS(rs.getInt("idservico"));
                ser.setNome(rs.getString("nome"));
                ser.setDescriçao(rs.getString("descricao"));
                ser.setProfissional(rs.getString("profissional"));
                ser.setTempo(rs.getString("tempo"));
                ser.setValor(rs.getFloat("valor"));
                
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return prdt;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
