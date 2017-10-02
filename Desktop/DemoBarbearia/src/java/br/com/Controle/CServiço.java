/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controle;


import br.com.Entidade.EServiço;
import br.com.Persistencia.PServiço;
import java.io.IOException;
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
public class CServiço extends HttpServlet{
private static final long SerialVersionUID = 1L;
  private final PServiço persistencia;
  private static String INSERIR_OU_EDITAR = "/Servico.jsp";
  private static String LISTA_USUARIOS = "/TabelaServico.jsp";      

public CServiço(){
super();
persistencia=new PServiço();
}

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    String forward="";
    String action=request.getParameter("action");

if (action.equalsIgnoreCase("deletar")){
            int ids = Integer.parseInt(request.getParameter("idServico"));
           try {
               persistencia.deleteSer(ids);
               forward = LISTA_USUARIOS;
               request.setAttribute("servicos", persistencia.listarSer(action));
           } catch (Exception ex) {
               Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else if (action.equalsIgnoreCase("editar")){
            forward = INSERIR_OU_EDITAR;
            int ids = Integer.parseInt(request.getParameter("idServico"));
            EServiço sr= persistencia.consultarSer(ids);
            request.setAttribute("d", sr);
        } else if (action.equalsIgnoreCase("TabelaServico")){
            forward = LISTA_USUARIOS;
            request.setAttribute("servicos", persistencia.listarSer(action));
        } else {
            forward = INSERIR_OU_EDITAR;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
   EServiço sr =new EServiço();
   sr.setNome(request.getParameter("nome"));
   sr.setDescriçao(request.getParameter("descricao"));
   sr.setProfissional(request.getParameter("profissional"));
   sr.setTempo(request.getParameter("tempo"));
   String valor=request.getParameter("valor");
   sr.setValor(Double.parseDouble(valor));
    
   String id =request.getParameter("id");
   if(id==null||id.isEmpty()){
      
       try {
           persistencia.incluirSer(sr);
       } catch (Exception ex) {
           Logger.getLogger(CServiço.class.getName()).log(Level.SEVERE, null, ex);
       }
   }else{
       sr.setIDS(Integer.parseInt(id));
       
       try {
           persistencia.alterarSer(sr);
       } catch (Exception ex) {
           Logger.getLogger(CServiço.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
        RequestDispatcher view = request.getRequestDispatcher(LISTA_USUARIOS);
        request.setAttribute("servicos", persistencia.listarSer(LISTA_USUARIOS));
        view.forward(request, response);
}


}






















