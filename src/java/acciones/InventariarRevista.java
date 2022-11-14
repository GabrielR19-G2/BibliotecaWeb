package acciones;

import interfaces.IPersistencia;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetosNegocio.Revista;
import objetosTransferencia.Mensaje;
import persistencia.PersistenciaBD;
import utils.Validaciones;

/**
 * Esta página .java permite agregar/inventariar revistas a la biblioteca. Karla
 * Ximena Islas Cruz ID: 213090 Gabriel Francisco Piñuelas Ramos ID: 230626
 *
 * @author Ximena Islas, Gabriel Piñuelas
 */
public class InventariarRevista {

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

        // Valida los datos de la revista
        Map<String, Mensaje> mensajes = validaciones.validaRevista(request);

        // Si la validación falla
        if (!mensajes.isEmpty()) {
            request.setAttribute("mensajes", mensajes);

            // Establece que la página siguiente es capturaRevista.jsp
            rd = request.getRequestDispatcher("capturaRevista.jsp");
        } else {
            // En este bean de tipo Revista, se almacenan los atributos de una
            //  revista enviada por la página capturaRevista.jsp.
            Revista revista = new Revista();
            String campo;

            // Obtiene de la solicitud los datos de una revista y los guarda al bean revista
            revista.setIsbn((String) request.getParameter("isbn"));
            revista.setTitulo((String) request.getParameter("titulo"));
            revista.setClasificacion((String) request.getParameter("clasificacion"));
            //revista.setFecha(fecha);

            campo = request.getParameter("editorial");
            if (!campo.equals("")) {
                revista.setEditorial(campo);
            } else {
                revista.setEditorial(null);
            }
            
            campo = request.getParameter("clasificacion");
            if (!campo.equals("")) {
                revista.setClasificacion(campo);
            } else {
                revista.setClasificacion(null);
            }
            
            campo = request.getParameter("periodicidad");
            if (!campo.equals("")) {
                revista.setPeriodicidad(campo);
            } else {
                revista.setPeriodicidad(null);
            }

            // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();

            // Agrega la nueva canción al catálogo de canciones
            fachada.agregar(revista);

            // Obten el objeto session que contiene a las variables con ámbito de sesion
            HttpSession session = request.getSession();

            // Guarda en la variable de sesión tareaSel, la tarea arealizar
            session.setAttribute("tareaSeleccionada", "listarRevistas");

            // Establece la página JSP o servlet siguiente
            rd = request.getRequestDispatcher("obtenRevistas");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }
}
