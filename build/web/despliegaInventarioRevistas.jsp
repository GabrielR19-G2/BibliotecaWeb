<%-- 
    despliegaInventarioRevistas.jsp

    Esta página JSP permite desplegar una tabla con el inventario de revistas. Forma parte de 
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
        <title>Inventario Revistas</title>
    </head>
    <body>
        <div class="container"> 
            <%-- Incluye el encabezado de la pagina --%>
            <%@include file="jspf/titulo.jspf"%>

            <%-- Incluye el menu de revistas --%>
            <%@include file="jspf/menuInventario.jspf"%>

            <main>
                <h2>Inventario revistas</h2>
                <%-- Despliega los datos de todas las revistas. Los datos se encuentran en el bean 
                     listaRevistas guardados en el objeto session por el servlet obtenCanciones.
                --%>
                <table id="lista" class="centrada">
                    <%-- Título de la tabla --%>
                    <caption>
                       
                    </caption>

                    <tr>
                        <%-- Títulos de las columnas --%>
                        <th>Isbn</th>
                        <th>Título</th>
                        <th>Editorial</th>
                        <th>Clasificación</th>
                        <th>Periodicidad</th>
                        <th>Fecha</th>
                        <th>Cantidad</th>
                    </tr>

                    <tr>
                        <td>0986453456325</td>
                        <td>Harry Potter</td>
                        <td>Salamandra</td>
                        <td>A</td>
                        <td>2002</td>
                        <td>13/06/10</td>
                        <td>6</td>
                    </tr>
                    <tr>
                        <td>010722957445</td>
                        <td>Deporte internacional</td>
                        <td>Televisa</td>
                        <td>A</td>
                        <td>Mensual</td>
                        <td>2001</td>
                        <td>8</td>
                    </tr>

                    <%-- <c:forEach items="${listaRevistas.lista}" var="revista">
                         <tr>
                             <td>${revista.isbn}</td>
                             <td>${revista.titulo}</td>
                             <td>${revista.editorial}</td>
                             <td>${revista.clasificacion}</td>
                             <td>${revista.periodicidad}</td>
                             <td>${revista.fecha}</td>
                         </tr>
                     </c:forEach> --%>
                    
                </table>
            </main>

            <%-- Incluye el pie de pagina --%>
            <%@include file="jspf/piePagina.jspf"%>
        </div>

    </body>
</html>
