<%-- 
    capturaIsbn.jsp

    Esta página JSP permite capturar el isbn de una revista a agregar
    al catálogo de revistas. Forma parte de la aplicación bibliotecaWeb

    Karla Ximena Islas Cruz ID: 213090
    Gabriel Francisco Piñuelas Ramos ID: 230626
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Capturar ISBN</title>
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
                <h2>Revista a agregar</h2>
                
                <%-- Formulario para capturar el isbn de una revista.
                     El isbn se envía al servlet obtenRevista para
                     obtener la revista de la BD --%>
                <form action="obtenRevista" method="post" name="capturaIsbn" >
                    
                    <%-- Los mensajes de validación del lado del servidor se
                         encuentran en el bean mensajes, almacenado en el
                         objeto request por el servlet obtenRevista. --%>
                    <div class="contenedorFormulario">

                        <div class="derecha"><label for="isbnId" >Isbn *</label></div>

                        <div>
                            <input type="text" id="isbnId" name="isbn" value="${param.isbn}" size="13" pattern="^[0-9]{13}$" title="Tresce d&iacute;gitos" 
                                   placeholder="5642908967801" required />
                        </div>
                                   
                        <div id="msjIsbn" class="${mensajes.isbn.claseMensaje}">
                            ${mensajes.isbn.mensaje}
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
