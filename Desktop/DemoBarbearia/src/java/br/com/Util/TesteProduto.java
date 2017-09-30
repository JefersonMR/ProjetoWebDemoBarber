/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Util;

import br.com.Entidade.EProduto;
import br.com.Persistencia.PProduto;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Jeferson
 */
public class TesteProduto {
    public static void main(String[] args) throws Exception {
        
        //      Conexao cc =new Conexao();
//      cc.getConexao();
    
    System.out.println("QUE COMECE OS TESTES....");

    System.out.println("Incluir"); 
        EProduto pr =new EProduto();
     
    pr.setMarca("pacu"); pr.setNome("xampu");
    pr.setDescriçao("sabão pro cu ");
    
     
    PProduto pp = new PProduto();
        try {
            pp.incluirPro(pr);
     
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }System.out.println("Incluiu you Bad Motherfucker");
    
      System.out.println("Alterar");
//    EProduto pr =new EProduto();
//     
//    pr.setMarca("Dubom"); pr.setNome("Creme de Barbear");
//    pr.setDescriçao("Espuma espumante para a barba"); pr.setFabricaçao.getDate(12/05/2011);
//    pr.setValidade.getDate(12/05/2011);
//     
//    PProduto pp = new PProduto();
//        try {
//            pp.alterarPro(pr);
//     
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }System.out.println("Alterou you Bad Motherfucker");

    
    System.out.println("Excluir");
//        EProduto pr = new EProduto();
//        pr.setIDP(2);
//        
//        PProduto pp = new PProduto();
//        try {
//            pp.excluirPro(pr);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println("Excluido you Bad Motherfucker");
//    
    }
}
