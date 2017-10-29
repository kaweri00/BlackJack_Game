package com.kaweri;

abstract class ActorDelJuego {

    private final String nombre;
    private Mano mano;

     ActorDelJuego( String nombre){
         this.nombre = nombre;
         mano = new Mano();
    }

    String getNombre() {
        return nombre;
    }

    Mano getMano(){
         return mano;
    }

    void recibirCarta( Carta carta){
        mano.anadirCarta(carta);
    }

    void mostrarMano(){
        System.out.println("Mano de " + nombre );
        System.out.println( mano );
    }

    int getValorMano(){
        return mano.getValor();
    }

}
