package tablon;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class ServletBase extends HttpServlet {

    // Devuelve el objeto usuario y le crea si no existe
    public Usuario getUsuario(HttpServletRequest req, HttpServletResponse res) {
        HttpSession sesion = req.getSession();
        Usuario u = (Usuario) sesion.getAttribute("usuario");
        if (u == null) {
            u = new Usuario(req, res);
            sesion.setAttribute("usuario", u);
        } 
        return u;
    }

    // Pregunta si tenemos guardada información del usuario
    public boolean usuarioCreado(HttpServletRequest req) {
        return (req.getSession(false) != null);
    }

}
