public class Estudiante {
    private String nombres;
    private String apellidos;
    private String documento;
    private String direccion;
    private String telefono;

    public Estudiante(String nombres, String apellidos, String documento, String direccion, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public void mostrarDatos() {
        System.out.println("Estudiante: " + nombres + " " + apellidos);
        System.out.println("Documento: " + documento);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
    }
}
