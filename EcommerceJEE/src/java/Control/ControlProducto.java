/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import JabaBeans.Producto;
import JabaBeans.ProductoMoneda;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Dan Israel Bobadilla
 */
public class ControlProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControlProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlProducto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String url = subirImagen(request);
            // Proceso de recibir la información
            String nombre = request.getParameter("nombre");
            float precio = Float.parseFloat(request.getParameter("precio"));
            float precion = Float.parseFloat(request.getParameter("precionuevo"));

            float preciocop = Float.parseFloat(request.getParameter("preciocop"));
            float precioncop = Float.parseFloat(request.getParameter("precionuevocop"));
            
            float preciousd = Float.parseFloat(request.getParameter("preciousd"));
            float precionusd = Float.parseFloat(request.getParameter("precionuevousd"));
            
            float preciopen = Float.parseFloat(request.getParameter("preciopen"));
            float precionpen = Float.parseFloat(request.getParameter("precionuevopen"));
            
            
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            
            int marca = Integer.parseInt(request.getParameter("marca"));
            int categoria = Integer.parseInt(request.getParameter("categoria"));
            
            String descripcion = request.getParameter("descripcion");
            
            boolean nuevo = (request.getParameter("nuevo").equalsIgnoreCase("on"))? true:false;
            boolean recomendado = request.getParameter("recomendado").equalsIgnoreCase("on");
            boolean visible = request.getParameter("visible").equalsIgnoreCase("on");
            
            String accion = request.getParameter("accion");
            
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setPrecionuevo(precion);
            producto.setCodigo_categoria(categoria);
            producto.setCodigo_marca(marca);
            producto.setDescripcion(descripcion);
            producto.setImg(url);
            producto.setNuevo(nuevo);
            producto.setRecomendado(recomendado);
            producto.setStock(cantidad);
            producto.setVisible(visible);
            
            ProductoMoneda pmonedacop = new ProductoMoneda();
            pmonedacop.setMoneda("COP");
            pmonedacop.setPrecio(preciocop);
            pmonedacop.setPrecionuevo(precioncop);
            
            ProductoMoneda pmonedausd = new ProductoMoneda();
            pmonedausd.setMoneda("USD");
            pmonedausd.setPrecio(preciousd);
            pmonedausd.setPrecionuevo(precionusd);
            
             ProductoMoneda pmonedapen = new ProductoMoneda();
            pmonedapen.setMoneda("PEN");
            pmonedapen.setPrecio(preciopen);
            pmonedapen.setPrecionuevo(precionpen);
            
            //response.sendRedirect("foto/"+url);
    }
    
    private String subirImagen(HttpServletRequest request){
        
        try {
            FileItemFactory fileFactory = new DiskFileItemFactory();
            ServletFileUpload serveletUpload = new ServletFileUpload(fileFactory);
            
            // Extraemos los archivos que subio, puede ser más d euno
            String nombre ="";
            List items = serveletUpload.parseRequest(request);
            for(int i = 0; i < items.size(); i++){
                FileItem item = (FileItem) items.get(i);
                if(!item.isFormField()){
                    String ruta = request.getServletContext().getRealPath("/")+"foto/";
                    SimpleDateFormat sdf = new SimpleDateFormat("ddMyyyyhhmmss");
                    String fecha = sdf.format(new Date());
                    nombre = fecha+ new Random().nextLong()+item.getName();
                    //String nuevoNombre = ruta+fecha+ new Random().nextLong()+item.getName();
                    String nuevoNombre = ruta+nombre;
                    File folder = new File(ruta);
                    if(!folder.exists()){
                        folder.mkdirs();
                    }
                    File imagen = new File(nuevoNombre);
                    if(item.getContentType().contains("image")){
                        item.write(imagen);
                        request.setAttribute("subida", true);
                        //return "foto/"+nuevoNombre;
                        return nombre;
                    }
                }
            }
            return null;
        } catch (FileUploadException ex) {
            request.setAttribute("subida", false);
        } catch (Exception ex) {
            request.setAttribute("subida", false);
        }
        return "";
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
