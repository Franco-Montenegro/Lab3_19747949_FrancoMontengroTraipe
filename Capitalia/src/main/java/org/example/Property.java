package org.example;

public class Property {
    private int id;
    private String nombre;
    private int precio;
    private int renta;
    private Player dueno;
    private int casas;
    private boolean estaHipotecada;

    public Property(int id, String nombre, int precio, int renta, Player dueno, int casas, boolean estaHipotecada) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.renta = renta;
        this.dueno = dueno;
        this.casas = casas;
        this.estaHipotecada = estaHipotecada;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getRenta() {
        return renta;
    }

    public void setRenta(int renta) {
        this.renta = renta;
    }

    public Player getDueno() {
        return dueno;
    }

    public void setDueno(Player dueno) {
        this.dueno = dueno;
    }

    public int getCasas() {
        return casas;
    }

    public void setCasas(int casas) {
        this.casas = casas;
    }

    public boolean isEstaHipotecada() {
        return estaHipotecada;
    }

    public void setEstaHipotecada(boolean estaHipotecada) {
        this.estaHipotecada = estaHipotecada;
    }

    @Override
    public String toString() {
        return "Propiedad #" + id + " - " + nombre +
                " | Precio: $" + precio +
                " | Renta base: $" + renta +
                " | Dueño: " + (dueno != null ? dueno.getNombre() : "Sin dueño") +
                " | Casas: " + casas +
                " | Hipotecada: " + (estaHipotecada ? "Sí" : "No");
    }

}
