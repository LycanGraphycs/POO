public class ClienteBarco {
    private String nombre;
    private String documento;
    private String direccion;
    private String telefono;

    public ClienteBarco(String nombre, String documento, String direccion, String telefono) {
        this.nombre = nombre;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
    }
}
