package vista;

import com.sun.xml.internal.bind.v2.runtime.ClassBeanInfoImpl;
import utils.Constantes;

import javax.swing.*;
import java.awt.*;

public class ViewLogin {

    //Clase que representa la interfaz grafica donde el usuario podra logearse

    public JButton btnIngresar;
    public JPasswordField passPin;
    private JFrame frame;

    public ViewLogin(){
        this.btnIngresar = new JButton(Constantes.GO);
        this.passPin = new JPasswordField();
    }

    public void init(){

        //Metodo que lanza la ventana loging

        this.frame = new JFrame(Constantes.LOGIN);
        this.frame.setSize(Constantes.SIZE_WIDTH,Constantes.SIZE_LENGTH);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        this.frame.add(panel);
        this.panel(panel);

        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
    }

    private void panel(JPanel panel){
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.add(new Label(Constantes.PIN_MESSAGE));
        panel.add(this.passPin);
        panel.add(this.btnIngresar);
    }

    public void close(){
        this.frame.setVisible(false);
    }
}
