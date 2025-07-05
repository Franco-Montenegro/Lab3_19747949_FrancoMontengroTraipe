package org.example;

public class CardComunidad extends Card {

    public CardComunidad(int id, String descripcion) {
        super(id, descripcion);
    }

    @Override
    public void accion(Player jugador, Game juego) {
        System.out.println("Carta Comunidad: " + descripcion);
    }
    @Override
    public String toString() {
        return "[COMUNIDAD] " + super.toString();
    }

}
