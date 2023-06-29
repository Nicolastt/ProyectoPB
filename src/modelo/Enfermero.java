package modelo;

public class Enfermero {
    private final String nombre;
    private final String id;
    private final String cargo;

    public Enfermero(String nombre, String id, String cargo) {
        this.nombre = nombre;
        this.id = id;
        this.cargo = cargo;
    }

    public void asignarMedico(Doctor doctor, Paciente paciente) {
        paciente.setDoctorEncargado(doctor);
    }

    public void clasificarPaciente(Paciente paciente) {
        int nivelEnfermedad = paciente.getNivelDeEnfermedad();

        switch (nivelEnfermedad) {
            case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 ->
                    this.generarTicket(paciente, "Sin Urgencia");
            case 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 ->
                    this.generarTicket(paciente, "Urgencia menor");
            case 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60 ->
                    this.generarTicket(paciente, "Urgente");
            case 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80 ->
                    this.generarTicket(paciente, "Urgencia mayor");
            case 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99 ->
                    this.generarTicket(paciente, "Emergencia");
            case 100 -> this.generarTicket(paciente, "Resucitación");
            default -> System.out.println("ERROR");
        }
    }

    public void generarTicket(Paciente paciente, String caso) {
        Ticket ticket = new Ticket(paciente, caso, this);
        ticket.imprimirTicket();
    }

    public String imprimirEnfermero() {
        return String.format("%s, con el ID: %s a cargo de %s%n", this.nombre, this.id, this.cargo);
    }
}

