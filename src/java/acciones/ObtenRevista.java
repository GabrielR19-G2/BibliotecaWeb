/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package acciones;

import interfaces.IPersistencia;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetosNegocio.Revista;
import objetosTransferencia.Mensaje;
import persistencia.PersistenciaBD;
import utils.Validaciones;

/**
 *
 * @author xmnislas
 */
@WebServlet(name = "obtenRevista", urlPatterns = {"/obtenRevista"})
public class ObtenRevista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        String siguiente = "";
        Validaciones validaciones = new Validaciones();

        // valida la clave de la revista
        Map<String, Mensaje> mensajes  = validaciones.validaIsbnRevista(request);

        // Si la validación falla
        if (!mensajes.isEmpty()) {
            // Crea la variable de solicitud mensajes, con los mensajes de error
            request.setAttribute("mensajes", mensajes);

            // Establece que la página siguiente es capturaIsbn.jsp
            rd = request.getRequestDispatcher("capturaIsbn.jsp");
        } else {

            // Obten el objeto session que contiene a las variables con ámbito de sesion
            HttpSession session = request.getSession();
            
            // Obten de la variable de sesion tareaSeleccionada, la tarea seleccionada
            String tareaSeleccionada = (String) session.getAttribute("tareaSeleccionada");

            // Obten el isbn de la revista enviada por la página capturaIsbn.jsp
            // o por la página seleccionaRevistaActualizar.jsp
            String isbn = (String) request.getParameter("isbn");

            // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();

            // Busca la cancion en el catalogo de revistas
            Revista revista = fachada.obten(new Revista(isbn));

            // Si la revista existe en el catalogo de revistas
            if (revista != null) {
                // Crea la variable de solicitud revista, con la revista existente
                request.setAttribute("revista", revista);

                siguiente = "despliegaRevista.jsp";
            }else {
                siguiente = "capturaRevista.jsp";
            }
          
            // Establece la página JSP o servlet siguiente
            rd = request.getRequestDispatcher(siguiente);
        }
        // Redirecciona a la página JSP o servlet siguiente
        rd.forward(request, response);
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
