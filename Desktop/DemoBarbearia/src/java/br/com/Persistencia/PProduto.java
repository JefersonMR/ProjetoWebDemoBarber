/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Persistencia;

import br.com.Entidade.ECliente;
import br.com.Entidade.EProduto;
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
    public void incluirPro(EProduto pd) throws Exception{
        //Cria a string com o sql para ser executado
        String sql = "INSERT INTO produto ( marca,"
                + "nome, " + "descricao, " + "fabricacao, " + "validade) VALUES (?, ?, ?, ?, ?)";
    
    //Cria o objeto para executar os comandos "contra" o banco
        PreparedStatement prd = connection.prepareStatement(sql);

        //Seta os valores recebidos como parametro para a string SQL
         prd.setString(1, pd.getMarca());
         prd.setString(2, pd.getNome());
         prd.setString(3, pd.getDescriçao());
         prd.setDate(4, new java.sql.Date(pd.getFabricaçao().getTime()));
         prd.setDate(5, new java.sql.Date(pd.getValidade().getTime()));
         
         prd.executeUpdate();
         connection.close();
    }
    
    public void excluirPro(int id ) throws Exception{
        try {
        
        PreparedStatement ps= connection.prepareStatement("DELETE FROM produto WHERE idproduto=?");
        ps.setInt(1, id);
        
        ps.execute();
        connection.close();
        } catch (SQLException e) {
        }
    }
    
    public void alterarPro(EProduto pd) throws Exception{
        try {
         PreparedStatement ps= connection.prepareStatement("UPDATE produto SET marca=?, nome=?, descricao=?, fabricacao=?, validade=? WHERE idproduto=?");
         ps.setString(1, pd.getMarca());
         ps.setString(2, pd.getNome());
         ps.setString(3,pd.getDescriçao());
         ps.setDate(4, new java.sql.Date(pd.getFabricaçao().getTime()));
         ps.setDate(5, new java.sql.Date(pd.getFabricaçao().getTime()));
         ps.setInt(6, pd.getIDP());
         
         ps.executeUpdate();
         connection.close();
        } catch (SQLException e) {
        }
    }
    
    public List<EProduto>listarPro(){
        List<EProduto> prdt = new ArrayList<EProduto>();
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM produto WHERE 1=1");
            
            while(rs.next()){
                EProduto pro=new EProduto();
                pro.setIDP(rs.getInt("idproduto"));
                pro.setMarca(rs.getString("marca"));
                pro.setNome(rs.getString("nome"));
                pro.setDescriçao(rs.getString("descricao"));
                pro.setFabricaçao(rs.getDate("fabricacao"));
                pro.setValidade(rs.getDate("validade"));
                prdt.add(pro);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return prdt;
    }
        public EProduto consultarCli(int idp) {
        EProduto UserProduto = new EProduto();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cliente where idproduto=?");
            preparedStatement.setInt(1,idp );
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                
                UserProduto.setIDP(rs.getInt("idproduto"));
                UserProduto.setMarca(rs.getString("marca"));
                UserProduto.setNome(rs.getString("nome"));
                UserProduto.setDescriçao(rs.getString("descricao"));
                UserProduto.setFabricaçao(rs.getDate("fabricacao"));
                UserProduto.setValidade(rs.getDate("validade"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return UserProduto;
    }
    
}
