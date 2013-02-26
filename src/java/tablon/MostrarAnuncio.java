package tablon;


import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MostrarAnuncio")
public class MostrarAnuncio extends ServletBase {

    // Para tener una referencia a la tabla de anuncios.
    private List<Anuncio> tablaAnuncios;

    public void init() {
        tablaAnuncios = (List<Anuncio>) this.getServletConfig().getServletContext().getAttribute("tablaAnuncios");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>Mostrar Anuncio</title>");
        out.println("</head>");
        out.println("<body>");

        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/cabecera.html");
        r.include(request,response);

        // Mostramos los datos del anuncio que nos indican los parámetros. Para
        // acceder a él le pasamos a la tabla la petición, porque es ella la que
        // sabe interpretarla.

        Anuncio a = tablaAnuncios.get(Integer.parseInt(request.getParameter("idAnuncio")));
        a.mostrarHTML(out);

        out.println("<br><br><a href='TablonAnuncios'>Volver</a>");

        out.println("</head>");
        out.println("<body>");

    }

}