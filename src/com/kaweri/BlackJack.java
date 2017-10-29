package com.kaweri;

import java.util.Scanner;

public class BlackJack {

    private Jugador jugador;
    private Crupier crupier;
    private Repartidor repartidor;
    private BarajaFrancesa barajaFrancesa;
    private boolean continua;

    public BlackJack( String nombreJugador, int cantidadDeBarajas){
        jugador = new Jugador( nombreJugador );
        crupier = new Crupier();
        barajaFrancesa = new BarajaFrancesa();
        repartidor = new Repartidor();
        repartidor.cargarBandejaEntrada( barajaFrancesa.getMazo(), cantidadDeBarajas);
        continua = true;
    }

    private void apuestas(){
        Scanner entrada = new Scanner( System.in );
        System.out.print( "Cuanto credito desea apostar?: $");
        jugador.apostar( entrada.nextFloat() );
        System.out.println();
    }

    private void repartirMano(){
        jugador.recibirCarta( repartidor.reparte());
        jugador.recibirCarta( repartidor.reparte());
        jugador.mostrarMano();
        crupier.recibirCarta( repartidor.reparte());
        crupier.mostrarMano();
    }

    private void jugadaConBlackJack(){
        if ( jugador.getMano().esBlackJack()){
            if ( crupier.getMano().getValor() == 10 || crupier.getMano().getValor() == 11 ){
                crupier.recibirCarta( repartidor.reparte() );
                crupier.mostrarMano();
                if (crupier.getMano().esBlackJack() ){ jugador.setEstado( Jugador.Estado.EMPATA ); }
                else{ jugador.setEstado( Jugador.Estado.GANA_BJ);}
            } else { jugador.setEstado( Jugador.Estado.GANA_BJ ); }
            continua = false;
        }
    }

    private void doblar(){
        if(jugador.puedeDoblar()){
            Scanner entrada = new Scanner( System.in );
            System.out.print( "Desea doblar su apuesta? s/n: ");
            String doblar = entrada.nextLine();
            System.out.println();
            if(doblar.equals("s")){
                jugador.apostar( jugador.getMontoApuesta() );
                jugador.recibirCarta( repartidor.reparte() );
                jugador.mostrarMano();
                if( jugador.getMano().getValor() > 21 ){ jugador.setEstado( Jugador.Estado.PIERDE ); }
                else{
                    jugadaCrupier();
                    compararManos();
                }

                continua = false;
            }
        }
    }

    private void pedirCarta(){
        boolean otraCarta = true;
        while ( jugador.getMano().getValor() < 21 && otraCarta){
            System.out.print("Desea recibir otra carta? s/n: ");
            Scanner entrada = new Scanner( System.in );
            String eleccionUsuario = entrada.nextLine();
            System.out.println();

            if (eleccionUsuario.equals("s")){
                jugador.getMano().anadirCarta( repartidor.reparte() );
                jugador.mostrarMano();
                if (jugador.getMano().getValor() > 21) {
                    jugador.setEstado(Jugador.Estado.PIERDE);
                    continua = false;
                }
            }else{
                otraCarta = false;
            }
        }
    }

    private void jugadaCrupier(){
        while ( crupier.getMano().getValor() <= 16 ){
            crupier.recibirCarta( repartidor.reparte() );
        }
        crupier.mostrarMano();
    }

    private void compararManos(){
        if ( crupier.getMano().getValor() > 21){
            jugador.setEstado( Jugador.Estado.GANA );
        }
        else if ( crupier.getMano().getValor() < jugador.getMano().getValor()){
            jugador.setEstado( Jugador.Estado.GANA);
        }
        else if ( crupier.getMano().esBlackJack()){
            jugador.setEstado( Jugador.Estado.PIERDE);
        }
        else if ( crupier.getMano().getValor() == jugador.getMano().getValor() ){
            jugador.setEstado( Jugador.Estado.EMPATA );
        }
        else {
            jugador.setEstado( Jugador.Estado.PIERDE );
        }
    }

    private void levantarMesa(){
        switch ( jugador.getEstado() ){
            case GANA:
                System.out.println("Ganas la partida!");
                limpiarMesa();
                break;
            case GANA_BJ:
                System.out.println("Ganas la partida con BlackJack!");
                limpiarMesa();
                break;
            case PIERDE:
                System.out.println("Pierdes la partida!");
                limpiarMesa();
                break;
            case EMPATA:
                System.out.println("Empatas la partida con la casa!");
                limpiarMesa();
                break;
        }
    }

    private void limpiarMesa(){
        jugador.limpiarManoApuestas();
        crupier.getMano().limpiarMano();
        jugador.setEstado( null );
    }

    public void jugar(){
        continua = true;
        apuestas();
        repartirMano();
        jugadaConBlackJack();
        if (continua){ doblar(); }
        if (continua){ pedirCarta(); }
        if (continua){ jugadaCrupier();}
        if (continua){ compararManos(); }
        levantarMesa();
    }

    public static void main(String[] args) {
        BlackJack juego = new BlackJack( "Julian", 2);

        int juegos = 10;
        while ( juegos > 0){
            juego.jugar();
            juegos--;
        }


    }
}
