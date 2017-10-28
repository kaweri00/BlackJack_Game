package com.kaweri;

import java.util.ArrayList;

/**
 * @author Julian Henao
 * @since 10/10/2017
 * @version 1.0
 */
public class Mano {

    private ArrayList<Carta> mano;
    private int valor;
    private byte asesBlandos;

    Mano(){
        this.mano = new ArrayList<>();
        this.valor = 0;
        this.asesBlandos = 0;
    }

    int getValor() {
        return valor;
    }

    public boolean esBlackJack() {
        return (mano.size() == 2) && (valor == 21);
    }


    void anadirCarta( Carta carta ){
        mano.add( carta );
        valor += carta.getValor();
        if( esAs(carta)){
            asesBlandos++;
        }
        if( getValor() > 21 && esBlanda()){
            setAs_a_uno();
        }
    }

    private void setAs_a_uno(){
        this.valor -= 10;
        this.asesBlandos--;
    }

    protected boolean esBlanda(){
            return this.asesBlandos > 0;
    }

    private boolean esAs( Carta carta){
        return carta.getValor() == 11;
    }

    private boolean tieneCartas(){
        boolean hayCartas = false;
        if( mano.size() > 0){
            hayCartas = true;
        }
        return hayCartas;
    }

    void limpiarMano(){
        mano.clear();
        valor = 0;
        asesBlandos = 0;
    }

    @Override
    public String toString() {
        if( tieneCartas()){
            StringBuilder texto = new StringBuilder();
            for (Carta carta : mano) {
                texto.append(carta);
                texto.append("\n");
            }

            texto.append( "    Valor : ");
            texto.append(getValor());
            if( esBlanda()){
                texto.append(" Blando\n");
            }else{
                texto.append(" Duro\n");
            }
            return texto.toString();
        }
        else{ return "¡No tiene cartas!\n"; }
    }

}
