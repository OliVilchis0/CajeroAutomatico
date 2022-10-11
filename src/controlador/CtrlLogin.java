package controlador;

import utils.Constantes;
import vista.ViewCajero;
import vista.ViewLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static utils.Constantes.*;

public class CtrlLogin implements ActionListener {

    //Clase que se encargara de controlar los funciones de la vista login

    private ViewLogin view;
    private int count;

    public CtrlLogin(ViewLogin view){
        this.view = view;
        this.count = 0;
        this.init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.view.btnIngresar == e.getSource()) {
            this.count++;
            String pass = new String(this.view.passPin.getPassword());
            if (pass.equals(PIN)){
                this.view.close();
                ViewCajero view = new ViewCajero();
                CtrlCajero ctrl = new CtrlCajero(view);
            }else if(this.count == THREE){
                JOptionPane.showMessageDialog(null, PIN_NOT_MATCH);
                System.exit(ZERO);
            }else {
                JOptionPane.showMessageDialog(null, NOT_PIN);
            }
        }
    }
    private void init(){
        this.view.init();
        this.view.btnIngresar.addActionListener((ActionListener) this);
    }
}
