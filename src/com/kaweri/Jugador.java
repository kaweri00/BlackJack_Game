package com.kaweri;

public class Jugador extends ActorDelJuego {

    private float credito;
    private float montoApuesta;
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public enum Estado { GANA, GANA_BJ, EMPATA, PIERDE }

    Jugador( String nombre ){
        super( nombre );
        credito = 2000;
        estado = null;
    }

    public float getCredito() {
        return credito;
    }

    float getMontoApuesta() {
        return montoApuesta;
    }

    void apostar( float apuesta){
        float montoApuesta = apuesta;
        if (montoApuesta <= 0 ){ montoApuesta = 10; }
        montoApuesta += montoApuesta;
        credito -= montoApuesta;
    }

    boolean puedeDoblar(){
        return getValorMano() >= 9 && getValorMano() <= 11 && credito >= montoApuesta;
    }

    public void limpiarManoApuestas(){
        getMano().limpiarMano();
        montoApuesta = 0;
    }

    @Override
    public String toString() {
        return String.format( "%s, actualmente tiene un credito de $%.2f\n", getNombre(), credito);
    }
}
