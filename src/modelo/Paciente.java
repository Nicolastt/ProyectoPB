package modelo;

public class Paciente {
    private final String nombre;
    private final String numeroDeCedula;
    private final String direccion;
    private final String telefono;
    private int nivelDeEnfermedad;
    private Doctor doctorEncargado;

    public Paciente(String nombre, String numeroDeCedula, String direccion, String telefono) {
        this.nombre = nombre;
        this.numeroDeCedula = numeroDeCedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String imprimirFicha() {
        return "\n-------------------------------- FICHA PACIENTE --------------------------------\n"
                + String.format(" Cliente: %s%n Cédula: %s%n Dirección: %s%n Teléfono: %s%n", this.nombre, this.numeroDeCedula
                , this.direccion, this.telefono);
    }

    public String imprimirPaciente() {
        return String.format("%s, con cédula de identidad %s ", this.nombre, this.numeroDeCedula);
    }

    public int getNivelDeEnfermedad() {
        return nivelDeEnfermedad;
    }

    public void setNivelDeEnfermedad(int nivelDeEnfermedad) {
        this.nivelDeEnfermedad = nivelDeEnfermedad;
    }

    public Doctor getDoctorEncargado() {
        return doctorEncargado;
    }

    public void setDoctorEncargado(Doctor doctorEncargado) {
        this.doctorEncargado = doctorEncargado;
    }

    public String getNombre() {
        return nombre;
    }
}
