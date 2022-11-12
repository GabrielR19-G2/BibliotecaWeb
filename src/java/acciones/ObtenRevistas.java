/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package acciones;

import interfaces.IPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetosNegocio.Revista;
import objetosTransferencia.Lista;
import persistencia.PersistenciaBD;

/**
 *
 * @author xmnislas
 */
public class ObtenRevistas extends HttpServlet {

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
        String siguiente = null;

        // Obten el objeto session que contiene a las variables con ámbito de sesion
        HttpSession session = request.getSession();

        // Obten la tarea seleccionada del atributo tareaSel de la variable session
        String tareaSeleccionada = (String) session.getAttribute("tareaSeleccionada");

        // Crea el objeto para acceder a la base de datos
        IPersistencia fachada = new PersistenciaBD();

        // Obtiene la lista de revistas del catalogo de revistas
        ArrayList<Revista> lista = fachada.consultarRevistas();

        // En este bean de tipo Lista, se almacena la lista de
        // revistas leídas de la tabla catalogoRevistas de la base de datos biblioteca
        Lista listaRevistas = new Lista("Lista de todas las Revistas", lista);

        // Se requiere guardar en ambito de sesión por que se va a ocupar
        // en la solicitud de correccion de falla de validacion del lado
        // del servidor
        session.setAttribute("listaRevistas", listaRevistas);

        switch (tareaSeleccionada) {
            case "actualizarRevista":
                siguiente = "seleccionaRevistaActualizar.jsp";
                break;
            case "eliminarRevistas":
                siguiente = "seleccionaRevistasEliminar.jsp";
                break;
            case "listarRevistas":
                siguiente = "despliegaRevistas.jsp";
                break;
        }

        // Establece la página JSP o servlet siguiente
        rd = request.getRequestDispatcher(siguiente);
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
        return "Servlet que obtiene la lista de revistas del catalogo de revistas";
    }// </editor-fold>

}
