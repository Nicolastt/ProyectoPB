package modelo;

public class Ticket {
    private final Paciente paciente;
    private final String caso;
    private final Enfermero enfermero;

    public Ticket(Paciente paciente, String caso, Enfermero enfermero) {
        this.paciente = paciente;
        this.caso = caso;
        this.enfermero = enfermero;
    }

    public void imprimirTicket() {
        System.out.println("<-------------------------------- FICHA HOSPITAL -------------------------------->");
        System.out.println(paciente.imprimirPaciente() + " ha obtenido un puntaje de: " + paciente.getNivelDeEnfermedad());
        System.out.println("Por lo cual ha sido asignado al doctor " + paciente.getDoctorEncargado().getNombre() + ". Su caso es '" + caso + "'.");
        System.out.println("\nHa sido atendido por el enfermero:\n" + enfermero.imprimirEnfermero());
        paciente.getDoctorEncargado().agendarPaciente();
        System.out.printf("Ficha Doctor(a) encargado de %s: %n\t\t%s%n\t\t", paciente.getNombre(), paciente.getDoctorEncargado().imprimirDoctor());
        System.out.printf("Lista de espera para médico %s es de: %d paciente(s)%n%n", paciente.getDoctorEncargado().getNombre(), paciente.getDoctorEncargado().getNumeroPacientes());
        System.out.println("<-------------------- GRACIAS POR UTILIZAR NUESTROS SERVICIOS ------------------->\n");
    }
}
