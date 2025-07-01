package org.example;

import java.util.List;

public class Game {

    private List<Player> jugadores;
    private int dineroBanco;
    private int numeroDados;
    private int turnoActual;
    private int tasaImpuesto;
    private int maximoCasas;
    private int maximoHoteles;
    private Board tablero;

    public Game(List<Player> jugadores, int dineroBanco, int numeroDados, int tasaImpuesto,
                int maximoCasas, int maximoHoteles, Board tablero) {
        this.jugadores = jugadores;
        this.dineroBanco = dineroBanco;
        this.numeroDados = numeroDados;
        this.tasaImpuesto = tasaImpuesto;
        this.maximoCasas = maximoCasas;
        this.maximoHoteles = maximoHoteles;
        this.tablero = tablero;
        this.turnoActual = 0; // el juego comienza en el turno 0
    }

    public List<Player> getJugadores() {
        return jugadores;
    }
    public Player getJugadorActual() {
        return jugadores.get(turnoActual);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ESTADO DEL JUEGO CAPITALIA ===\n");
        sb.append("Dinero en el banco: $").append(dineroBanco).append("\n");
        sb.append("Cantidad de dados: ").append(numeroDados).append("\n");
        sb.append("Tasa de impuesto: ").append(tasaImpuesto).append("%\n");
        sb.append("Máximo de casas por propiedad: ").append(maximoCasas).append("\n");
        sb.append("Máximo de hoteles por propiedad: ").append(maximoHoteles).append("\n\n");

        sb.append(">>> Jugadores:\n");
        for (Player jugador : jugadores) {
            sb.append(jugador).append("\n");
        }

        sb.append("\n>>> Tablero:\n");
        sb.append(tablero); // asegúrate de que Board tenga también su toString()

        return sb.toString();
    }


}
