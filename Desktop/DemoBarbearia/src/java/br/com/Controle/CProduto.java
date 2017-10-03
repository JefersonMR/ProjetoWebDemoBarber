/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controle;


import br.com.Entidade.EProduto;
import br.com.Persistencia.PProduto;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeferson
 */
public class CProduto extends HttpServlet{
  
 private static final long SerialVersionUID = 1L;
  private final PProduto persistencia;
  private static String INSERIR_OU_EDITAR = "/Produto.jsp";
  private static String LISTA_USUARIOS = "/TabelaProduto.jsp";  
 
  public CProduto(){
     super();
     persistencia= new PProduto();
     
 }      
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String forward="";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("deletar")){
            int idp = Integer.parseInt(request.getParameter("idProduto"));
           try {
               persistencia.excluirPro(idp);
               forward = LISTA_USUARIOS;
               request.setAttribute("produtos", persistencia.listarPro(action));
           } catch (Exception ex) {
               Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else if (action.equalsIgnoreCase("editar")){
            forward = INSERIR_OU_EDITAR;
            int idc = Integer.parseInt(request.getParameter("idProduto"));
            EProduto sr= persistencia.consultarCli(idc);
            request.setAttribute("dp", sr);
        } else if (action.equalsIgnoreCase("TabelaProduto")){
            forward = LISTA_USUARIOS;
            request.setAttribute("produtos", persistencia.listarPro(action));
        } else {
            forward = INSERIR_OU_EDITAR;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }  

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EProduto sr = new EProduto();
        
        sr.setMarca(request.getParameter("marca"));
        sr.setNome(request.getParameter("nome"));
        sr.setDescriçao(request.getParameter("descricao"));
        try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("fabricacao"));
            sr.setFabricaçao(dob);
            Date dob2 = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("validade"));
            sr.setFabricaçao(dob2);    
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String id = request.getParameter("id");
        if(id == null || id.isEmpty())
        {
            
            try {
                persistencia.incluirPro(sr);
            } catch (Exception ex) {
                Logger.getLogger(CProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
        {
            sr.setIDP(Integer.parseInt(id));
            
            try {
                persistencia.alterarPro(sr);
            } catch (Exception ex) {
                Logger.getLogger(CProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_USUARIOS);
        request.setAttribute("produtos", persistencia.listarPro(LISTA_USUARIOS));
        view.forward(request, response);
    }
    
}

