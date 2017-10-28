package com.kaweri;

/**
 * Clase Carta
 * Esta clase define objetos tipo carta de naipes con un palo, un rango y un valor.
 * Se diseno ser usada en juegos de azar y con distintos tipos de baraja.
 * @author Julian Henao
 * @since 19/10/2017
 * @version 1.0
 */
public class Carta {

    //Campos de la clase
    private final String rango;
    private final String palo;
    private final int valor;

    /**
     *Constructor unico de Carta
     * @param rango Define el rango de la carta { As, dos, rey...}
     * @param palo Define el palo de la carta { Treboles, Picas...}
     * @param valor Define el valor numerico de la carta
     */
    Carta(String rango, String palo, int valor) {
        this.rango = rango;
        this.palo = palo;
        this.valor = valor;
    }

    /**
     * Metodo que devuelve el rango de la carta
     * Usado solo para el metodo toString de la clase
     * @return Rango de la carta
     */
    private String getRango() {
        return rango;
    }

    /**
     * Metodo que devuelve el palo de la carta
     * Usado solo para el metodo toString de la clase
     * @return Palo de la carta
     */
    private String getPalo() {
        return palo;
    }

    /**
     * Metodo que devuelve el valor numerico de la carta
     * @return valor int de la carta
     */
    int getValor() {
        return valor;
    }

    /**
     * Metodo toString para la clase
     * @return Devuelve la carta con el formato "RANGO de PALO"  Ejm: "CUATRO de DIAMANTES"
     */
    @Override
    public String toString(){
        return String.format("%-6s de %s", getRango(), getPalo());
    }
}
