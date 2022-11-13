/*
 *  Este servlet elimina de la BD las revistas seleccionadas.
 *
 *  Karla Ximena Islas Cruz ID: 213090
 *  Gabriel Francisco Piñuelas Ramos ID: 230626
 */
package acciones;

import interfaces.IPersistencia;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetosNegocio.Revista;
import objetosTransferencia.Mensaje;
import persistencia.PersistenciaBD;

public class EliminarRevistas extends HttpServlet {

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

        // Obten la lista de isbns de las revistas a eliminar
        String isbns[] = (String[]) request.getParameterValues("isbns");

        if (isbns == null) {

            Map<String, Mensaje> mensajes = new HashMap<>();
            Mensaje mensaje;

            // crea mensaje de error
            mensaje = new Mensaje("Error: No se seleccionaron revistas para eliminar", "msjError");

            // Agrega el mensaje de error a la lista de errores
            mensajes.put("revistas", mensaje);

            // Crea la variable de solicitud mensajes, con los mensajes de error
            request.setAttribute("mensajes", mensajes);

            // Establece que la página siguiente es seleccionaRevistasEliminar.jsp
            rd = request.getRequestDispatcher("seleccionaRevistasEliminar.jsp");

        } else {
            // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();

            for (String isbn : isbns) {
                // Elimina la revista del catálogo
                fachada.eliminar(new Revista(isbn));
            }

            // Obten el objeto session que contiene a las variables con ámbito de sesion
            HttpSession session = request.getSession();

            // Guarda en la variable de sesión tareaSeleccionada, la tarea a realizar
            session.setAttribute("tareaSeleccionada", "listarRevistas");

            rd = request.getRequestDispatcher("obtenRevistas");

        }
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * <<<<<<< HEAD Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs ======= Maneja el método HTTP:
     * GET.
     *
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException Si ocuurre un error especifico del servlet.
     * @throws IOException Si ocuurre un error de E/S >>>>>>>
     * ae1588af4b45a62c8cb2266864c187cc9857e2e3
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * <<<<<<< HEAD Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs ======= Maneja el método HTTP:
     * POST.
     *
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException Si ocuurre un error especifico del servlet.
     * @throws IOException Si ocuurre un error de E/S >>>>>>>
     * ae1588af4b45a62c8cb2266864c187cc9857e2e3
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * <<<<<<< HEAD Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
