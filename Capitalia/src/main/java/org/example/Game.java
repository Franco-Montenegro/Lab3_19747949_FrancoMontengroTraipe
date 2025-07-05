package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private List<Player> jugadores;
    private int dineroBanco;
    private int numeroDados;
    private int turnoActual;
    private int tasaImpuesto;
    private int maximoCasas;
    private int maximoHoteles;
    private Board tablero;

    public Game(int dineroBanco, int numeroDados, int tasaImpuesto,
                int maximoCasas, int maximoHoteles, Board tablero) {

        this.dineroBanco = dineroBanco;
        this.numeroDados = numeroDados;
        this.tasaImpuesto = tasaImpuesto;
        this.maximoCasas = maximoCasas;
        this.maximoHoteles = maximoHoteles;
        this.jugadores = new ArrayList<>();
        this.tablero = tablero;
        this.turnoActual = 0;
    }

    public List<Player> getJugadores() {
        return jugadores;
    }
    public Player getJugadorActual() {
        return jugadores.get(turnoActual);
    }
    public boolean agregarJugador(int id, String nombre) {
        if (dineroBanco >= 1500) {
            Player nuevo = new Player(id, nombre, 1500, new ArrayList<>(), 0, false, 0);
            jugadores.add(nuevo);
            dineroBanco -= 1500;

            if (jugadores.size() == 1) {
                turnoActual = nuevo.getId();
            }
            return true;
        }
        return false;
    }

    public Player obtenerJugadorActual() {
        for (Player p : jugadores) {
            if (p.getId() == turnoActual) {
                return p;
            }
        }
        return null;
    }

    public boolean comprarPropiedadActual() {
        Player jugador = obtenerJugadorActual();
        if (jugador == null) return false;

        int posicion = jugador.getPosicionActual();
        Property propiedad = tablero.getPropiedadEn(posicion);

        if (propiedad == null) {
            System.out.println("No hay propiedad en esta posición.");
            return false;
        }

        if (propiedad.getDueno() != null) {
            System.out.println("La propiedad ya tiene dueño.");
            return false;
        }

        int precio = propiedad.getPrecio();
        if (jugador.getDinero() < precio) {
            System.out.println("No tienes suficiente dinero para comprar esta propiedad.");
            return false;
        }

        // Realizar compra
        jugador.setDinero(jugador.getDinero() - precio);
        propiedad.setDueno(jugador);
        jugador.getPropiedades().add(propiedad);

        System.out.println("¡Propiedad comprada con éxito!");
        return true;
    }

    public int[] lanzarDados() {
        int[] resultados = new int[numeroDados];
        Random random = new Random();

        for (int i = 0; i < numeroDados; i++) {
            resultados[i] = random.nextInt(6) + 1;
        }
        return resultados;
    }
    public void moverJugadorActual(int pasos) {
        Player actual = obtenerJugadorActual();
        if (actual == null) return;

        int posActual = actual.getPosicionActual();
        int total = tablero.getTotalCasillas();

        int nuevaPos = (posActual + pasos) % total;
        actual.setPosicionActual(nuevaPos);
    }

    public int calcularRentaPropiedadActual() {
        Player jugador = obtenerJugadorActual();
        Property propiedad = tablero.getPropiedadEn(jugador.getPosicionActual());

        if (propiedad == null || propiedad.getDueno() == null) return 0;

        return propiedad.calcularRenta(maximoCasas);
    }
    public int calcularRentaJugadorActual() {
        Player jugador = obtenerJugadorActual();
        return calcularRentaTotalJugador(jugador);
    }

    public int calcularRentaTotalJugador(Player jugador) {
        int total = 0;
        for (Property p : jugador.getPropiedades()) {
            total += p.calcularRenta(maximoCasas);
        }
        return total;
    }
    public boolean construirHotelEnPosicionActual() {
        Player jugador = obtenerJugadorActual();
        int pos = jugador.getPosicionActual();
        Property propiedad = tablero.getPropiedadEn(pos);

        if (propiedad == null) {
            System.out.println("No hay propiedad en esta posición.");
            return false;
        }

        if (!jugador.getPropiedades().contains(propiedad)) {
            System.out.println("No eres dueño de esta propiedad.");
            return false;
        }

        if (!propiedad.puedeConstruirHotel(maximoCasas)) {
            System.out.println("No puedes construir hotel: necesitas el máximo de casas.");
            return false;
        }

        Hotel hotel = new Hotel(
                propiedad.getId(),
                propiedad.getNombre(),
                propiedad.getPrecio(),
                propiedad.getRenta(),
                jugador,
                0,
                propiedad.getEstaHipotecada()
        );

        jugador.getPropiedades().remove(propiedad);
        jugador.getPropiedades().add(hotel);
        tablero.reemplazarPropiedad(hotel);

        System.out.println("Hotel construido con éxito.");
        return true;
    }
    public boolean pagarRenta() {
        Player jugador = obtenerJugadorActual();
        int posicion = jugador.getPosicionActual();

        Property propiedad = tablero.getPropiedadEn(posicion);
        if (propiedad == null || propiedad.getDueno() == null) {
            System.out.println("No hay renta que pagar en esta casilla.");
            return false;
        }

        Player duenio = propiedad.getDueno();

        if (duenio.getId() == jugador.getId()) {
            System.out.println("Esta propiedad es tuya, no pagas renta.");
            return false;
        }

        if (propiedad.getEstaHipotecada()) {
            System.out.println("La propiedad está hipotecada, no se cobra renta.");
            return false;
        }

        int renta = propiedad.calcularRenta(maximoCasas);

        if (jugador.getDinero() < renta) {
            System.out.println("No tienes suficiente dinero para pagar la renta.");
            return false;
        }

        jugador.setDinero(jugador.getDinero() - renta);
        duenio.setDinero(duenio.getDinero() + renta);

        System.out.println(jugador.getNombre() + " pagó $" + renta + " a " + duenio.getNombre());
        return true;
    }
    public boolean hipotecarPropiedadActual() {
        Player jugador = obtenerJugadorActual();
        int posicion = jugador.getPosicionActual();
        Property propiedad = tablero.getPropiedadEn(posicion);

        if (propiedad == null) {
            System.out.println("No hay propiedad en esta posición.");
            return false;
        }

        if (!jugador.getPropiedades().contains(propiedad)) {
            System.out.println("No eres dueño de esta propiedad.");
            return false;
        }

        if (propiedad.getEstaHipotecada()) {
            System.out.println("La propiedad ya está hipotecada.");
            return false;
        }

        int monto = propiedad.getPrecio();
        propiedad.setEstaHipotecada(true);
        jugador.setDinero(jugador.getDinero() + monto);
        dineroBanco -= monto;

        System.out.println("Propiedad hipotecada. Recibes $" + monto + " del banco.");
        return true;
    }
    public void extraerCarta() {
        Player jugador = obtenerJugadorActual();
        int posicion = jugador.getPosicionActual();

        if (posicion == tablero.getPosicionComunidad()) {
            CardComunidad carta = tablero.obtenerCartaComunidadAleatoria();
            System.out.println("Carta Comunidad: " + carta.getDescripcion());

        } else if (posicion == tablero.getPosicionSuerte()) {
            CardSuerte carta = tablero.obtenerCartaSuerteAleatoria();
            System.out.println("Carta Suerte: " + carta.getDescripcion());

        } else {
            System.out.println("No estás en una casilla de suerte ni comunidad.");
        }
    }
    public boolean estaEnBancarrotaJugadorActual() {
        Player jugador = obtenerJugadorActual();
        return jugador.getDinero() <= 0;
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
        sb.append(tablero);

        return sb.toString();
    }


}
