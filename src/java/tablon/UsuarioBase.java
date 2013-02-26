package tablon;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: Administrador
 * Date: Dec 1, 2002
 * Time: 5:12:50 PM
 * To change this template use Options | File Templates.
 */

public class UsuarioBase {

    // -----------------------
    //   Control del usuario
    // -----------------------
    HttpSession sesion;

    // M�todos de control
    public UsuarioBase(HttpServletRequest req, HttpServletResponse res) {
        this.sesion = req.getSession();
    }

    // Pregunta si se ha creado en la petici�n actual.
    public boolean isNew() {
        return sesion.isNew();
    }

    // Este m�todo se usa para buscar una cookie por nombre en el array de cookies
    protected String getCookie(String nombreCookie, HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        String valor = null;

        if (cookies != null) {
            boolean seguir = true;
            int i = 0;
            while (seguir && i < cookies.length) {
                if (cookies[i].getName().equals(nombreCookie)) {
                    seguir = false;
                    valor = cookies[i].getValue();
                } else {
                    i++;
                }
            }
        }
        return valor;
    }

    protected void addCookie(String nombre, String valor, HttpServletResponse res) {
        Cookie newCookie = new Cookie(nombre, valor);
        newCookie.setMaxAge(5000000);
        res.addCookie(newCookie);
    }


}
