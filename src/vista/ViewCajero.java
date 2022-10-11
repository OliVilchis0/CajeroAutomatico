package vista;

import javax.swing.*;

import java.awt.*;

import static utils.Constantes.*;

public class ViewCajero {

    //Clase que se encargara de visualizar el menu de opciones para el usuario

    public JButton btnConsultarSaldo;
    public JButton btnRetirarSaldo;
    public JButton btnHistorico;
    public JButton btnSalir;
    public JButton btnRetirar;
    public JLabel lbInfo;
    public JLabel lbInfoPlus;
    public JTextField txtMonto;
    public JTextArea txtArea;
    public JScrollPane jp;
    private JFrame frame;

    public ViewCajero() {

        //Contructor de la clase que se encarga de inicializar los recursos
        this.frame = new JFrame(MENU);
        this.btnConsultarSaldo = new JButton(CONSULTAR_SALDO);
        this.btnRetirarSaldo = new JButton(RETIRAR_SALDO);
        this.btnHistorico = new JButton(HISTORICO_SALDO);
        this.btnSalir = new JButton(EXIT);
        this.lbInfo = new JLabel(USER_REQUEST+QUESTION);
        this.lbInfoPlus = new JLabel();
        this.txtMonto = new JTextField();
        this.btnRetirar = new JButton(RETIRAR_SALDO);
        this.txtArea = new JTextArea();
        this.jp = new JScrollPane(this.txtArea);

        this.init();
    }

    private void borderPanel(JPanel panel){
        panel.setLayout(new BorderLayout());

        JLabel lbWelcolme = new JLabel(WELCOME+System.getenv(HOST).toUpperCase());
        lbWelcolme.setHorizontalAlignment(SwingConstants.CENTER);
        lbWelcolme.setFont(new Font(FONT_TYPE, Font.BOLD,FONT_TITLE));

        JPanel jpButtons = new JPanel();
        JPanel jpInfo = new JPanel();

        this.jpButtons(jpButtons);
        this.jpInfo(jpInfo);

        panel.add(jpButtons,BorderLayout.LINE_START);
        panel.add(lbWelcolme,BorderLayout.PAGE_START);
        panel.add(jpInfo,BorderLayout.CENTER);
    }

    private void jpButtons(JPanel panel){

        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(BORDER,BORDER,BORDER, BORDER));

        this.btnConsultarSaldo.setMaximumSize(new Dimension(BTN_WIDTH,BTN_HEIGTH));
        this.btnRetirarSaldo.setMaximumSize(new Dimension(BTN_WIDTH,BTN_HEIGTH));
        this.btnHistorico.setMaximumSize(new Dimension(BTN_WIDTH,BTN_HEIGTH));
        this.btnSalir.setMaximumSize(new Dimension(BTN_WIDTH,BTN_HEIGTH));

        panel.add(this.btnConsultarSaldo);
        panel.add(this.btnRetirarSaldo);
        panel.add(this.btnHistorico);
        panel.add(this.btnSalir);
    }

    private void jpInfo(JPanel panel){

        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(BORDER,BORDER,BORDER, BORDER));

        this.lbInfo.setFont(new Font(FONT_TYPE,Font.ITALIC,FONT_SUBTITLE));
        this.lbInfoPlus.setFont(new Font(FONT_TYPE,Font.ITALIC,FONT_TEXT));
        this.txtMonto.setVisible(false);
        this.btnRetirar.setVisible(false);
        this.txtArea.setEditable(false);
        this.jp.setVisible(false);

        panel.add(this.lbInfo);
        panel.add(this.lbInfoPlus);
        panel.add(this.txtMonto);
        panel.add(this.btnRetirar);
        panel.add(this.jp);
    }

    private void init(){
        this.frame.setSize(600,400);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        this.frame.add(panel);
        this.borderPanel(panel);

        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
    }


}
