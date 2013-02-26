package tablon;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Esta clase permite agrupar todos aquellos aspectos que tienen con la información del
   usuario:
     - Permite centralizar todos los accesos a las cookies en una misma clase.
     - Permite acceder a los atributos de forma que el compilador hace las comprobaciones
     - Permite la inicialización de los datos del usuario independientemente del servlet
       que cree esta información.
*/

public class Usuario extends UsuarioBase {

    // Atributos
    private String nombre;
    private int numMensajes;
    private int numSesionActual;

    public Usuario(HttpServletRequest req, HttpServletResponse res) {
        super(req, res);
        this.nombre = this.getCookie("nombre", req);
        this.numMensajes = 0;

        try {
            String numSesion = this.getCookie("numSesion", req);
            this.numSesionActual = Integer.parseInt(numSesion) + 1;
        } catch (Exception e) {
            this.numSesionActual = 1;
        }
        this.addCookie("numSesion", Integer.toString(getNumSesionActual()), res);
    }

    // Métodos para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    // Como norma general, cada vez que se quiera poner un atributo, hay que pasarle
    // el response por si quiere actualizar alguna cookie.
    public void setNombre(String nombre, HttpServletResponse res) {
        this.nombre = nombre;
        this.addCookie("nombre", nombre, res);
    }

    public int getNumMensajes() {
        return numMensajes;
    }

    // Como norma general, cada vez que se quiera poner un atributo, hay que pasarle
    // el response por si quiere actualizar alguna cookie.
    public void setNumMensajes(int numMensajes, HttpServletResponse res) {
        this.numMensajes = numMensajes;
    }

    public int getNumSesionActual() {
        return numSesionActual;
    }
}
