package tablon;


import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MuestraFormularioAnuncio")
public class MuestraFormularioAnuncio extends ServletBase {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>Insertar Nuevo Anuncio</title>");
        out.println("</head>");
        out.println("<body>");

        RequestDispatcher r = this.getServletContext().
                getRequestDispatcher("/cabecera.html");
        r.include(request,response);

        // Si el atributo nombre no existe en la sesión, le inicializamos a cadena vacía.
        String nombre = this.getUsuario(request, response).getNombre();
        if (nombre == null) {
            Anuncio.mostrarFormularioAnuncio(out, "InsertarAnuncio");
        } else {
            Anuncio.mostrarFormularioAnuncio(out, nombre, "InsertarAnuncio");
        }

        out.println("</body>");
    }

}
