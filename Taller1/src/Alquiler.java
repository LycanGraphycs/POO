import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler {
    private ClienteBarco clienteBarco;
    private Barco barco;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int posicionAmarre;
    private static final double COSTO_DIARIO = 25000;
    private static final double IMPUESTO = 0.1;

    public Alquiler(ClienteBarco clienteBarco, Barco barco, LocalDate fechaInicio, LocalDate fechaFin, int posicionAmarre) {
        this.clienteBarco = clienteBarco;
        this.barco = barco;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.posicionAmarre = posicionAmarre;
    }

    public long calcularDiasOcupacion() {
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }

    public double calcularCosto() {
        long dias = calcularDiasOcupacion();
        double costoBase = dias * COSTO_DIARIO;
        double costoTotal = costoBase + (costoBase * IMPUESTO);
        return costoTotal;
    }

    public void imprimirRecibo() {
        System.out.println("Recibo de Alquiler:");
        clienteBarco.mostrarDatos();
        barco.mostrarDatos();
        System.out.println("Fecha de inicio: " + fechaInicio);
        System.out.println("Fecha de fin: " + fechaFin);
        System.out.println("Posición del amarre: " + posicionAmarre);
        System.out.println("Días de ocupación: " + calcularDiasOcupacion());
        System.out.println("Costo total: $" + calcularCosto());
    }
}
