package acciones;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Clase control
 *
 * @author xmnislas, Gabriel Piñuelas
 */
public class Control extends HttpServlet {

    /**
     * Procesa las solicitudes para ambos metodos HTTP: GET y POST.
     *
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obten de la solicitud, la tarea seleccionada del menú de revistas
        String tareaSeleccionada = request.getParameter("tarea");

        // Obten el objeto session que contiene a las variables con ámbito de sesion
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        String siguiente = null;

        // Guarda en la variable de sesion tareaSeleccionada, la tarea seleccionada
        session.setAttribute("tareaSeleccionada", tareaSeleccionada);

        // establece la pagina JSP o servlet que inicia el caso de uso seleccionado
        switch (tareaSeleccionada) {
            case "agregarRevista":
                siguiente = "capturaIsbn.jsp";
                break;
            case "actualizarRevista":
                siguiente = "obtenRevistas";
                break;
            case "eliminarRevistas":
                siguiente = "obtenRevistas";
                break;
            case "listarRevistas":
                siguiente = "despliegaRevistas.jsp";
                break;
            default:
                break;
        }

        // Redirecciona a la página JSP siguiente
        request.getRequestDispatcher(siguiente).forward(request, response);

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
        return "Servlet de control";
    }// </editor-fold>
}
