<%-- 
    despliegaRevistas.jsp

    Esta página JSP permite desplegar la información de todas las revistas. Forma parte de 
    la aplicación bibliotecaWeb.

    Karla Ximena Islas Cruz ID: 213090
    Gabriel Francisco Piñuelas Ramos ID: 230626
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

<!DOCTYPE html>
<html>
    <head>
        <title>Despliega revistas</title>
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
                <h2>Consultar revistas</h2>
                <%-- Despliega los datos de todas las revistas. Los datos se encuentran en el bean 
                     listaRevistas guardados en el objeto session por el servlet obtenCanciones.
                --%>
                <table id="lista">

                    <%-- Título de la tabla --%>
                    <caption>
                        ${listaRevistas.tituloTabla}
                    </caption>

                    <tr>
                        <%-- Títulos de las columnas --%>
                        <th>Isbn</th>
                        <th>Título</th>
                        <th>Editorial</th>
                        <th>Clasificación</th>
                        <th>Publicidad</th>
                        <th>Fecha</th>
                    </tr>

                    <c:forEach items="${listaRevistas.lista}" var="revista">
                        <tr>
                            <td>${revista.isbn}</td>
                            <td>${revista.titulo}</td>
                            <td>${revista.editorial}</td>
                            <td>${revista.clasificacion}</td>
                            <td>${revista.periodicidad}</td>
                            <td>${revista.fecha}</td>
                        </tr>
                    </c:forEach>
                </table>
            </main>

            <%-- Incluye el pie de pagina --%>
            <%@include file="jspf/piePagina.jspf"%>
        </div>
    </body>
</html>
