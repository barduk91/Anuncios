package tablon;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;

class Anuncio {
    private String nombre;
    private String comentario;
    private String asunto;

    public Anuncio(HttpServletRequest request) {
        this.nombre = request.getParameter("nombre");
        this.comentario = request.getParameter("comentario");
        this.asunto = request.getParameter("asunto");
    }

    public void mostrarHTML(PrintWriter out) {
        out.println("Nombre: " + this.nombre + "<br>");
        out.println("Asunto: " + this.asunto + "<br>");
        out.println("Comentario: " + this.comentario + "<br>");
    }

    // Este método se encarga de mostrar la cabecera de un anuncio. Se le pasa como
    // parámetro el inicio de un hiperenlace para que el anuncio decida en que parte
    // de su representación quiere que sea el hiperenlace. Pero no tiene conocimiento
    // de la información del hiperenlace porque no se ocupa de ella.
    public void mostrarCabecera(PrintWriter out, String inicioHiperenlace) {
        out.println(inicioHiperenlace + this.nombre + "</a> ");
        out.println(inicioHiperenlace + this.asunto + "</a>");
    }

    public String getNombre() {
        return nombre;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getComentario() {
        return comentario;
    }

    // Si amplías la funcionalidad de un método, manten un método con el interfaz
    // antiguo y la funcionalidad antigua, de esa forma, aquellos códigos que usan la
    // versión antigua y no necesitan la nueva funcionalidad no necesitan ser modificados.
    public static void mostrarFormularioAnuncio(PrintWriter out, String servletReceptor) {
        mostrarFormularioAnuncio(out, "", servletReceptor);
    }

    public static void mostrarFormularioAnuncio(PrintWriter out, String nombre, String servletReceptor) {

        out.println("<form method='get' action='" + servletReceptor + "'>");
        out.println("Nombre: <input type='text' name='nombre' value='" + nombre + "'><br>");
        out.println("Asunto: <input type='text' name='asunto'><br>");
        out.println("Comentario: <br><textarea name='comentario' rows=5 cols=40></textarea><br>");
        out.println("<input type='submit' value='Guardar'>");

    }
}


