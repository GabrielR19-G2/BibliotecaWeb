/*
 *  Este servlet actualiza una revista de la BD.
 *
 *  Karla Ximena Islas Cruz ID: 213090
 *  Gabriel Francisco Piñuelas Ramos ID: 230626
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
import objetosServicio.Fecha;
import objetosTransferencia.Mensaje;
import persistencia.PersistenciaBD;
import utils.Validaciones;

@WebServlet(name = "actualizarRevista", urlPatterns = {"/actualizarRevista"})
public class ActualizarRevista extends HttpServlet {

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
        Validaciones validaciones = new Validaciones();
        String campo;

        // valida los datos de la revista
        Map<String, Mensaje> mensajes = validaciones.validaRevista(request);

        // Si la validación falla
        if (!mensajes.isEmpty()) {
            // Crea la variable de solicitud mensajes, con los mensajes de error
            request.setAttribute("mensajes", mensajes);

            // Redirecciona a la pagina JSP editaRevista.jsp
            rd = request.getRequestDispatcher("editaRevista.jsp");
        } else {
            Revista revista = new Revista();

            // Llena el bean revista con los datos capturados en la página editaRevista.jsp
            revista.setIsbn((String) request.getParameter("isbn"));
            revista.setTitulo((String) request.getParameter("titulo"));
            revista.setClasificacion((String) request.getParameter("clasificacion"));
            
            campo = request.getParameter("editorial");
            if(!campo.equals(""))
                revista.setEditorial(campo);
            else 
                revista.setEditorial(null);
            
            campo = request.getParameter("periodicidad");
            if(!campo.equals(""))
                revista.setPeriodicidad(campo);
            else 
                revista.setPeriodicidad(null);
            
            campo = request.getParameter("fecha");
            if(!campo.equals(""))
                revista.setFecha(new Fecha(campo));
            else 
                revista.setFecha(null);
            
            // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();

            // Actualiza la revista en el catálogo
            fachada.actualizar(revista);

            // Obten el objeto session que contiene a las variables con ámbito de sesion
            HttpSession session = request.getSession();

            // Guarda en la variable de sesión tareaSel, la tarea arealizar
            session.setAttribute("tareaSeleccionada", "listarRevistas");

            rd = request.getRequestDispatcher("obtenRevistas");
        }
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
