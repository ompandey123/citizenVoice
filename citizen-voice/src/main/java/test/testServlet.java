/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package test;

import com.mycompany.citizen.voice.resources.JakartaEE8Resource;
import ejb.AdminLocal;
import ejb.PackedObjects;
import ejb.UserLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ompan
 */
@WebServlet(name = "testServlet", urlPatterns = {"/testServlet"})
public class testServlet extends HttpServlet {
    
    
    @EJB UserLocal usll;
    @EJB AdminLocal adll;
    PackedObjects pobjs;
    
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
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet testServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
//              cc.addStates("Uttar Pradesh");
              //cc.addDistricts("2", "Surat");
              //cc.addCity("1", "Surat");
              //cc.addZone("1", "West Zone");
              //cc.addWard("1", "Abhwa Ward");
              //cc.addTaluka("1", "Chorasi");
              //cc.addVillage("1", "Abhwa");
              
             SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
              Date dt = null;
        try {
            dt = sdt.parse("10-10-2002");
        } catch (ParseException ex) {
            //Logger.getLogger(JakartaEE8Resource.class.getName()).log(Level.SEVERE, null, ex);
        }
              
              //cc.RegisterUser("Om", "omp", "om@gmail.com", "662223509284", "9723747686", "Male", "Vesu", "10-11-2002", "395007", "1", "1", "1", "1", "1", "2", "1");
              //usll.RegisterUser("admin", "admin", "admin@gmail.com", "123456789012", "9723747686", "Male", address, dt, zip_code, 0, 0, 0, 0, 0, 0, 0);
              
//             PackedObjects p = new PackedObjects();
//              Collection<Integer> stateids = new ArrayList<>();
//              stateids.add(2);
//              stateids.add(3);
//              p.setState_ids(stateids);
              //adll.addQuestion("how is life?", "state", "GOOD", "NOT GOOD", "Neutral", "PATHETIC", p);
              
//              usll.giveAnswer(10, 11, "Ok", "", "", "", 12, 523, 4612, 23, 3, 102, 35);
            out.println("<h1>Citizen voice testing Servlet");
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
        processRequest(request, response);
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
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
