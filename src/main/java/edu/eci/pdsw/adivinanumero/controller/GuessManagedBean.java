/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.adivinanumero.controller;

import java.util.concurrent.ThreadLocalRandom;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2104784
 */
@ManagedBean(name = "beanEstadoAdivinanza")
@SessionScoped
public class GuessManagedBean {
    
    private int numero;
    private int intentos = 5;
    private int premio = 50000;
    private String estado = "";
    // El numero a adivinar se encuentra entre [1-5]
    private int numeroAdivinar = ThreadLocalRandom.current().nextInt(1, 5 + 1);
    private boolean primera = true;
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numeroAdivinar) {
        this.numero = numero;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }

    public void setNumeroAdivinar(int numeroAdivinar) {
        this.numeroAdivinar = numeroAdivinar;
    }

    public boolean isPrimera() {
        return primera;
    }

    public void setPrimera(boolean primera) {
        this.primera = primera;
    }
    
    public void comparar(){
        if (numero == numeroAdivinar && primera){
            estado = "¡Atino a la primera!";
            premio += 100000;
        }
        else if (numero == numeroAdivinar && !primera){
            estado = "¡Atino!";
        }
        else{
            intentos -= 1;
            premio -= 10000;
            if (intentos < 0 || premio < 0){reiniciar();}
            primera = false;
            estado = "¡Vuelva a intentar!";
        }
    }
    
    public void reiniciar(){
        numeroAdivinar = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        numero = 0;
        intentos = 5;
        premio = 50000;
        primera = true;
        estado = "";
    }
}
