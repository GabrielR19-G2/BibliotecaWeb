<%-- 
    despliegaRevista.jsp

    Esta página JSP permite desplegar la información de una revista. Forma parte de 
    la aplicación bibliotecaWeb.

    Karla Ximena Islas Cruz ID: 213090
    Gabriel Francisco Piñuelas Ramos ID: 230626
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Despliega revista</title>
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
                <h1>Revista Existente</h1>

                <%-- Despliega los datos de la revista. Los datos se encuentran
                     en el bean revista guardados en el objeto request por el
                     servlet obtenRevista. --%>
                <table class="centrada">
                    <tr>
                        <td class="derecha">Isbn</td>
                        <td class="gris">${revista.isbn}</td>
                    <tr>
                        <td class="derecha">T&iacute;tulo</td>
                        <td class="gris">${revista.titulo}</td>
                    </tr>
                    <tr>
                        <td class="derecha">Editorial</td>
                        <td class="gris">${revista.editorial}</td>
                    </tr>
                    <tr>
                        <td class="derecha">Clasificaci&oacute;n</td>
                       <td class="gris">${revista.clasificacion}</td>
                    </tr>
                    <tr>
                        <td class="derecha">Periodicidad</td>
                       <td class="gris">${revista.periodicidad}</td>
                    </tr>
                    <tr>
                        <td class="derecha">Fecha</td>
                        <td class="gris">${cancion.fecha}</td>
                    </tr>
                </table>
            </main>

            <%-- Incluye el pie de pagina --%>
            <%@include file="jspf/piePagina.jspf"%>
        </div>
    </body>
</html>
