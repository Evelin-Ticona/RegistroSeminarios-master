package com.emergentes.controlador;

import com.emergentes.registroseminarios.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Apaza
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MainServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MainServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String op = request.getParameter("op");
        Persona objPer = new Persona();
        int id,pos;
        HttpSession ses = request.getSession();
        ArrayList<Persona> lista =(ArrayList<Persona>)ses.getAttribute("listaPer");
        switch(op){
                case "nuevo":
                    request.setAttribute("miobjper",objPer);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                    break;
                case "editar":
                    id = Integer.parseInt(request.getParameter("id"));
                    pos= buscarPorIndice(request,id);
                    objPer =lista.get(pos);
                    request.setAttribute("miobjper", objPer);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                    break;
                case "eliminar":
                     id = Integer.parseInt(request.getParameter("id"));
                     pos= buscarPorIndice(request,id);
                     if(pos >=0){
                         lista.remove(pos);
                     }
                     request.setAttribute("listaPer",lista);
                     response.sendRedirect("index.jsp");
                   break;
                default:
                
            }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Persona> lista =(ArrayList<Persona>)ses.getAttribute("listaPer");
        Persona objPer = new Persona();
        objPer.setId(id);
        objPer.setNombres(request.getParameter("nombres"));
        objPer.setApellidos(request.getParameter("apellidos"));
        objPer.setTurno(request.getParameter("turno"));
        objPer.setSeminarios(request.getParameter("seminarios"));
        
        if (id ==0){
            int idNuevo=obtenerId(request);
            objPer.setId(idNuevo);
            lista.add(objPer);
            
        }else{
            int pos = buscarPorIndice(request,id);
            lista.set(pos,objPer);
        }
        request.setAttribute("listaPer",lista);
        response.sendRedirect("index.jsp");
    }
    
    public int buscarPorIndice(HttpServletRequest request, int id){
        HttpSession ses = request.getSession();
        ArrayList<Persona> lista =(ArrayList<Persona>)ses.getAttribute("listaPer");
        int pos=1;
        if(lista !=null){
            for(Persona ele : lista){
                break;
            }
        }
        return pos;    
    }
    
    public int obtenerId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Persona> lista =(ArrayList<Persona>)ses.getAttribute("listaPer");
        int idn=0;
        if(lista !=null){
            for(Persona ele : lista){
                idn=ele.getId();
            }
        }
        return idn+1;
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}