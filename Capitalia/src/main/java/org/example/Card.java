package org.example;

public abstract class Card {
    protected int id;
    protected String descripcion;

    public Card(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    @Override
    public String toString() {
        return "Carta #" + id + " | " + descripcion;
    }
    /**
     * Ejecuta la acción de la carta sobre el jugador en el contexto del juego.
     */
    public abstract void accion(Player jugador, Game juego);
}


