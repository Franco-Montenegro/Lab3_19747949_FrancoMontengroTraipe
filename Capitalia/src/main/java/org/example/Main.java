package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game juego = null;

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- CAPITALIA - MENÚ PRINCIPAL ---");
            System.out.println("1. Crear nuevo juego");
            System.out.println("2. Agregar jugador");
            System.out.println("3. Lanzar dados");
            System.out.println("4. Mover jugador actual");
            System.out.println("5. Comprar propiedad");
            System.out.println("6. Calcular renta de propiedad actual");
            System.out.println("7. Calcular renta total del jugador actual");
            System.out.println("8. Construir hotel");
            System.out.println("9. Pagar renta");
            System.out.println("10. Hipotecar propiedad");
            System.out.println("11. Extraer carta (suerte o comunidad)");
            System.out.println("12. Verificar bancarrota del jugador actual");
            System.out.println("13. Mostrar estado del juego");
            System.out.println("14. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    Board board = new Board();
                    board.cargarDatosIniciales();

                    System.out.print("Ingrese número de dados (1 a 4): ");
                    int dados = Integer.parseInt(scanner.nextLine());

                    juego = new Game(20000,dados, 10, 4, 2, board); // ejemplo de parámetros
                    System.out.println("Juego creado con éxito.");
                    break;

                case "2":
                    if (juego == null) {
                        System.out.println("Debe crear primero un juego.");
                        break;
                    }

                    System.out.print("Ingrese nombre del jugador: ");
                    String nombre = scanner.nextLine();
                    int id = juego.getJugadores().size() + 1;
                    if (juego.agregarJugador(id, nombre)) {
                        System.out.println("Jugador agregado exitosamente.");
                    } else {
                        System.out.println("No fue posible agregar jugador (¿dinero insuficiente?).");
                    }
                    break;

                case "3":
                    if (juego == null) {
                        System.out.println("Debe crear primero un juego.");
                        break;
                    }

                    int[] dadosResultado = juego.lanzarDados();
                    int suma = 0;
                    System.out.print("Dados lanzados: ");
                    for (int d : dadosResultado) {
                        System.out.print(d + " ");
                        suma += d;
                    }
                    System.out.println("\nSuma total: " + suma);
                    break;

                case "4":
                    if (juego == null) break;
                    System.out.print("Ingrese cantidad de pasos a mover (por lo general, suma de dados): ");
                    int pasos = Integer.parseInt(scanner.nextLine());
                    juego.moverJugadorActual(pasos);
                    System.out.println("Jugador movido.");
                    break;

                case "5":
                    if (juego == null) break;
                    juego.comprarPropiedadActual();
                    break;

                case "6":
                    if (juego == null) break;
                    int renta = juego.calcularRentaPropiedadActual();
                    System.out.println("Renta de esta propiedad: $" + renta);
                    break;

                case "7":
                    if (juego == null) break;
                    int rentaTotal = juego.calcularRentaJugadorActual();
                    System.out.println("Renta total del jugador actual: $" + rentaTotal);
                    break;

                case "8":
                    if (juego == null) break;
                    juego.construirHotelEnPosicionActual();
                    break;

                case "9":
                    if (juego == null) break;
                    juego.pagarRenta();
                    break;

                case "10":
                    if (juego == null) break;
                    juego.hipotecarPropiedadActual();
                    break;

                case "11":
                    if (juego == null) break;
                    juego.extraerCarta();
                    break;

                case "12":
                    if (juego == null) break;
                    boolean bancarrota = juego.estaEnBancarrotaJugadorActual();
                    System.out.println(bancarrota ? "Jugador en bancarrota." : "Jugador aún tiene dinero.");
                    break;

                case "13":
                    if (juego == null) {
                        System.out.println("No hay juego activo.");
                    } else {
                        System.out.println(juego);
                    }
                    break;

                case "14":
                    continuar = false;
                    System.out.println("¡Gracias por jugar CAPITALIA!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}