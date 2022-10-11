import controlador.CtrlLogin;
import utils.Constantes;
import vista.ViewLogin;

public class Main {
    public static void main(String[] args) {

        //Metodo principal que se encargara de lanzar la ventana de loging

        ViewLogin view = new ViewLogin();
        CtrlLogin login = new CtrlLogin(view);

    }
}