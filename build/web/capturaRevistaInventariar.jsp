<%-- 
    capturaRevistaInventariar.jsp

    Esta página JSP permite inventariar una revista. Forma parte de 
    la aplicación bibliotecaWeb.

    Karla Ximena Islas Cruz ID: 213090
    Gabriel Francisco Piñuelas Ramos ID: 230626
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css">
        <title>Inventariar revista</title>        
    </head>
    <body>
        <div class="container">

            <%-- Incluye el encabezado del titulo de la pagina --%>
            <%@include file="jspf/titulo.jspf"%>

            <%-- Incluye el menu principal --%>
            <%@include file="jspf/menuInventario.jspf"%>

            <main>
                <h2>Inventariar revista</h2>
                <%-- Formulario para capturar los atributos de una revista.
                     Los datos se envían al servlet agregaRevista para
                     guardarlos en la BD --%>
                <form action="inventariarRevista" method="post" name="capturaRevista" >
                    <div class="contenedorFormulario">
                        <div class="derecha">
                            <label class="derecha">Seleccionar revista *</label>
                            <select name="revistas">
                                <option value="">..</option>
                                <option value="Vogue">Vogue</option>
                                <option value="Deportes">Deporte internacional</option>
                            </select>
                        </div>    
                        <div>&nbsp;</div>
                        <div>&nbsp;</div>

                        <div class="derecha"> 
                            <label class="derecha">Ingrese cantidad revista</label>
                            <input type="number" id="cantidad" name="cantidadRevista" required
                                   placeholder="Cantidad revista"/>
                        </div>

                    </div>
                    <br>
                    <table class="centrada">
                        <tr>
                            <%--Boton enviar --%>
                            <td>
                                <input type="submit" name="boton" value="Enviar">
                            </td>
                            <%--Botón limpiar --%>
                            <td>
                                <input type="reset" value ="Limpiar">
                            </td>
                        </tr>
                    </table>
                </form>
            </main>

            <%-- Incluye el pie de pagina --%>
            <%@include file="jspf/piePagina.jspf"%>
        </div>
    </body>
</html>
