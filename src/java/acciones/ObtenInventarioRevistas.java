package acciones;

import interfaces.IPersistencia;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetosNegocio.Revista;
import objetosTransferencia.Lista;
import persistencia.PersistenciaBD;

/**
 * Esta página .java permite agregar/inventariar revistas a la biblioteca. Karla
 * Ximena Islas Cruz ID: 213090 Gabriel Francisco Piñuelas Ramos ID: 230626
 *
 * @author Ximena Islas, Gabriel Piñuelas
 */
public class ObtenInventarioRevistas {

    /**
     * Procesa las solicitudes para ambos metodos HTTP: GET y POST.
     *
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException Si ocuurre un error especifico del servlet.
     * @throws IOException Si ocuurre un error de E/S
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        String siguiente = null;

        // Obten el objeto session que contiene a las variables con ámbito de sesion
        HttpSession session = request.getSession();

        // Obten la tarea seleccionada del atributo tareaSel de la variable session
        String tareaSel = (String) session.getAttribute("tareaSel");

        // Crea el objeto para acceder a la base de datos
        IPersistencia fachada = new PersistenciaBD();

        // Obtiene la lista de canciones del catalogo de canciones
        ArrayList<Revista> lista = fachada.consultarRevistas();

        // En este bean de tipo Lista, se almacena la lista de
        // canciones leídas de la tabla canciones de la base de datos musica
        Lista listaRevista = new Lista("Lista de todas las Revistas", lista);

        // Se requiere guardar en ambito de sesión por que se va a ocupar
        // en la solicitud de correccion de falla de validacion del lado
        // del servidor
        session.setAttribute("ListaRevistas", listaRevista);

        switch (tareaSel) {
            case "actualizaRevista":
                siguiente = "seleccionaRevistasActualizar.jsp";
                break;
            case "eliminarRevista":
                siguiente = "seleccionaRevistasEliminar.jsp";
                break;
            case "listarRevista":
                siguiente = "despliegaRevista.jsp";
                break;
        }

        // Establece la página JSP o servlet siguiente
        rd = request.getRequestDispatcher(siguiente);
        // Redirecciona a la página JSP o servlet siguiente
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Maneja el método HTTP: GET.
     *
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException Si ocuurre un error especifico del servlet.
     * @throws IOException Si ocuurre un error de E/S
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Maneja el método HTTP: POST.
     *
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException Si ocuurre un error especifico del servlet.
     * @throws IOException Si ocuurre un error de E/S
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Regresa una descripcion breve del servlet.
     *
     * @return Descripcion breve del servlet.
     */
    public String getServletInfo() {
        return "Servlet que obtiene la lista de canciones del catalogo de canciones";
    }
}
