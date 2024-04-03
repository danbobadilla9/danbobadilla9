<%-- 
    Document   : index
    Created on : 26/03/2024, 01:12:56 PM
    Author     : Dan Israel Bobadilla
--%>

<%@page import="Modelos.MarcaModel"%>
<%@page import="JabaBeans.Marca"%>
<%@page import="Modelos.CategoriaModel"%>
<%@page import="JabaBeans.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Gestión de productos |  Crea e-Commerce JAVA EE con pagos Online Paypal y Payu</title>
        <%@include file="../../WEB-INF/css.jsp" %>
    </head><!--/head-->

    <body>

        <%@include file="../../WEB-INF/Header.jsp" %>



        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                    </div>

                    <div class="col-sm-10 clearfixt">
                    ${mensaje}

                        <h3>Gestionar Producto</h3>
                        <form action="ControlProducto" enctype="multipart/form-data" method="post">
                            <div class="form-one">
                                Nombre:<br/>
                                <input type="text" name="nombre" placeholder="Nombre producto" value="" required /><hr/>
                                Precio (MXN):<br/>
                                <input type="number" name="precio" placeholder="Precio" value="0" min="0" /><br/>
                                Precio Promo (MXN):<br/>
                                <input type="number" name="precionuevo" placeholder="Precio" value="0" min="0" /><hr/>
                                Precio (USD):<br/>
                                <input type="number" name="preciousd" placeholder="Precio" value="0" min="0" /><br/>
                                Precio Promo (USD):<br/>
                                <input type="number" name="precionuevousd" placeholder="Precio" value="0" min="0" /><hr/>
                                Precio (COP):<br/>
                                <input type="number" name="preciocop" placeholder="Precio" value="0" min="0" /><br/>
                                Precio Promo (COP):<br/>
                                <input type="number" name="precionuevocop" placeholder="Precio" value="0" min="0" /><hr/>
                                Precio (PEN):<br/>
                                <input type="number" name="preciopen" placeholder="Precio" value="0" min="0" /><br/>
                                Precio Promo (PEN):<br/>
                                <input type="number" name="precionuevopen" placeholder="Precio" value="0" min="0" /><hr/>
                                Stock: <br/>
                                <input type="number" name="cantidad" placeholder="Cantidad" value="1" min="1" /><br/>

                                Marca: <select name="marca">
                                    <option>Seleccionar Categoría</option>
                                    <% for (Marca m : MarcaModel.listarTodoDeMarca()) {%>
                                    <option value="<%= m.getCodigo()%>" ><%= m.getNombre()%></option>
                                    <%}%>
                                </select>

                                Categoria: <select name="categoria">
                                    <option>Seleccionar Categoría</option>
                                    <% for (Categoria c : CategoriaModel.listarTodoDeCategorias()) {%>
                                    <option value="<%= c.getCodigo()%>" ><%= c.getNombre()%></option>
                                    <%}%>
                                </select>

                                Descripción: <textarea name="descripcion" rows="4" cols="20" placeholder="Descripción" required>
                                    
                                </textarea>

                                Nuevo?:<input type="checkbox" name="nuevo" value="ON" checked="checked"/>
                                Recomendado?:<input type="checkbox" name="recomendado" value="ON" />
                                Visible?:<input type="checkbox" name="visible" value="ON" checked="checked"/>
                                <hr/>
                                Seleccionar imagen:<input type="file" name="imagen" value="Seleccionar una imagen" required />
                                <hr/>
                                <input  class="btn btn-success"  name="accion" type="submit" value="Registrar" />
                                <input  class="btn btn-default" name="accion" type="submit" value="Consultar" />
                                <input  class="btn btn-warning" name="accion" type="submit" value="Actualizar" />
                                <input  class="btn btn-danger" name="accion" type="submit" value="Borrar" />

                            </div>
                        </form>



                    </div>
                </div>
            </div>
        </section>

        <%@include file="../../WEB-INF/Footer.jsp" %>
        <%@include file="../../WEB-INF/js.jsp" %>




    </body>
</html>
