
package com.mycompany.hotel;

import java.util.Scanner;

public class SistemaHotel {
    private String[][] habitaciones;
    private int numHabitaciones;

    public SistemaHotel(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
        habitaciones = new String[numHabitaciones][2];

        // Inicializar las habitaciones
        for (int i = 0; i < numHabitaciones; i++) {
            habitaciones[i][0] = Integer.toString(i + 1);
            habitaciones[i][1] = "Disponible";
        }
    }

    public void mostrarHabitacionesDisponibles() {
        System.out.println("Habitaciones Disponibles:");
        for (int i = 0; i < numHabitaciones; i++) {
            if (habitaciones[i][1].equals("Disponible")) {
                System.out.println("Habitación " + habitaciones[i][0]);
            }
        }
        System.out.println();
    }

    public void reservarHabitacion(int numHabitacion, String nombreCliente) {
        if (numHabitacion < 1 || numHabitacion > numHabitaciones) {
            System.out.println("Habitación inválida.");
            return;
        }

        int indiceHabitacion = numHabitacion - 1;
        if (habitaciones[indiceHabitacion][1].equals("Disponible")) {
            habitaciones[indiceHabitacion][1] = nombreCliente;
            System.out.println("Habitación " + numHabitacion + " reservada para " + nombreCliente + ".");
        } else {
            System.out.println("La habitación " + numHabitacion + " ya está ocupada.");
        }
    }

    public void liberarHabitacion(int numHabitacion) {
        if (numHabitacion < 1 || numHabitacion > numHabitaciones) {
            System.out.println("Habitación inválida.");
            return;
        }

        int indiceHabitacion = numHabitacion - 1;
        if (habitaciones[indiceHabitacion][1].equals("Disponible")) {
            System.out.println("La habitación " + numHabitacion + " ya está disponible.");
        } else {
            String nombreCliente = habitaciones[indiceHabitacion][1];
            habitaciones[indiceHabitacion][1] = "Disponible";
            System.out.println("La habitación " + numHabitacion + " ha sido liberada por " + nombreCliente + ".");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de habitaciones del hotel: ");
        int numHabitaciones = scanner.nextInt();

        SistemaHotel sistemaHotel = new SistemaHotel(numHabitaciones);

        int opcion;
        do {
            System.out.println("----- Sistema de Hotel -----");
            System.out.println("1. Mostrar habitaciones disponibles");
            System.out.println("2. Reservar habitación");
            System.out.println("3. Liberar habitación");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    sistemaHotel.mostrarHabitacionesDisponibles();
                    break;
                case 2:
                    System.out.print("Ingrese el número de habitación: ");
                    int numReserva = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    sistemaHotel.reservarHabitacion(numReserva, nombreCliente);
                    break;
                case 3:
                    System.out.print("Ingrese el número de habitación: ");
                    int numLiberar = scanner.nextInt();
                    sistemaHotel.liberarHabitacion(numLiberar);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println();
        } while (opcion != 4);
    }
}
