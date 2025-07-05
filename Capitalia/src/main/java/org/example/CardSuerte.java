package org.example;

public class CardSuerte extends Card {

    public CardSuerte(int id, String descripcion) {
        super(id, descripcion);
    }

    @Override
    public void accion(Player jugador, Game juego) {
        System.out.println("Carta Suerte: " + descripcion);
    }
    @Override
    public String toString() {
        return "[SUERTE] " + super.toString();
    }

}
