package com.kaweri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @author Julian Henao
 * @since 10/10/2017
 * @version 1.0
 */
public class Repartidor {

    private Stack<Carta> bandejaSalida;

    public Repartidor(){
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
        bandejaSalida.addAll(barajar( receptor ));
    }

    private void vaciar(){
        if( tieneCartas() ){
            bandejaSalida.clear();
        }
    }

    private ArrayList<Carta> barajar( ArrayList<Carta> barajasOrdenadas){
        Random random = new Random();
        ArrayList<Carta> salidaMezclador = new ArrayList<>();
        while( barajasOrdenadas.size() > 0){
            salidaMezclador.add( barajasOrdenadas.remove( random.nextInt( barajasOrdenadas.size() ) ) );
        }
        return salidaMezclador;
    }

    private int validarCantidadBarajas(int barajasEntrantes){
        int BARAJASMINIMAS = 1;
        int BARAJASMAXIMAS = 8;
        return ( barajasEntrantes >= BARAJASMINIMAS && barajasEntrantes <= BARAJASMAXIMAS)? barajasEntrantes: 1;
    }

    Carta reparte(){
        return bandejaSalida.pop();
    }
}