package tablon;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InicioFinContexto implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent event) {
    }

    public void contextInitialized(ServletContextEvent event) {
        // Creamos la tabla de anuncios
        List<Anuncio> tablaAnuncios = new ArrayList<Anuncio>();
        // La añadimos al contexto para que loa servlets la usen
        event.getServletContext().setAttribute("tablaAnuncios", tablaAnuncios);
    }
}
