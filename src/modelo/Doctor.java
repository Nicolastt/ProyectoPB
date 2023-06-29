package modelo;

public class Doctor {
    private final String nombre;
    private final String id;
    private final String especialidad;
    private int numeroPacientes;

    public Doctor(String nombre, String id, String especialidad) {
        this.nombre = nombre;
        this.id = id;
        this.especialidad = especialidad;
    }

    public String imprimirDoctor() {
        return String.format("%s, con el ID: %s y con una especialidad en %s", this.nombre, this.id, this.especialidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void agendarPaciente() {
        numeroPacientes++;
    }

    public int getNumeroPacientes() {
        return numeroPacientes;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
