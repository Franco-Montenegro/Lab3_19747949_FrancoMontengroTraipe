package org.example;

public class Hotel_FrancoMontenegroTraipe_19747949 extends Property_FrancoMontenegroTraipe_19747949 {
    public Hotel_FrancoMontenegroTraipe_19747949(int id, String nombre, int precio, int rentaBase, Player_FrancoMontenegroTraipe_19747949 dueno, int casas, boolean estaHipotecada) {
        super(id, nombre, precio, rentaBase, dueno, casas, estaHipotecada);
        this.setCasas(0);
    }

    @Override
    public boolean esHotel() {
        return true;
    }
}


