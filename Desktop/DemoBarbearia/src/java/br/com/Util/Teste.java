/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Util;

import br.com.Entidade.ECliente;
import br.com.Persistencia.PCliente;
import java.sql.SQLException;

/**
 *
 * @author Jeferson
 */
public class Teste {
    public static void main(String[] args) throws Exception {
//      Conexao cc =new Conexao();
//      cc.getConexao();
    
    System.out.println("QUE COMECE OS TESTES....");

    System.out.println("Incluir"); 
    ECliente cl =new ECliente();
     
    cl.setNome("janeide"); cl.setCpf(335564154);
    cl.setEmail("jan@.neide.live");cl.setFone("32564798");
    cl.setEndereco("rua do incluir");
     
    PCliente pc = new PCliente();
        try {
            pc.incluirCli(cl);
     
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }System.out.println("Incluiu you Bad Motherfucker");
    
    System.out.println("Alterar");
//    ECliente cl =new ECliente();
//     
//    cl.setNome("hahahahah"); cl.setCpf(1234658790);
//    cl.setEmail("namoral@.com");cl.setFone("32892442");
//    cl.setEndereco("rua do alterar");cl.setIDC(1);
//     
//    PCliente pc = new PCliente();
//        try {
//            pc.alterarCli(cl);
//     
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }System.out.println("Alterou you Bad Motherfucker");

    
    System.out.println("Excluir");
//        ECliente cl = new ECliente();
//        cl.setIDC(2);
//        
//        PCliente pc = new PCliente();
//        try {
//            pc.excluirCli(cl);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println("Excluido you Bad Motherfucker");
//    
    
    
    }
}
