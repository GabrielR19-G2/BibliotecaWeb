<%-- 
    seleccionaRevistasEliminar.jsp

    Esta página JSP permite desplegar la página para seleccionar la revista a eliminar. Forma parte de 
    la aplicación bibliotecaWeb.

    Karla Ximena Islas Cruz ID: 213090
    Gabriel Francisco Piñuelas Ramos ID: 230626
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
    <head>
        <title>Seleccionar revistas a eliminar</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css">
    </head>

    <body>
        <div class="container"> 
            <%-- Incluye el encabezado de la pagina --%>
            <%@include file="jspf/titulo.jspf"%>

            <%-- Incluye el menu de revistas --%>
            <%@include file="jspf/menuRevistas.jspf"%>

            <main>
                <h2>Eliminar revista</h2>
                <%-- Formulario para capturar las revistas a eliminar. Los isbn de las revistas se envían al servlet
                      eliminarRevistas para eliminarlas de la BD --%>
                <form action="eliminarRevistas" method="post">
                    <%-- Tabla donde se muestran los datos de todas las revistas --%>
                    <table id="lista">

                        <%-- Título de la tabla --%>
                        <caption>
                            Selecciona las revistas a eliminar
                        </caption>

                        <%-- Títulos de las columnas --%>
                        <tr>
                            <th>&nbsp;</th>
                            <th>Isbn</th>
                            <th>Título</th>
                            <th>Editorial</th>
                            <th>Clasificación</th>
                            <th>Publicidad</th>
                            <th>Fecha</th>
                        </tr>
                        
                        <%-- Despliega los datos de todas las revistas. Los datos se encuentran en 
                             el bean listaRevistas guardados en el objeto session por el servlet 
                             obtenRevistas. --%>
                        <c:forEach items="${listaRevistas.lista}" var="revista" >
                            <%-- Inserta en cada celda de una fila de la tabla uno de los atributos 
                                 de la revista  --%>
                            <tr>
                                <td><input type="checkbox" name="isbns" value="${revista.isbn}" /></td>
                                <td>${revista.isbn}</td>
                                <td>${revista.titulo}</td>
                                <td>${revista.editorial}</td>
                                <td>${revista.clasificacion}</td>
                                <td>${revista.periodicidad}</td>
                                <td>${revista.fecha}</td>
                            </tr>
                        </c:forEach> 

                    </table>
                    <br />
                    <table class="centrada" >
                        <tr>
                            <%-- Botones enviar --%>
                            <td>
                                <input type="submit" name="boton" value="Continuar" />
                            </td>
                            <%-- Botón limpiar --%>
                            <td>
                                <input type="reset" value="Limpiar" />
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
