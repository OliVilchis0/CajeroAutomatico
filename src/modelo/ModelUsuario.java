package modelo;

import utils.Constantes;

import java.util.ArrayList;
import java.util.List;

public class ModelUsuario {

    //Clase que representa el usuario del cajero automatico

    private double saldo;
    private List<List<String>> historico;

    public ModelUsuario(){

        //Contructor de la clase

        this.saldo = Constantes.ONE_THOUSAND;
        this.historico = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<List<String>> getHistorico(){
        return this.historico;
    }

    public void addHistorico(List<String> item){
        this.historico.add(item);
    }
}
