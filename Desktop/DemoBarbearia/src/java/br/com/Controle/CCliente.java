/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controle;

import br.com.Entidade.ECliente;
import br.com.Persistencia.PCliente;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeferson
 */

public class CCliente extends HttpServlet{
  private static final long SerialVersionUID = 1L;
  private PCliente persistencia;
  private static String INSERIR_OU_EDITAR = "/Cliente.jsp";
  private static String LISTA_USUARIOS = "/TabelaCliente.jsp";  
 
  public CCliente(){
     super();
     persistencia= new PCliente();
     
 }   
    
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String forward="";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("deletar")){
            int idc = Integer.parseInt(request.getParameter("idCliente"));
           try {
               persistencia.excluirCli(idc);
           } catch (Exception ex) {
               Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else if (action.equalsIgnoreCase("editar")){
            forward = INSERIR_OU_EDITAR;
            int idc = Integer.parseInt(request.getParameter("idCliente"));
            ECliente sr= persistencia.consultarCli(idc);
            request.setAttribute("d", sr);
        } else if (action.equalsIgnoreCase("TabelaCliente")){
            forward = LISTA_USUARIOS;
            request.setAttribute("clientes", persistencia.listarCli());
        } else {
            forward = INSERIR_OU_EDITAR;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ECliente sr = new ECliente();
        
        sr.setCpf(request.getParameter("cpfCliente"));
        sr.setNome(request.getParameter("nomeCliente"));
        sr.setEndereco(request.getParameter("endereçoCliente"));
        sr.setFone(request.getParameter("foneCliente"));
        sr.setEmail(request.getParameter("emailCliente"));
        
        String id = request.getParameter("idCliente");
        if(id == null || id.isEmpty())
        {
            try {
                persistencia.incluirCli(sr);
            } catch (Exception ex) {
                Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            sr.setIDC(Integer.parseInt(id));
            try {
                persistencia.alterarCli(sr);
            } catch (Exception ex) {
                Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_USUARIOS);
        request.setAttribute("clientes", persistencia.listarCli());
        view.forward(request, response);
    }
    
    }    
    


