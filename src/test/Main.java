package test;

import exceptions.PacienteNullException;
import exceptions.PuntajeCeroException;
import modelo.Enfermero;
import modelo.Paciente;
import modelo.SistemaDeEvaluacion;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creamos un Scanner
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        SistemaDeEvaluacion sistemaDeEvaluacion = new SistemaDeEvaluacion();
        sistemaDeEvaluacion.inicializarDoctores();

        int numeroMaximoPacientes = 3;
        // Creación de Enfermero
        Enfermero enfermero1 = new Enfermero("Melanie Abelardo", "2831", "Sala de Emergencias");
        for (int i = 0; i < numeroMaximoPacientes; i++) {
            System.out.println("<-------------------------------------------------------------------------------->");
            System.out.println("                        HOSPITAL DE CUIDADOS HUMANOS                              ");
            System.out.println("<-------------------------------------------------------------------------------->");
            // Creación de Paciente por consola
            System.out.println("Regístrese para poder continuar: ");
            String nombre;
            do {
                System.out.print("Ingrese su nombre: ");
                nombre = pedirNombre(sc);
            } while (nombre.isEmpty());

            String cedula;
            do {
                System.out.print("Ingrese su cédula: ");
                cedula = pedirCedula(sc);
            } while (cedula.isEmpty());


            String direccion;
            do {
                System.out.print("Ingrese su dirección: ");
                direccion = pedirDireccion(sc);
            } while (direccion.isEmpty());

            String telefono;
            do {
                System.out.print("Ingrese su teléfono: ");
                telefono = pedirTelefono(sc);
            } while (telefono.isEmpty());

            Paciente paciente = new Paciente(nombre, cedula, direccion, telefono);
            System.out.println(paciente.imprimirFicha());

            int opcion = 0;

            do {
                try {
                    System.out.println("<-------------------------------- MENÚ PRINCIPAL -------------------------------->");
                    System.out.println("1. Registrar síntomas");
                    System.out.println("2. Salir");
                    System.out.print("Ingrese una opción: ");
                    opcion = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Se esperaba un número entero. Por favor, ingrese una opción válida.");
                    sc.nextLine(); // Limpiar el búfer de entrada
                    continue; // Volver al inicio del bucle
                }

                switch (opcion) {
                    case 1:
                        try {
                            sistemaDeEvaluacion.evaluarSintomas(paciente, enfermero1);
                        } catch (PuntajeCeroException e) {
                            System.out.println("Aviso: " + e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.println("¡Ha sido un placer atenderle, recupérese pronto!");
                        System.out.println("Cerrando sesión...");
                        sc.nextLine();
                        break;
                    default:
                        System.out.println("O pción inválida. Por favor, ingrese una opción válida.");
                        break;
                }
            } while (opcion != 2);
        }

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                PANTALLA ASIGNACIÓN DE PACIENTES A DOCTORES                       ");
        System.out.println("----------------------------------------------------------------------------------");
        sistemaDeEvaluacion.mostrarPersonal();
    }

    private static String pedirTelefono(Scanner sc) {
        String telefono = sc.nextLine();
        if (telefono.isEmpty()) {
            try {
                throw new PacienteNullException("El campo 'teléfono' no puede estar vacío.");
            } catch (PacienteNullException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return telefono;
    }

    private static String pedirCedula(Scanner sc) {
        String cedula = sc.nextLine();
        if (cedula.isEmpty()) {
            try {
                throw new PacienteNullException("El campo 'cédula' no puede estar vacío.");
            } catch (PacienteNullException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return cedula;
    }

    private static String pedirDireccion(Scanner sc) {
        String direccion = sc.nextLine();
        if (direccion.isEmpty()) {
            try {
                throw new PacienteNullException("El campo 'dirección' no puede estar vacío.");
            } catch (PacienteNullException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return direccion;
    }

    private static String pedirNombre(Scanner sc) {
        String nombre = sc.nextLine();
        if (nombre.isEmpty()) {
            try {
                throw new PacienteNullException("El campo 'nombre' no puede estar vacío.");
            } catch (PacienteNullException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return nombre;
    }
}
