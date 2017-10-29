package com.kaweri;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @author Julian Henao
 * @since 10/10/2017
 * @version 1.0
 */
    class Repartidor {

    private Stack<Carta> bandejaSalida;

    Repartidor(){
        bandejaSalida = new Stack<>();
    }

    private boolean tieneCartas(){
        return !bandejaSalida.isEmpty();
    }

    void cargarBandejaEntrada( Carta[] baraja, int cantidadBarajas){
        vaciar();
        int barajasEntrantes = validarCantidadBarajas(cantidadBarajas);
        ArrayList<Carta> receptor = new ArrayList<>();
        for( int i = 1; i <= barajasEntrantes; i++ ){
            receptor.addAll( Arrays.asList( baraja ));
        }
        Collections.shuffle( receptor );
        bandejaSalida.addAll( receptor );
    }

    private void vaciar(){
        if( tieneCartas() ){
            bandejaSalida.clear();
        }
    }

    private int validarCantidadBarajas(int barajasEntrantes){
        final int BARAJASMINIMAS = 1;
        final int BARAJASMAXIMAS = 8;
        return ( barajasEntrantes >= BARAJASMINIMAS && barajasEntrantes <= BARAJASMAXIMAS)? barajasEntrantes: 1;
    }

    Carta reparte(){
        return bandejaSalida.pop();
    }

}