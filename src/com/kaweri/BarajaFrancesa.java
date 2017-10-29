package com.kaweri;

/**
 *Clase BarajaFrancesa
 * Esta clase crea las 52 cartas de un Mazo Frances con Rango, Palo y les asigna su valor entero.
 * Se guardan en un arreglo tipo Carta.
 * @author Julian Henao
 * @since 19/10/2017
 * @version 1.0
 * @see Carta
 */
class BarajaFrancesa {

    //Campo de la clase
    private Carta[] mazo;

    enum Rango{ AS, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, DIEZ, JOTA, REINA, REY }
    enum Palo{ CORAZONES, DIAMANTES, PICAS, TREBOLES }

    /**
     * Constructor unico. Crea las 52 cartas y las asigna al campo "mazo" de la clase.
     */
    BarajaFrancesa(){
        nuevoMazo();
    }

    /**
     * Metodo para obtener la baraja almacenada en "mazo"
     * @return campo mazo ( 52 cartas ordenadas )
     */
    Carta[] getMazo(){
        return this.mazo;
    }

    /**
     * Crea la baraja con 52 cartas y las asigna al campo "mazo"
     */
    private void nuevoMazo(){
        int cantidadCartas = 0;
        Carta[] mazoNuevo = new Carta[52];
        for( Palo palo : Palo.values()){
            int contadorRango = 0;
            for( Rango rango : Rango.values()){
                mazoNuevo[cantidadCartas] = new Carta( rango, palo, asignarValorDeCarta(contadorRango));
                contadorRango++;
                cantidadCartas++;
            }
        }
        this.mazo = mazoNuevo;
    }

    /**
     * Metodo para asignar el valor entero de la carta segun su posicion en el palo.
     * Si el valor es 1(AS) asigna 11.
     * Si esta entre 2(DOS) y 9(NUEVE) asigna el valor del nombre { 2, 3, 4, 5, 6, 7, 8, 9 }
     * Si el valor es 10(DIEZ) o mas, asigna 10
     * @param posicionCarta Posicion de la carta dentro del palo
     * @return valor entero de la carta { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }
     */
    private int asignarValorDeCarta(int posicionCarta ){
        if( posicionCarta == 0 ){ return 11;}
        if( posicionCarta > 0 && posicionCarta < 10 ){ return posicionCarta + 1;}
        else{ return 10;}
    }

}
