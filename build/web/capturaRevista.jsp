<%-- 
    capturaRevista.jsp

    Esta página JSP permite capturar los datos de una revista. Forma parte de 
    la aplicación bibliotecaWeb.

    Karla Ximena Islas Cruz ID: 213090
    Gabriel Francisco Piñuelas Ramos ID: 230626
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Capturar revista</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css">
    </head>

    <body>
        <div class="container">

            <%-- Incluye el encabezado del titulo de la pagina --%>
            <%@include file="jspf/titulo.jspf"%>

            <%-- Incluye el menu principal --%>
            <%@include file="jspf/menuRevistas.jspf"%>

            <main>
                <h2>Agregar revista</h2>
                <%-- Formulario para capturar los atributos de una revista.
                     Los datos se envían al servlet agregaRevista para
                     guardarlos en la BD --%>
                <form action="agregaRevista" method="post" name="capturaRevista" >
                    <div class="contenedorFormulario">
                        <%-- Los mensajes de validación del lado del servidor se
                         encuentran en el bean mensajes, almacenado en el
                         objeto request por el servlet agregaRevista. --%>
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
                                   
                        <div>&nbsp;</div>    
                        
                        <div class="derecha">
                            <label for="editorialId" >Editorial *</label>
                        </div>
                        <div>
                            <input type="text" id="editorialId" name="editorial" 
                                   value="${param.editorial}" size="40" maxlength="35" required
                                   placeholder="Editorial de la revista" />
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
                                   
                        <div>&nbsp;</div>   
                        
                        <div class="derecha">
                            <label for="periodicidadId" >Periodicidad </label>
                        </div>
                        <div>
                            <input type="text" id="periodicidadId" name="periodicidad" 
                                   value="${param.periodicidad}" size="40" maxlength="20"
                                   placeholder="Periodicidad de la revista" />
                        </div>
                                   
                        <div>&nbsp;</div>  
                        
                        <div class="derecha">
                            <label for="fechaId" >Fecha (dd/mm/aaa)</label>
                        </div>
                        <div>
                            <input type="text" id="fechaId" name="fecha" 
                                   value="${param.fecha}" size="10"
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
            </main>

            <%-- Incluye el pie de pagina --%>
            <%@include file="jspf/piePagina.jspf"%>
        </div>
    </body>
</html>
