package org.example;

public class Property_FrancoMontenegroTraipe_19747949 {
    private int id;
    private String nombre;
    private int precio;
    private int renta;
    private Player_FrancoMontenegroTraipe_19747949 dueno;
    private int casas;
    private boolean estaHipotecada;

    public Property_FrancoMontenegroTraipe_19747949(int id, String nombre, int precio, int renta, Player_FrancoMontenegroTraipe_19747949 dueno, int casas, boolean estaHipotecada) {
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

    public Player_FrancoMontenegroTraipe_19747949 getDueno() {
        return dueno;
    }

    public void setDueno(Player_FrancoMontenegroTraipe_19747949 dueno) {
        this.dueno = dueno;
    }

    public int getCasas() {
        return casas;
    }

    public void setCasas(int casas) {
        this.casas = casas;
    }

    public boolean getEstaHipotecada() {
        return estaHipotecada;
    }

    public void setEstaHipotecada(boolean estaHipotecada) {
        this.estaHipotecada = estaHipotecada;
    }
    public boolean esHotel() {
        return false;
    }

    public int calcularRenta(int maximoCasas) {
        if (estaHipotecada) return 0;

        int base = precio;

        if (casas > 0 && casas < maximoCasas) {
            return (int) (base + (base * 0.2 * casas));
        }

        if (casas == maximoCasas && !esHotel()) {
            return (int) (base + (base * 0.2 * casas));
        }

        if (esHotel()) {
            double rentaConCasas = base + (base * 0.2 * maximoCasas);
            return (int) (rentaConCasas * 2);
        }

        return base;
    }
    public boolean puedeConstruirHotel(int maximoCasas) {
        return !esHotel() && casas == maximoCasas;
    }

    public void construirHotel() {
        casas = 0;
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
