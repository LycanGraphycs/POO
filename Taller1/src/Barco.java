public class Barco {
    private String matricula;
    private double eslora;
    private int anioFabricacion;

    public Barco(String matricula, double eslora, int anioFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabricacion = anioFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getEslora() {
        return eslora;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void mostrarDatos() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("Eslora: " + eslora + " metros");
        System.out.println("Año de fabricación: " + anioFabricacion);
    }
}
