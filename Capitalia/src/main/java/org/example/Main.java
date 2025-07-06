package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Game_FrancoMontenegroTraipe_19747949 juego = null;

            while (true) {
                System.out.println("\n### CAPITALIA - Menú Principal ###");
                System.out.println("1. Crear nuevo juego");
                System.out.println("2. Visualizar estado actual del tablero");
                System.out.println("3. Realizar turno");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                String opcion = sc.nextLine().trim();

                switch (opcion) {
                    case "1":
                        System.out.println("\n--- Crear Nuevo Juego ---");

                        System.out.print("Ingrese cantidad de dados (mínimo 2): ");
                        int dados = Integer.parseInt(sc.nextLine());
                        if (dados < 2) dados = 2;

                        Board_FrancoMontenegroTraipe_19747949 board = new Board_FrancoMontenegroTraipe_19747949();
                        board.cargarDatosIniciales();

                        juego = new Game_FrancoMontenegroTraipe_19747949(20000, dados, 10, 4, 2, board);

                        System.out.print("Ingrese nombre del jugador 1: ");
                        String nombre1 = sc.nextLine();
                        int id1 = juego.getJugadores().size() + 1;
                        if (juego.agregarJugador(id1, nombre1)) {
                            System.out.println("Jugador agregado exitosamente.");
                        } else {
                            System.out.println("No fue posible agregar jugador (¿dinero insuficiente?).");
                        }

                        System.out.print("Ingrese nombre del jugador 2: ");
                        String nombre2 = sc.nextLine();
                        int id2 = juego.getJugadores().size() + 1;
                        if (juego.agregarJugador(id2, nombre2)) {
                            System.out.println("Jugador agregado exitosamente.");
                        } else {
                            System.out.println("No fue posible agregar jugador (¿dinero insuficiente?).");
                        }
                        System.out.println(">>> Lista de jugadores:");
                        for (int i = 0; i < juego.getJugadores().size(); i++) {
                            Player_FrancoMontenegroTraipe_19747949 jugador = juego.getJugadores().get(i);
                            if (jugador == null) {
                                System.out.println("Jugador en índice " + i + " es NULL");
                            } else {
                                System.out.println("Jugador en índice " + i + ": " + jugador.getNombre() + " | ID: " + jugador.getId());
                            }
                        }
                        System.out.println("¡Juego creado exitosamente!");
                        break;

                    case "2":
                        if (juego == null) {
                            System.out.println("Primero debe crear un juego.");
                        } else {
                            juego.imprimirEstado();
                        }
                        break;

                    case "3":
                        if (juego == null) {
                            System.out.println("Primero debe crear un juego.");
                        } else {
                            juego.jugarTurno();
                        }
                        break;

                    case "4":
                        System.out.print("¿Está seguro que desea salir? (S/N): ");
                        String confirmacion = sc.nextLine().trim();
                        if (confirmacion.equalsIgnoreCase("S")) {
                            System.out.println("¡Gracias por jugar CAPITALIA!");
                            return;
                        }
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error en tiempo de ejecución: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
