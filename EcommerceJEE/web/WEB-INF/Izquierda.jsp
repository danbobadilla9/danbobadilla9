<%-- 
    Document   : Izquierda
    Created on : 26/03/2024, 01:23:33 PM
    Author     : Dan Israel Bobadilla
--%>

<div class="left-sidebar">
    <h2>Categorías</h2>
    <div class="panel-group category-products" id="accordian"><!--category-productsr-->
        <!--  el %! indica que se van a crear metodos o variables -->
        <%!
            ArrayList<Categoria> lista = CategoriaModel.listar();
            int codigo = 0;
        %>
        <!-- Si solo tenemos %% esto indicaria que unicamente tenemos codigo java dentro del jsp -->
        <%
            for (int i = 0; i < lista.size(); i++) {
                codigo = lista.get(i).getCodigo();
        %>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">

                    <a <% if (CategoriaModel.esSuperior(codigo)) {%> data-toggle="collapse" data-parent="#accordian" <%}%>  href="#<%= codigo%>">
                        <% if (CategoriaModel.esSuperior(codigo)) {%><span class="badge pull-right"><i class="fa fa-plus"></i></span><%}%> 
                        <!-- con %= hacemos que se muestre en el html el valor de alguna variables -->
                        <%= lista.get(i).getNombre()%>
                    </a>

                </h4>
            </div>
            <div id="<%=codigo%>" class="panel-collapse collapse">
                <div class="panel-body">
                    <!--Las variables locales como es el caso de i, no estan disponibles en las declaraciones de scriptlet de tipo %! 
                    solo estan disponibles en las de tip % %
                    -->
                    <!-- Esto no servira -> <%! //ArrayList<Categoria> listaSubcategoria = CategoriaModel.listarSubCategoria(lista.get(i).getCodigo());%>-->
                    <ul>

                        <!-- Al ponerle %! se inicializan al mismo tiempo, por lo que codigo valdria cero 0, le quitamos el ! para
                            que la ejecución sehaga se manera secuencial
                        -->
                        <%
                            ArrayList<Categoria> listaSub = CategoriaModel.listarSubCategoria(codigo);
                        %>
                        <%
                            for (int j = 0; j < listaSub.size(); j++) {
                                codigo = listaSub.get(j).getCodigo();
                        %>

                        <li><a href="#"><%= listaSub.get(j).getNombre()%> </a></li>

                        <%}%>
                    </ul>
                </div>
            </div>
        </div>
        <%}%>
    </div><!--/category-products-->

    <div class="brands_products"><!--brands_products-->
        <h2>Marcas</h2>
        <div class="brands-name">
            <ul class="nav nav-pills nav-stacked">
                <li><a href="#"> <span class="pull-right">(56)</span>Nike</a></li>
                <li><a href="#"> <span class="pull-right">(27)</span>Adidas</a></li>
                <li><a href="#"> <span class="pull-right">(32)</span>Polo</a></li>
                <li><a href="#"> <span class="pull-right">(5)</span>Puma</a></li>
                <li><a href="#"> <span class="pull-right">(9)</span>Boude</a></li>
                <li><a href="#"> <span class="pull-right">(4)</span>ACB</a></li>
            </ul>
        </div>
    </div><!--/brands_products-->

    <div class="shipping text-center"><!--shipping-->
        <img src="images/home/shipping.jpg" alt="" />
    </div><!--/shipping-->

</div>
