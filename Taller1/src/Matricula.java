public class Matricula {
    private Estudiante estudiante;
    private Carrera carrera;
    private boolean enLinea;
    private int semestre;
    private int materiasPerdidas;

    public Matricula(Estudiante estudiante, Carrera carrera, boolean enLinea, int semestre, int materiasPerdidas) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.enLinea = enLinea;
        this.semestre = semestre;
        this.materiasPerdidas = materiasPerdidas;
    }

    public double calcularCosto() {
        double costoBase = 1500;
        double incremento = (semestre >= 5) ? 0.05 : 0;
        double costoTotal = costoBase + (costoBase * incremento);

        if (!enLinea) {
            int costoCredito;
            if (semestre <= 3) {
                costoCredito = 20;
            } else if (semestre <= 6) {
                costoCredito = 25;
            } else {
                costoCredito = 30;
            }
            costoTotal += materiasPerdidas * costoCredito;
        }

        return costoTotal;
    }

    public void imprimirRecibo() {
        estudiante.mostrarDatos();
        System.out.println("Carrera: " + carrera.getNombre());
        System.out.println("Semestre: " + semestre);
        System.out.println("En línea: " + (enLinea ? "Sí" : "No"));
        System.out.println("Materias perdidas: " + materiasPerdidas);
        System.out.println("Costo total: $" + calcularCosto());
    }
}
