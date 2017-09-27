/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Util;

import br.com.Entidade.EServiço;
import br.com.Persistencia.PServiço;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeferson
 */
public class TesteServiço {
    public static void main(String[] args) throws Exception {
        
        
        //Conexao cc =new Conexao();
       //cc.getConexao();
    
    System.out.println("QUE COMECE OS TESTES....");

      System.out.println("Incluir"); 
//        EServiço sr =new EServiço();
//     
//    sr.setNome("Alisamento"); sr.setDescriçao("alisa o cabelo idiota");
//    sr.setProfissional("Crô"); sr.setTempo("30 min");
//    sr.setValor(50.00);
//     
//    PServiço psr = new PServiço();
//        try {
//            psr.incluirSer(sr);
//     
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }System.out.println("Incluiu you Bad Motherfucker");
//    
      System.out.println("Alterar");
//        EServiço sr =new EServiço();
//     
//    sr.setNome("Barba"); sr.setDescriçao("Corta o barba idiota");
//    sr.setProfissional("Jubileu"); sr.setTempo("20 min");
//    sr.setValor(20.00);sr.setIDS(1);
//     
//    PServiço psr = new PServiço();
//        try {
//            psr.alterarSer(sr);
//     
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }System.out.println("Incluiu you Bad Motherfucker");
//
    
    System.out.println("Excluir");
//        EServiço sr = new EServiço();
//        sr.setIDS(1);
//        
//        PServiço psr = new PServiço();
//        try {
//            psr.deleteSer(sr);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println("Excluido you Bad Motherfucker");


          System.out.println("Listando");
      
        PServiço per = new PServiço();
        List<EServiço> lista = new ArrayList<>();
        try {
            
        lista = per.listarSer();
        } catch (Exception e) {
        }
        
        for (EServiço tipo : lista) {
            System.out.println("Código........: " + tipo.getIDS());
            System.out.println("Nome..........: " + tipo.getNome());
            System.out.println("Descrisção....: " + tipo.getDescriçao());
            System.out.println("Profissional..:"+tipo.getProfissional());
            System.out.println("Tempo.........:"+tipo.getTempo());
            System.out.println("Valor.........:"+tipo.getValor());
             }    
         System.out.println("Listagem finalizada!");
        
        
        
    }
 
}
