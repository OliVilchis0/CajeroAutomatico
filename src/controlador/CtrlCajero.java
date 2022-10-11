package controlador;

import modelo.ModelUsuario;
import vista.ViewCajero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Constantes.*;

public class CtrlCajero implements ActionListener{

    //Clase que representa las fuciones de un cajero automatico

    private ViewCajero view;
    private ModelUsuario user;

    public CtrlCajero(ViewCajero view){

        //constructor de la clase

        this.view = view;
        this.user = new ModelUsuario();
        this.init();
    }

    private void init(){
        this.view.btnConsultarSaldo.addActionListener(this);
        this.view.btnRetirarSaldo.addActionListener(this);
        this.view.btnHistorico.addActionListener(this);
        this.view.btnSalir.addActionListener(this);
        this.view.btnRetirar.addActionListener(this);
    }
    public void consultarSaldo(){
        if(this.view.txtMonto.isVisible() || this.view.txtArea.isVisible()) {
            this.view.txtMonto.setVisible(false);
            this.view.btnRetirar.setVisible(false);
            this.view.jp.setVisible(false);
        }

        this.view.lbInfo.setFont(new Font(FONT_TYPE,Font.ITALIC,FONT_TEXT));
        this.view.lbInfo.setText(QUERY);
        this.view.lbInfoPlus.setText(SALDO_MESSAGE+PESOS+this.user.getSaldo());
    }

    public void retirarSaldo(){

        if(this.view.txtArea.isVisible())
            this.view.jp.setVisible(false);

        this.view.lbInfo.setFont(new Font(FONT_TYPE,Font.ITALIC,FONT_TEXT));
        this.view.lbInfo.setText(RETIRAR);
        this.view.lbInfoPlus.setText(VALUE_CASH);
        this.view.txtMonto.setVisible(true);
        this.view.btnRetirar.setVisible(true);
    }

    public void validarMonto(){
        String strMonto = this.view.txtMonto.getText();
        try{
            double monto = Double.parseDouble(strMonto);
            double saldoActual = this.user.getSaldo();

            if (monto <= saldoActual){
                LocalDate date = LocalDate.now();
                LocalTime hour = LocalTime.now();
                double nuevoMonto = saldoActual - monto;
                this.user.setSaldo(nuevoMonto);
                List<String> item = Arrays.asList(
                        date.toString(),
                        hour.toString(),
                        String.valueOf(saldoActual),
                        String.valueOf(monto),
                        String.valueOf(nuevoMonto)
                );
                this.user.addHistorico(item);

                JOptionPane.showMessageDialog(null,MESSAGE_MONEY,SUCCESS,1);

                this.view.txtMonto.setVisible(false);
                this.view.btnRetirar.setVisible(false);
                this.view.lbInfoPlus.setText(NOTHING);
                this.view.lbInfo.setFont(new Font(FONT_TYPE,Font.ITALIC,FONT_SUBTITLE));
                this.view.txtMonto.setText(NOTHING);
                this.view.lbInfo.setText(USER_REQUEST+QUESTION);
            }else{
                JOptionPane.showMessageDialog(null,NO_MONEY);
                this.view.txtMonto.setText(NOTHING);
            }
        }catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,VALUE_ERROR);
            this.view.txtMonto.setText(NOTHING);
        }
    }

    public void historico(){
        if(this.view.txtMonto.isVisible()) {
            this.view.txtMonto.setVisible(false);
            this.view.btnRetirar.setVisible(false);
        }

        this.view.lbInfo.setText(HISTORY);
        this.view.lbInfoPlus.setText(NOTHING);
        this.view.lbInfo.setFont(new Font(FONT_TYPE,Font.ITALIC,FONT_TEXT));
        this.view.jp.setVisible(true);

        this.view.txtArea.setText(NOTHING);

        for(List<String> i : this.user.getHistorico()){
            this.view.txtArea.append(DATE+i.get(0)+"\n");
            this.view.txtArea.append(HOUR+i.get(1)+"\n");
            this.view.txtArea.append(S_ANTERIOR+i.get(2)+"\n");
            this.view.txtArea.append(RETIRO+i.get(3)+"\n");
            this.view.txtArea.append(S_ACTUAL+i.get(4)+"\n");
            this.view.txtArea.append(UNDERSCORE+"\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.view.btnConsultarSaldo == e.getSource()){
            this.consultarSaldo();
        }else if (this.view.btnRetirarSaldo == e.getSource()){
            this.retirarSaldo();
        }else if (this.view.btnHistorico == e.getSource()){
            this.historico();
        }else if(this.view.btnRetirar == e.getSource()){
            this.validarMonto();
        }else{
            System.exit(ZERO);
        }
    }
}
