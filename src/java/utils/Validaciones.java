/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import objetosTransferencia.Mensaje;

/**
 *
 * @author xmnislas
 */
public class Validaciones {
    
    public Map<String, Mensaje> validaIsbnRevista(HttpServletRequest request) {
        Map<String, Mensaje> mensajes = new HashMap<>();
        Valida valida = new Valida();
        Mensaje mensaje;
        
        String isbn = request.getParameter("isbn");
        if (valida.cadenaVacia(isbn)) {
            mensaje = new Mensaje("Error: Ingrese el isbn", "msjError");
            mensajes.put("isbn", mensaje);
        } else if (!valida.validaIsbn(isbn)) {
            mensaje = new Mensaje("Error: Isbn inválido", "msjError");
            mensajes.put("isbn", mensaje);
        }
        return mensajes;
    }
    
    public Map<String, Mensaje> validaRevista(HttpServletRequest request) {
        Map<String, Mensaje> mensajes = new HashMap<>();
        Valida valida = new Valida();
        Mensaje mensaje;

        String titulo = request.getParameter("titulo");
        if (valida.cadenaVacia(titulo)) {
            mensaje = new Mensaje("Error: Ingrese el título", "msjError");
            mensajes.put("titulo", mensaje);
        } else if (!valida.validaCadena(50, titulo)) {
            mensaje = new Mensaje("Error: Título muy largo", "msjError");
            mensajes.put("titulo", mensaje);
        }

        String clasificacion = request.getParameter("clasificacion");
        if (valida.cadenaVacia(clasificacion)) {
            mensaje = new Mensaje("Error: Ingrese la clasificación", "msjError");
            mensajes.put("clasificacion", mensaje);
        } else if (!valida.validaCadena(20, clasificacion)) {
            mensaje = new Mensaje("Error: Clasificación muy larga", "msjError");
            mensajes.put("clasificacion", mensaje);
        }

        String editorial = request.getParameter("editorial");
        if (!valida.cadenaVacia(editorial)) {
            if (!valida.validaCadena(35, editorial)) {
                mensaje = new Mensaje("Error: Editorial muy larga", "msjError");
                mensajes.put("editorial", mensaje);
            }
        }
        
        String periodicidad = request.getParameter("periodicidad");
        if (!valida.cadenaVacia(periodicidad)) {
            if (!valida.validaCadena(20, periodicidad)) {
                mensaje = new Mensaje("Error: Periodicidad muy larga", "msjError");
                mensajes.put("periodicidad", mensaje);
            }
        }

        String fecha = request.getParameter("fecha");
        if (!valida.cadenaVacia(fecha)) {
            if (!valida.validaFecha(fecha)) {
                mensaje = new Mensaje("Error: Fecha inválida", "msjError");
                mensajes.put("fecha", mensaje);
            }
        }
        return mensajes;
    }
}
