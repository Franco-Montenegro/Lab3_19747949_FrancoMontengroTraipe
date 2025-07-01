package org.example;

import java.util.List;
import java.util.Set;

public class Board {
    private List<Property> propiedades;
    private List<Card> cartasComunidad;
    private List<Card> cartasSuerte;
    private int posicionCarcel;
    private Set<Integer> posicionesComunidad;
    private Set<Integer> posicionesSuerte;

    public Board(List<Property> propiedades, List<Card> cartasComunidad, List<Card> cartasSuerte,
                 int posicionCarcel, Set<Integer> posicionesComunidad, Set<Integer> posicionesSuerte) {
        this.propiedades = propiedades;
        this.cartasComunidad = cartasComunidad;
        this.cartasSuerte = cartasSuerte;
        this.posicionCarcel = posicionCarcel;
        this.posicionesComunidad = posicionesComunidad;
        this.posicionesSuerte = posicionesSuerte;
    }


    public void agregarPropiedad(Property propiedad) {
        propiedades.add(propiedad);
    }

    public void agregarCartaComunidad(Card carta) {
        cartasComunidad.add(carta);
    }

    public void agregarCartaSuerte(Card carta) {
        cartasSuerte.add(carta);
    }

    public void definirPosicionComunidad(int posicion) {
        posicionesComunidad.add(posicion);
    }

    public void definirPosicionSuerte(int posicion) {
        posicionesSuerte.add(posicion);
    }

    public boolean esCasillaSalida(int posicion) {
        return posicion == 0;
    }

    public boolean esCasillaCarcel(int posicion) {
        return posicion == posicionCarcel;
    }

    public boolean esCasillaComunidad(int posicion) {
        return posicionesComunidad.contains(posicion);
    }

    public boolean esCasillaSuerte(int posicion) {
        return posicionesSuerte.contains(posicion);
    }

    // Getters para listas y posición de cárcel
    public List<Property> getPropiedades() {
        return propiedades;
    }
    public List<Card> getCartasComunidad() {
        return cartasComunidad;
    }
    public List<Card> getCartasSuerte() {
        return cartasSuerte;
    }
    public int getPosicionCarcel() {
        return posicionCarcel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== TABLERO CAPITALIA ===\n");

        sb.append("\nPropiedades:\n");
        for (Property prop : propiedades) {
            sb.append(prop).append("\n"); // Asegúrate de tener toString en Property
        }

        sb.append("\nCartas de Comunidad:\n");
        for (Card carta : cartasComunidad) {
            sb.append(carta).append("\n"); // Usa toString de Card/CartaComunidad
        }

        sb.append("\nCartas de Suerte:\n");
        for (Card carta : cartasSuerte) {
            sb.append(carta).append("\n"); // Usa toString de Card/CartaSuerte
        }

        sb.append("\nPosiciones especiales:\n");
        sb.append("Posición de la Cárcel: ").append(posicionCarcel).append("\n");
        sb.append("Casillas de Comunidad: ").append(posicionesComunidad).append("\n");
        sb.append("Casillas de Suerte: ").append(posicionesSuerte).append("\n");

        return sb.toString();
    }


}
