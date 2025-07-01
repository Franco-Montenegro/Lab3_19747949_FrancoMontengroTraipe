package org.example;

import java.util.List;
import java.util.ArrayList;

public class Player {

    private int id;
    private String nombre;
    private int dinero;
    private List<Property> propiedades;
    private int posicionActual;
    private boolean estaEnCarcel;
    private int totalCartasSalirCarcel;

    public Player(int id, String nombre, int dinero, List<Property> propiedades, int posicionActual, boolean estaEnCarcel, int totalCartasSalirCarcel) {
        this.id = id;
        this.nombre = nombre;
        this.dinero = dinero;
        this.propiedades = (propiedades != null) ? propiedades : new ArrayList<>();
        this.posicionActual = posicionActual;
        this.estaEnCarcel = estaEnCarcel;
        this.totalCartasSalirCarcel = totalCartasSalirCarcel;
    }

    public int getTotalCartasSalirCarcel() {
        return totalCartasSalirCarcel;
    }

    public void setTotalCartasSalirCarcel(int totalCartasSalirCarcel) {
        this.totalCartasSalirCarcel = totalCartasSalirCarcel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public List<Property> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Property> propiedades) {
        this.propiedades = propiedades;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public boolean isEstaEnCarcel() {
        return estaEnCarcel;
    }

    public void setEstaEnCarcel(boolean estaEnCarcel) {
        this.estaEnCarcel = estaEnCarcel;
    }
    @Override
    public String toString() {
        return "Jugador: " + nombre +
                " | Dinero: $" + dinero +
                " | Posición: " + posicionActual +
                " | En cárcel: " + (estaEnCarcel ? "Sí" : "No") +
                " | Cartas Salir Cárcel: " + totalCartasSalirCarcel +
                " | Propiedades: " + propiedades.size();
    }

}
