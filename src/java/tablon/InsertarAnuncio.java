package tablon;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/InsertarAnuncio")
public class InsertarAnuncio extends ServletBase {
    // Para tener una referencia a la tabla de anuncios.
    private List<Anuncio> tablaAnuncios;

    public void init() {
        tablaAnuncios = (List<Anuncio>) this.getServletConfig().getServletContext().getAttribute("tablaAnuncios");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        //Creamos e insertamos el anuncio
        Anuncio a = new Anuncio(request);
        tablaAnuncios.add(a);

        //Obtenemos el nombre del usuario y le guardamos en un atributo de la sesión
        Usuario u = this.getUsuario(request, response);
        u.setNombre(request.getParameter("nombre"), response);
        u.setNumMensajes(u.getNumMensajes() + 1, response);

        // -- GENERA RESULTADO --

        //Se redirige a la página principal en vez de generar el contenido
        
        response.sendRedirect(response.encodeRedirectURL("TablonAnuncios"));

        /* response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>Anuncio Insertado</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<br><br><h3>El anuncio ha sido insertado con exito </h3>");
        
        out.println("<br><a href='TablonAnuncios'>Página principal</a>");

        out.println("</body></html>"); */
    }

}