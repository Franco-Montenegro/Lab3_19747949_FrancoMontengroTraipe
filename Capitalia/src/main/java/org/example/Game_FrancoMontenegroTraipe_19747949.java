package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game_FrancoMontenegroTraipe_19747949 {

    private List<Player_FrancoMontenegroTraipe_19747949> jugadores;
    private int dineroBanco;
    private int numeroDados;
    private int turnoActual;
    private int tasaImpuesto;
    private int maximoCasas;
    private int maximoHoteles;
    private Board_FrancoMontenegroTraipe_19747949 tablero;

    public Game_FrancoMontenegroTraipe_19747949(int dineroBanco, int numeroDados, int tasaImpuesto,
                                                int maximoCasas, int maximoHoteles, Board_FrancoMontenegroTraipe_19747949 tablero) {

        this.dineroBanco = dineroBanco;
        this.numeroDados = numeroDados;
        this.tasaImpuesto = tasaImpuesto;
        this.maximoCasas = maximoCasas;
        this.maximoHoteles = maximoHoteles;
        this.jugadores = new ArrayList<>();
        this.tablero = tablero;
        this.turnoActual = 0;
    }

    public List<Player_FrancoMontenegroTraipe_19747949> getJugadores() {
        return jugadores;
    }
    public Player_FrancoMontenegroTraipe_19747949 getJugadorActual() {
        return jugadores.get(turnoActual);
    }
    public boolean agregarJugador(int id, String nombre) {
        if (dineroBanco >= 1500) {
            Player_FrancoMontenegroTraipe_19747949 nuevo = new Player_FrancoMontenegroTraipe_19747949(id, nombre, 1500, new ArrayList<>(), 0, false, 0);
            jugadores.add(nuevo);
            dineroBanco -= 1500;

            if (jugadores.size() == 1) {
                turnoActual = 0;
            }
            return true;
        }
        return false;
    }


    public Player_FrancoMontenegroTraipe_19747949 obtenerJugadorActual() {
        if (turnoActual < jugadores.size()) {
            return jugadores.get(turnoActual);
        }
        return null;
    }

    public boolean comprarPropiedadActual() {
        Player_FrancoMontenegroTraipe_19747949 jugador = obtenerJugadorActual();
        if (jugador == null) return false;

        int posicion = jugador.getPosicionActual();
        Property_FrancoMontenegroTraipe_19747949 propiedad = tablero.getPropiedadEn(posicion);

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
        Player_FrancoMontenegroTraipe_19747949 actual = obtenerJugadorActual();
        if (actual == null) return;

        int posActual = actual.getPosicionActual();
        int total = tablero.getTotalCasillas();

        int nuevaPos = (posActual + pasos) % total;
        actual.setPosicionActual(nuevaPos);
    }

    public int calcularRentaPropiedadActual() {
        Player_FrancoMontenegroTraipe_19747949 jugador = obtenerJugadorActual();
        Property_FrancoMontenegroTraipe_19747949 propiedad = tablero.getPropiedadEn(jugador.getPosicionActual());

        if (propiedad == null || propiedad.getDueno() == null) return 0;

        return propiedad.calcularRenta(maximoCasas);
    }

    public int calcularRentaPropiedad(Property_FrancoMontenegroTraipe_19747949 propiedad) {
        if (propiedad.getEstaHipotecada()) return 0;

        int valorBase = propiedad.getPrecio();
        int casas = propiedad.getCasas();
        boolean tieneHotel = propiedad.esHotel();

        if (tieneHotel) {
            double rentaConCasas = valorBase * (1 + 0.2 * maximoCasas);
            return (int) (rentaConCasas * 2);
        } else {
            return (int) (valorBase * (1 + 0.2 * casas));
        }
    }
    public int calcularRentaJugadorActual() {
        Player_FrancoMontenegroTraipe_19747949 jugador = obtenerJugadorActual();
        return calcularRentaTotalJugador(jugador);
    }
    public int calcularRentaTotalJugador(Player_FrancoMontenegroTraipe_19747949 jugador) {
        int total = 0;
        for (Property_FrancoMontenegroTraipe_19747949 p : jugador.getPropiedades()) {
            total += p.calcularRenta(maximoCasas);
        }
        return total;
    }
    public boolean construirHotelEnPosicionActual() {
        Player_FrancoMontenegroTraipe_19747949 jugador = obtenerJugadorActual();
        int pos = jugador.getPosicionActual();
        Property_FrancoMontenegroTraipe_19747949 propiedad = tablero.getPropiedadEn(pos);

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

        Hotel_FrancoMontenegroTraipe_19747949 hotel = new Hotel_FrancoMontenegroTraipe_19747949(
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
        Player_FrancoMontenegroTraipe_19747949 jugador = obtenerJugadorActual();
        int posicion = jugador.getPosicionActual();

        Property_FrancoMontenegroTraipe_19747949 propiedad = tablero.getPropiedadEn(posicion);
        if (propiedad == null || propiedad.getDueno() == null) {
            System.out.println("No hay renta que pagar en esta casilla.");
            return false;
        }

        Player_FrancoMontenegroTraipe_19747949 duenio = propiedad.getDueno();

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
    public void pagarRenta(Player_FrancoMontenegroTraipe_19747949 dueno, int monto) {
        Player_FrancoMontenegroTraipe_19747949 jugador = obtenerJugadorActual();
        if (jugador.getDinero() < monto) {
            monto = jugador.getDinero();
        }
        jugador.setDinero(jugador.getDinero() - monto);
        dueno.setDinero(dueno.getDinero() + monto);
    }

    public boolean hipotecarPropiedadActual() {
        Player_FrancoMontenegroTraipe_19747949 jugador = obtenerJugadorActual();
        int posicion = jugador.getPosicionActual();
        Property_FrancoMontenegroTraipe_19747949 propiedad = tablero.getPropiedadEn(posicion);

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
    public Card_FrancoMontenegroTraipe_19747949 extraerCarta() {
        Player_FrancoMontenegroTraipe_19747949 jugador = obtenerJugadorActual();
        int posicion = jugador.getPosicionActual();
        if (posicion == tablero.getPosicionComunidad()) {
            CardComunidad_FrancoMontenegroTraipe_19747949 carta = tablero.obtenerCartaComunidadAleatoria();
            System.out.println("Carta Comunidad: " + carta.getDescripcion());
            return carta;
        } else if (posicion == tablero.getPosicionSuerte()) {
            CardSuerte_FrancoMontenegroTraipe_19747949 carta = tablero.obtenerCartaSuerteAleatoria();
            System.out.println("Carta Suerte: " + carta.getDescripcion());
            return carta;
        }
        System.out.println("No estás en una casilla de suerte ni comunidad.");
        return null;
    }
    public boolean estaEnBancarrotaJugadorActual(Player_FrancoMontenegroTraipe_19747949 jugador) {
        return jugador.getDinero() <= 0;
    }
    public void avanzarTurno() {
        if (jugadores.size() == 0) return;
        turnoActual = (turnoActual + 1) % jugadores.size();
    }
    public void pagarImpuestoPorPropiedades(Player_FrancoMontenegroTraipe_19747949 jugador) {
        int impuestoTotal = 0;

        for (Property_FrancoMontenegroTraipe_19747949 propiedad : jugador.getPropiedades()) {
            int valorBase = propiedad.getPrecio();
            int casas = propiedad.getCasas();
            boolean hotel = propiedad.esHotel();

            double valorConstruccion = valorBase * (1 + 0.2 * casas);
            if (hotel) {
                valorConstruccion = valorBase * (1 + 0.2 * maximoCasas) * 2;
            }
            int impuesto = (int) (valorConstruccion * tasaImpuesto / 100.0);
            impuestoTotal += impuesto;
        }
        jugador.setDinero(jugador.getDinero() - impuestoTotal);
        dineroBanco += impuestoTotal;
        System.out.println(jugador.getNombre() + " ha pagado $" + impuestoTotal + " en impuestos.");
    }
    public void eliminarJugador(Player_FrancoMontenegroTraipe_19747949 jugador) {
        for (Property_FrancoMontenegroTraipe_19747949 propiedad : jugador.getPropiedades()) {
            propiedad.setDueno(null);
        }
        jugador.getPropiedades().clear();
        jugadores.remove(jugador);
        if (turnoActual >= jugadores.size()) {
            turnoActual = 0;
        }

        System.out.println("El jugador " + jugador.getNombre() + " ha sido eliminado del juego.");
    }

    public void jugarTurno() {
        Player_FrancoMontenegroTraipe_19747949 jugador = obtenerJugadorActual();
        if (jugador == null) {
            System.out.println("Jugador actual es null");
        } else {
            System.out.println("Jugador actual: " + jugador.getNombre());
        }
        System.out.println("\n>>> Turno de: " + jugador.getNombre());
        if (jugador.isEstaEnCarcel()) {
            System.out.println(jugador.getNombre() + " está en la cárcel y pierde el turno.");
            avanzarTurno();
            return;
        }
        int[] dados = lanzarDados();
        int suma = 0;
        for (int i = 0; i < dados.length; i++) {
            suma += dados[i];
        }
        System.out.print("Dados: ");
        for (int d : dados) System.out.print(d + " ");
        System.out.println("-> Total: " + suma);

        int posicionAntes = jugador.getPosicionActual();
        moverJugadorActual(suma);
        int posicionActual = jugador.getPosicionActual();
        System.out.println(jugador.getNombre() + " se mueve de " + posicionAntes + " a " + posicionActual);

        if (posicionAntes > posicionActual) {
            pagarImpuestoPorPropiedades(jugador);
        }
        Property_FrancoMontenegroTraipe_19747949 propiedad = tablero.getPropiedadEn(posicionActual);
        if (propiedad != null) {
            if (propiedad.getDueno() == null) {
                System.out.println("Propiedad sin dueño: " + propiedad.getNombre() +
                        " ($" + propiedad.getPrecio() + "). ¿Comprar? (S/N)");

                Scanner sc = new Scanner(System.in);
                String opcion = sc.nextLine().trim();
                if (opcion.equalsIgnoreCase("S")) {
                    comprarPropiedadActual();
                }
            } else if (!propiedad.getDueno().equals(jugador) && !propiedad.getEstaHipotecada()) {
                int renta = calcularRentaPropiedad(propiedad);
                System.out.println("Debes pagar $" + renta + " de renta a " + propiedad.getDueno().getNombre());
                pagarRenta(propiedad.getDueno(), renta);
            } else {
                System.out.println("No se realiza ninguna acción con la propiedad.");
            }
        } else {
            Card_FrancoMontenegroTraipe_19747949 carta = extraerCarta();
        }
        if (estaEnBancarrotaJugadorActual(jugador)) {
            System.out.println(jugador.getNombre() + " ha caído en bancarrota.");
            eliminarJugador(jugador);
        }
        avanzarTurno();
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
        for (Player_FrancoMontenegroTraipe_19747949 jugador : jugadores) {
            sb.append(jugador).append("\n");
        }
        sb.append("\n>>> Tablero:\n");
        sb.append(tablero);
        return sb.toString();
    }
    public void imprimirEstado() {
        System.out.println(this);
    }



}
