package org.example;

public class Hotel extends Property {
    public Hotel(int id, String nombre, int precio, int rentaBase, Player dueno, int casas, boolean estaHipotecada) {
        super(id, nombre, precio, rentaBase, dueno, casas, estaHipotecada);
        this.setCasas(0);
    }
}


