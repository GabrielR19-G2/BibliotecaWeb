<%-- 
    seleccionaRevistaActualizar.jsp

    Esta página JSP permite desplegar la página para seleccionar la revista a actualizar. Forma parte de 
    la aplicación bibliotecaWeb.

    Karla Ximena Islas Cruz ID: 213090
    Gabriel Francisco Piñuelas Ramos ID: 230626
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   --%>

<!DOCTYPE html>
<html>
    <head>
        <title>Seleccionar revista a actualizar</title>
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
                <h2>Actualizar revista</h2>

                <%-- Formulario para capturar una revista a actualizar. El isbn de la revista 
                     se envía al servlet obtenRevista para obtener la revista de la BD --%>
                <form action="obtenRevistaEditar" method="post">
                    <%-- Tabla donde se muestran los datos de todas las revistas --%>
                    <table id="lista">

                        <%-- Título de la tabla --%>
                        <caption>
                            Selecciona la revista a actualizar
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

                        <tr>
                            <td><input type="radio" name="isbn" value="${revista.isbn}" /></td>
                            <td>0986453456325</td>
                            <td>Harry Potter</td>
                            <td>Salamandra</td>
                            <td>A</td>
                            <td>2002</td>
                            <td>13/06/10</td>
                        </tr>

                        <%-- Despliega los datos de todas las revistas. Los datos se encuentran en 
                             el bean listaRevistas guardados en el objeto session por el servlet 
                             obtenRevistas. --%>

                        <%-- <c:forEach items="${listaRevistas.lista}" var="revista" >
                        <%-- Inserta en cada celda de una fila de la tabla uno de los atributos 
                             de la canción revista 
                        <tr>
                            <td><input type="radio" name="isbn" value="${revista.isbn}" /></td>
                            <td>${revista.isbn}</td>
                            <td>${revista.titulo}</td>
                            <td>${revista.editorial}</td>
                            <td>${revista.clasificacion}</td>
                            <td>${revista.periodicidad}</td>
                            <td>${revista.fecha}</td>
                        </tr>
                    </c:forEach> --%>
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
