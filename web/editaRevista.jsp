<%-- 
    editaRevista.jsp

    Esta página JSP permite desplegar un formulario para editar una revista. Forma parte de 
    la aplicación bibliotecaWeb.

    Karla Ximena Islas Cruz ID: 213090
    Gabriel Francisco Piñuelas Ramos ID: 230626
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
    <head>
        <title>Actualizar revista</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css">
    </head>

    <body>
        <div class="container">

            <%-- Incluye el encabezado del titulo de la pagina --%>
            <%@include file="jspf/titulo.jspf"%>

            <%-- Incluye el menu de revistas --%>
            <%@include file="jspf/menuRevistas.jspf"%>

            <main>
                <h1>Actualizar Revista</h1>

                <c:choose>
                    <c:when test="${revista != null}">
                        <%-- Formulario para modificar los atributos de una revista.
                             Los datos se envían al servlet actualizaRevista para actualizar la revista en la BD.
                             Este formulario se usa la primera vez que se intenta modificar los atributos de la revista.
                        --%>
                        <form action="actualizaRevista" method="post" name="editaRevista" >

                            <%-- Despliega los datos de la revista para editarlos. Los datos se encuentran en el bean 
                                 revista guardados en el objeto request por el servlet obtenRevistaEditar.
                            --%>
                            <div class="contenedorFormulario">

                                <div class="derecha">
                                    <label for="isbnId" >Isbn</label>
                                </div>
                                <div>
                                    <input type="text" id="isbnId" name="isbn"
                                           value="${revista.isbn}" size="13" readonly />
                                </div>

                                <div>&nbsp;</div>

                                <div class="derecha">
                                    <label for="tituloId" >Título *</label>
                                </div>
                                <div>
                                    <input type="text" id="tituloId" name="titulo" 
                                           value="${revista.titulo}" size="40" maxlength="50" required
                                           placeholder="T&iacute;tulo de la revista" />
                                </div>       

                                <div>&nbsp;</div>

                                <div class="derecha">
                                    <label for="editorialId" >Editorial *</label>
                                </div>
                                <div>
                                    <input type="text" id="editorialId" name="editorial" 
                                           value="${revista.editorial}" size="40" maxlength="35" required
                                           placeholder="Editorial de la revista" />
                                </div>           

                                <div>&nbsp;</div>

                                <div class="derecha">
                                    <label for="clasificacionId" >Clasificación *</label>
                                </div>
                                <div>
                                    <input type="text" id="clasificacionId" name="clasificacion" 
                                           value="${revista.clasificacion}" size="40" maxlength="20" required
                                           placeholder="Clasificación de la revista" />
                                </div>

                                <div>&nbsp;</div>   

                                <div class="derecha">
                                    <label for="periodicidadId" >Periodicidad </label>
                                </div>
                                <div>
                                    <input type="text" id="periodicidadId" name="periodicidad" 
                                           value="${revista.periodicidad}" size="40" maxlength="20"
                                           placeholder="Periodicidad de la revista" />
                                </div>

                                <div>&nbsp;</div>

                                <div class="derecha">
                                    <label for="fechaId" >Fecha (dd/mm/aaa)</label>
                                </div>
                                <div>
                                    <input type="text" id="fechaId" name="fecha"
                                           value="${cancion.fecha}" size="10" 
                                           pattern="^(([0-2]?[0-9])|([3][0-1]))\/(([0]?[0-9])|([1][0-2]))\/[0-9]{4}$"
                                           placeholder="dd/mm/aaa" />
                                </div>

                                <div>&nbsp;</div>

                                <div class="span centrada">
                                    &nbsp;
                                </div>
                                <div class="span centrada">
                                    <input type="submit" name="boton" value="Continuar" />
                                    &nbsp;&nbsp;&nbsp;
                                    <input type="reset" value="Limpiar" />
                                </div>
                            </div>
                        </form>

                    </c:when>
                    <c:otherwise>
                        <form action="actualizaRevista" method="post" name="reEditaRevista" novalidate >

                            <%-- Despliega los datos de la revista para reeditarlos, esto es para corregirlos si 
                                 hubo un error de validacion. Los datos se encuentran como parametros de la solicitud.
                                 Los mensajes de validación del lado del servidor se encuentran en el bean mensajes, 
                                 almacenado en el objeto request por el servlet actualizaRevista. --%>
                            <div class="contenedorFormulario">

                                <div class="derecha">
                                    <label for="isbnId" >Isbn</label>
                                </div>
                                <div>
                                    <input type="text" id="isbnId" name="isbn"
                                           value="${param.isbn}" size="13" readonly />
                                </div>

                                <div>&nbsp;</div>

                                <div class="derecha">
                                    <label for="tituloId" >Título *</label>
                                </div>
                                <div>
                                    <input type="text" id="tituloId" name="titulo" 
                                           value="${param.titulo}" size="40" maxlength="50" required
                                           placeholder="T&iacute;tulo de la revista" />
                                </div>

                                <div id="msjTitulo" class="${mensajes.titulo.claseMensaje}">
                                    ${mensajes.titulo.mensaje}
                                </div>

                                <div>&nbsp;</div>

                                <div class="derecha">
                                    <label for="editorialId" >Editorial *</label>
                                </div>
                                <div>
                                    <input type="text" id="editorialId" name="editorial" 
                                           value="${param.editorial}" size="40" maxlength="35" required
                                           placeholder="Editorial de la revista" />
                                </div>
                                <div id="msjEditorial" class="${mensajes.editorial.claseMensaje}">
                                    ${mensajes.editorial.mensaje}
                                </div>

                                <div>&nbsp;</div>

                                <div class="derecha">
                                    <label for="clasificacionId" >Clasificación *</label>
                                </div>
                                <div>
                                    <input type="text" id="clasificacionId" name="clasificacion" 
                                           value="${param.clasificacion}" size="40" maxlength="20" required
                                           placeholder="Clasificación de la revista" />
                                </div>
                                <div id="msjClasificacion" class="${mensajes.clasificacion.claseMensaje}">
                                    ${mensajes.clasificacion.mensaje}
                                </div>

                                <div>&nbsp;</div>

                                <div class="derecha">
                                    <label for="periodicidadId" >Periodicidad </label>
                                </div>
                                <div>
                                    <input type="text" id="periodicidadId" name="periodicidad" 
                                           value="${param.periodicidad}" size="40" maxlength="20"
                                           placeholder="Periodicidad de la revista" />
                                </div>
                                <div id="msjPeriodicidad" class="${mensajes.periodicidad.claseMensaje}">
                                    ${mensajes.periodicidad.mensaje}
                                </div>
                                
                                <div>&nbsp;</div>
                                
                                <div class="derecha">
                                    <label for="fechaId" >Fecha (dd/mm/aaa) *</label>
                                </div>
                                <div>
                                    <input type="text" id="fechaId" name="fecha"
                                           value="${param.fecha}" size="10" required
                                           pattern="^(([0-2]?[0-9])|([3][0-1]))\/(([0]?[0-9])|([1][0-2]))\/[0-9]{4}$"
                                           placeholder="dd/mm/aaa" />
                                </div>
                                <div id="msjFecha" class="${mensajes.fecha.claseMensaje}">
                                    ${mensajes.fecha.mensaje}
                                </div>
                                
                                <div class="span centrada">
                                    &nbsp;
                                </div>
                                <div class="span centrada">
                                    <input type="submit" name="boton" value="Continuar" />
                                    &nbsp;&nbsp;&nbsp;
                                    <input type="reset" value="Limpiar" />
                                </div>
                            </div>
                        </form>
                    </c:otherwise>
                </c:choose>
            </main>
            <%-- Incluye el pie de pagina --%>
            <%@include file="jspf/piePagina.jspf"%>
        </div>
    </body>
</html>
