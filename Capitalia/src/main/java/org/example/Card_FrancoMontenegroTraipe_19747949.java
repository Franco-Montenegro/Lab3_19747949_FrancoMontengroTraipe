package org.example;

public abstract class Card_FrancoMontenegroTraipe_19747949 {
    protected int id;
    protected String descripcion;
    public Card_FrancoMontenegroTraipe_19747949(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    public abstract void ejecutarAccion(Game_FrancoMontenegroTraipe_19747949 game, Player_FrancoMontenegroTraipe_19747949 player);
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
    public abstract void accion(Player_FrancoMontenegroTraipe_19747949 jugador, Game_FrancoMontenegroTraipe_19747949 juego);
}


