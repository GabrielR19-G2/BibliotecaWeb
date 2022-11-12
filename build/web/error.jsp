<%-- 
    error.jsp
    
    Esta página JSP permite desplegar los mensajes de error de la aplicación bibliotecaWeb.

    Karla Ximena Islas Cruz ID: 213090
    Gabriel Francisco Piñuelas Ramos ID: 230626
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de error</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
    </head>
    <body>
        <div class="container">
            <%-- Incluye el encabezado de la página--%>
            <%@include file="jspf/titulo.jspf"%>

            <%-- Incluye el menu de revistas --%>
            <%@include file="jspf/menuRevistas.jspf"%>

            <main>
                <h1>Error!</h1>
                <br>
                <table class="centrada">
                    <tr>
                        <th class="error">Error:</th>
                        <td>${pageContext.exception.message}</td>
                    </tr>
                </table>
            </main>

            <%-- Incluye el pie de pagina --%>
            <%@include file="jspf/piePagina.jspf"%>
        </div>
    </body>
</html>
