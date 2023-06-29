package modelo;

import exceptions.PuntajeCeroException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class SistemaDeEvaluacion {
    private Doctor doctor1;
    private Doctor doctor2;
    private Doctor doctor3;
    private Doctor doctor4;
    private Doctor doctor5;
    private Doctor doctor6;


    // Nómina de Doctores
    public void inicializarDoctores() {
        doctor1 = new Doctor("Damaris Suquillo", "9102", "Traumatología");
        doctor2 = new Doctor("Ariel Amaguaña", "0218", "Cirugía");
        doctor3 = new Doctor("Anthony Morales", "9392", "Neurología");
        doctor4 = new Doctor("Camila Proaño", "7261", "Psiquiatría");
        doctor5 = new Doctor("Daniela Larco", "0019", "Cardiología");
        doctor6 = new Doctor("David Quille", "9290", "Medicina General");
    }

    public void evaluarSintomas(Paciente paciente, Enfermero enfermero) throws PuntajeCeroException {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        int opcion = 0, tipoSintomas = 0;
        int puntaje = 0;
        // Contadores para controlar que no se elija la misma enfermedad dos veces.
        int cont1C1 = 0, cont2C1 = 0, cont3C1 = 0, cont4C1 = 0, cont5C1 = 0, cont6C1 = 0, cont7C1 = 0;
        int cont1C3 = 0, cont2C3 = 0, cont3C3 = 0, cont4C3 = 0;
        int cont1C4 = 0, cont2C4 = 0, cont3C4 = 0, cont4C4 = 0, cont5C4 = 0;
        int cont1C5 = 0, cont2C5 = 0, cont3C5 = 0, cont4C5 = 0, cont5C5 = 0, cont6C5 = 0;
        int cont1C6 = 0, cont2C6 = 0, cont3C6 = 0, cont4C6 = 0, cont5C6 = 0, cont6C6 = 0, cont7C6 = 0, cont8C6 = 0;

        boolean finalizarChequeo = false;


        menuSintomas:
        do {
            System.out.println("-------------------------------- MENÚ DE SÍNTOMAS --------------------------------");
            System.out.println("Seleccione la categoría correspondiente a los síntomas que presenta:");
            System.out.println("1. Dolor y malestar físico");
            System.out.println("2. Emergencia Directa");
            System.out.println("3. Traumas y lesiones");
            System.out.println("4. Problemas psiquiátricos");
            System.out.println("5. Trastornos neurológicos");
            System.out.println("6. Problemas cardio-respiratorios");
            System.out.println("7. Regresar al menú principal");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.print("Ingrese una opción: ");
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero en el rango establecido.");
                scanner.nextLine(); // Limpiar el buffer de entrada
                continue; // Volver a solicitar la opción del menú
            }

            switch (opcion) {
                case 1:
                    enfermero.asignarMedico(doctor6, paciente);
                    do {
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("Seleccione uno o más de un dolor y malestar que presente");
                        System.out.println("1.  Dolor abdominal intenso           5.  Fiebre");
                        System.out.println("2.  Dolor de cabeza                   6.  Mareos");
                        System.out.println("3.  Dolor de espalda                  7.  Diarrea");
                        System.out.println("4.  Dolor en las articulaciones      ");
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("8.  Cancelar y volver                 9.   Finalizar chequeo");
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.print("Ingrese una opción: ");
                        try {
                            tipoSintomas = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un número entero en el rango establecido.");
                            scanner.nextLine(); // Limpiar el buffer de entrada
                            continue; // Volver a solicitar la opción de síntomas
                        }

                        switch (tipoSintomas) {
                            case 1:
                                if (cont1C1 <= 0) {
                                    puntaje += 2;
                                    cont1C1++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 2:
                                if (cont2C1 <= 0) {
                                    puntaje += 3;
                                    cont2C1++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 3:
                                if (cont3C1 <= 0) {
                                    puntaje += 2;
                                    cont3C1++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 4:
                                if (cont4C1 <= 0) {
                                    puntaje += 4;
                                    cont4C1++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 5:
                                if (cont5C1 <= 0) {
                                    puntaje += 4;
                                    cont5C1++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 6:
                                if (cont6C1 <= 0) {
                                    puntaje += 2;
                                    cont6C1++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 7:
                                if (cont7C1 <= 0) {
                                    puntaje += 3;
                                    cont7C1++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 8:
                                System.out.println("Regresando al menu principal...");
                                puntaje = 0;
                                continue menuSintomas;
                            case 9:
                                finalizarChequeo = true;
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                                break;
                        }
                    } while (!finalizarChequeo);
                    break;

                case 2:
                    enfermero.asignarMedico(doctor2, paciente);
                    do {
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("Seleccione uno de los siguientes síntomas de riesgo");
                        System.out.println("1.  Coloración azul en la piel          4. Quemaduras severas por todo el cuerpo");
                        System.out.println("2.  Perdida de miembro u órgano         5. Impacto de bala");
                        System.out.println("3.  Trabajo de parto expulsivo          6. Intoxicaciones o Envenenamientos");
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("7.  Cancelar y volver");
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.print("Ingrese una opción: ");
                        try {
                            tipoSintomas = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un número entero en el rango establecido.");
                            scanner.nextLine(); // Limpiar el buffer de entrada
                            continue; // Volver a solicitar la opción de síntomas
                        }

                        switch (tipoSintomas) {
                            case 1, 2, 3, 4, 5, 6:
                                puntaje = 100;
                                finalizarChequeo = true;
                                break;
                            case 7:
                                System.out.println("Regresando al menu principal...");
                                continue menuSintomas;
                            default:
                                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                                break;
                        }
                    } while (!finalizarChequeo);
                    break;

                case 3:
                    enfermero.asignarMedico(doctor1, paciente);
                    do {
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("Seleccione uno o más síntomas que presenta el paciente:");
                        System.out.println("1.  Fractura ósea           2.  Heridas profundas");
                        System.out.println("3.  Sangrado abundante      4.  Lesiones por accidentes de tráfico");
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("5.  Cancelar y volver       6.  Finalizar chequeo");
                        System.out.println("----------------------------------------------------------------------------------");
                        try {
                            tipoSintomas = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un número entero en el rango establecido.");
                            scanner.nextLine(); // Limpiar el buffer de entrada
                            continue; // Volver a solicitar la opción de síntomas
                        }
                        switch (tipoSintomas) {
                            case 1:
                                if (cont1C3 <= 0) {
                                    puntaje += 25;
                                    cont1C3++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 2:
                                if (cont2C3 <= 0) {
                                    puntaje += 25;
                                    cont2C3++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 3:
                                if (cont3C3 <= 0) {
                                    puntaje += 25;
                                    cont3C3++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 4:
                                if (cont4C3 <= 0) {
                                    puntaje += 20;
                                    cont4C3++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 5:
                                System.out.println("Regresando al menu principal...");
                                puntaje = 0;
                                continue menuSintomas;
                            case 6:
                                finalizarChequeo = true;
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                                break;
                        }
                    }
                    while (!finalizarChequeo && tipoSintomas != 5);
                    break;

                case 4:
                    enfermero.asignarMedico(doctor4, paciente);
                    do {
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("Seleccione uno o más síntomas que presenta el paciente:");
                        System.out.println("1.  Cambios repentinos en el comportamiento     4.  Crisis de pánico");
                        System.out.println("2.  Fatiga severa                               5.  Alucinaciones");
                        System.out.println("3.  Trastornos de ansiedad severos              ");
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("6.  Cancelar y volver                           7.  Finalizar chequeo");
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.print("Ingrese una opción: ");
                        try {
                            tipoSintomas = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un número entero en el rango establecido.");
                            scanner.nextLine(); // Limpiar el buffer de entrada
                            continue; // Volver a solicitar la opción de síntomas
                        }
                        switch (tipoSintomas) {
                            case 1:
                                if (cont1C4 <= 0) {
                                    puntaje += 12;
                                    cont1C4++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 2:
                                if (cont2C4 <= 0) {
                                    puntaje += 35;
                                    cont2C4++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 3:
                                if (cont3C4 <= 0) {
                                    puntaje += 10;
                                    cont3C4++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 4:
                                if (cont4C4 <= 6) {
                                    puntaje += 8;
                                    cont4C4++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 5:
                                if (cont5C4 <= 0) {
                                    puntaje += 20;
                                    cont5C4++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 6:
                                System.out.println("Regresando al menu principal...");
                                puntaje = 0;
                                continue menuSintomas;
                            case 7:
                                finalizarChequeo = true;
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                                break;
                        }
                    }
                    while (!finalizarChequeo);
                    break;


                case 5:
                    enfermero.asignarMedico(doctor3, paciente);
                    do {
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("Seleccione uno o más síntomas que presenta el paciente:");
                        System.out.println("1.  Perdida de conocimiento         5.  Dificultad para hablar o entender");
                        System.out.println("2.  Convulsiones                    6.  Vision borrosa o perdida de la vision");
                        System.out.println("3.  Debilidad o parálisis súbita    ");
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("7.  Cancelar y volver               8.  Finalizar chequeo");
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.print("Ingrese una opción: ");
                        try {
                            tipoSintomas = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un número entero en el rango establecido.");
                            scanner.nextLine(); // Limpiar el buffer de entrada
                            continue; // Volver a solicitar la opción de síntomas
                        }


                        switch (tipoSintomas) {
                            case 1:
                                if (cont1C5 <= 0) {
                                    puntaje += 10;
                                    cont1C5++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 2:
                                if (cont2C5 <= 0) {
                                    puntaje += 20;
                                    cont2C5++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 3:
                                if (cont3C5 <= 0) {
                                    puntaje += 20;
                                    cont3C5++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 4:
                                if (cont4C5 <= 0) {
                                    puntaje += 15;
                                    cont4C5++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 5:
                                if (cont5C5 <= 0) {
                                    puntaje += 10;
                                    cont5C5++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 6:
                                if (cont6C5 <= 0) {
                                    puntaje += 10;
                                    cont6C5++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 7:
                                System.out.println("Regresando al menu principal...");
                                puntaje = 0;
                                continue menuSintomas;
                            case 8:
                                finalizarChequeo = true;
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                                break;
                        }
                    } while (!finalizarChequeo);
                    break;

                case 6:
                    enfermero.asignarMedico(doctor5, paciente);
                    do {
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("Seleccione uno o más síntomas que presenta el paciente:");
                        System.out.println("1.  Dolor o presión en el pecho     5.  Desmayos");
                        System.out.println("2.  Palpitaciones                   6.  Signos de ataque cardíaco");
                        System.out.println("3.  Dificultad para respirar        7.  Asfixia");
                        System.out.println("4.  Respiración acelerada           8.  Tos intensa");
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("9.  Cancelar y volver               10. Finalizar chequeo");
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.print("Ingrese una opción: ");
                        try {
                            tipoSintomas = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un número entero en el rango establecido.");
                            scanner.nextLine(); // Limpiar el buffer de entrada
                            continue; // Volver a solicitar la opción de síntomas
                        }

                        switch (tipoSintomas) {
                            case 1:
                                if (cont1C6 <= 0) {
                                    puntaje += 10;
                                    cont1C6++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 2:
                                if (cont2C6 <= 0) {
                                    puntaje += 5;
                                    cont2C6++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 3:
                                if (cont3C6 <= 0) {
                                    puntaje += 10;
                                    cont3C6++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 4:
                                if (cont4C6 <= 0) {
                                    puntaje += 5;
                                    cont4C6++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 5:
                                if (cont5C6 <= 0) {
                                    puntaje += 10;
                                    cont5C6++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 6:
                                if (cont6C6 <= 0) {
                                    puntaje += 20;
                                    cont6C6++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 7:
                                if (cont7C6 <= 0) {
                                    puntaje += 15;
                                    cont7C6++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 8:
                                if (cont8C6 <= 0) {
                                    puntaje += 5;
                                    cont8C6++;
                                } else {
                                    mostrarSeleccionDoble();
                                }
                                break;
                            case 9:
                                System.out.println("Regresando al menu principal...");
                                puntaje = 0;
                                continue menuSintomas;
                            case 10:
                                finalizarChequeo = true;
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                                break;
                        }
                    } while (!finalizarChequeo);
                case 7:
                    break menuSintomas;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (!finalizarChequeo && opcion != 21);

        if (finalizarChequeo) {
            paciente.setNivelDeEnfermedad(puntaje);
            if (puntaje == 0) {
                throw new PuntajeCeroException("No ha seleccionado ninguna enfermedad. \n\t\tRegistre síntomas o salga del programa");
            }
            enfermero.clasificarPaciente(paciente);
        }
    }

    private static void mostrarSeleccionDoble() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                NO PUEDE ELEGIR EL MISMO SÍNTOMA DOS VECES");
        System.out.println("----------------------------------------------------------------------------------");
    }

    public void mostrarPersonal() {
        System.out.printf("El médico %s tiene %d paciente(s) en %s.%n", doctor1.getNombre(), doctor1.getNumeroPacientes(), doctor1.getEspecialidad());
        System.out.printf("El médico %s tiene %d paciente(s) en %s.%n", doctor2.getNombre(), doctor2.getNumeroPacientes(), doctor2.getEspecialidad());
        System.out.printf("El médico %s tiene %d paciente(s) en %s.%n", doctor3.getNombre(), doctor3.getNumeroPacientes(), doctor3.getEspecialidad());
        System.out.printf("El médico %s tiene %d paciente(s) en %s.%n", doctor4.getNombre(), doctor4.getNumeroPacientes(), doctor4.getEspecialidad());
        System.out.printf("El médico %s tiene %d paciente(s) en %s.%n", doctor5.getNombre(), doctor5.getNumeroPacientes(), doctor5.getEspecialidad());
        System.out.printf("El médico %s tiene %d paciente(s) en %s.%n", doctor6.getNombre(), doctor6.getNumeroPacientes(), doctor6.getEspecialidad());
    }
}
