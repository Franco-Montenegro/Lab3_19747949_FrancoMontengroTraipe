package org.example;

public class CardComunidad_FrancoMontenegroTraipe_19747949 extends Card_FrancoMontenegroTraipe_19747949 {

    public CardComunidad_FrancoMontenegroTraipe_19747949(int id, String descripcion) {
        super(id, descripcion);
    }
    @Override
    public void accion(Player_FrancoMontenegroTraipe_19747949 jugador, Game_FrancoMontenegroTraipe_19747949 juego) {
        System.out.println("Carta Comunidad: " + descripcion);
    }
    @Override
    public void ejecutarAccion(Game_FrancoMontenegroTraipe_19747949 game, Player_FrancoMontenegroTraipe_19747949 jugador) {
        jugador.setDinero(jugador.getDinero() + 200);
        System.out.println(jugador.getNombre() + " recibe $200.");
    }
    @Override
    public String toString() {
        return "[COMUNIDAD] " + super.toString();
    }

}
