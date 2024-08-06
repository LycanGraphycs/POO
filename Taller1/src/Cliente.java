public class Cliente {
    private String nombres;
    private String apellidos;
    private int edad;
    private String representante;

    public Cliente(String nombres, String apellidos, int edad, String representante) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.representante = representante;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getRepresentante() {
        return representante;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombres + " " + apellidos);
        System.out.println("Edad: " + edad);
        if (edad < 18) {
            System.out.println("Representante: " + representante);
        }
    }
}
