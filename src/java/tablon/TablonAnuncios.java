package tablon;


import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/TablonAnuncios")
public class TablonAnuncios extends ServletBase {

    // Para tener una referencia a la tabla de anuncios.
    private List<Anuncio> anuncios;

    public void init() {
        anuncios = (List<Anuncio>) this.getServletContext().getAttribute("tablaAnuncios");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Usuario u = this.getUsuario(request, response);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>Tablon Anuncios</title>");
        out.println("</head>");
        out.println("<body>");

        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/cabecera.html");
        r.include(request,response);

        if (u.isNew()) {
            // Si se acaba de crear le damos la bienvenida
            String nombre = u.getNombre();
            if (nombre == null) {
                out.println("<h2>Bienvenido, has venido " + u.getNumSesionActual() + " veces</h2><br><br>");
            } else {
                out.println("<h2>Bienvenido " + nombre + ", has venido " + u.getNumSesionActual() + " veces</h2><br><br>");
            }
        } else {
            // Si no es la primera vez que entra le decimos los mensajes que lleva
            // insertados en la sesión actual.

            out.println("En la sesión actual has insertado " + u.getNumMensajes() + " mensajes<br>");
        }

        out.println("<h2>Tablon Anuncio</h2>");
        out.println("<h3>Asunto / Nombre</h3>");

        //Mostramos la tabla de los anuncio. Indicamos el Servlet que
        //se encargará de atender los enlaces de la tabla de anuncios.
                        
        //Mostramos los anuncios que tenemos
        for (int i = 0; i < this.anuncios.size(); i++) {
            anuncios.get(i).mostrarCabecera(out, "<a href='MostrarAnuncio?idAnuncio=" + i + "'>");
            out.println("<br>");
        }

        //Mostramos enlace para añadir nuevos anuncios
        //Observa que los enlaces se crean con encodeURL
        out.println("<br/><br/><a href='MuestraFormularioAnuncio'>Insertar Nuevo Anuncio</a>");

        out.println("<br><br><br>");
        out.println("<a href=mailto:"+this.getServletContext().getInitParameter("Webmaster")+"> webmaster </a>");

        out.println("</body>");
        out.println("</html>");
    }

}




