import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Problema2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (continuar) {
            // Introducción al programa
            System.out.println("Bienvenido al sistema de alquiler de amarres para barcos");
            System.out.println("Este software le permitirá conocer el costo de su próximo alquiler de amarre \n");

            // Solicitar datos del cliente
            System.out.println("Por favor ingrese los datos del cliente:");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Documento: ");
            String documento = scanner.nextLine();
            System.out.print("Dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            ClienteBarco clienteBarco = new ClienteBarco(nombre, documento, direccion, telefono);

            // Solicitar datos del barco
            System.out.println("Por favor ingrese los datos del barco:");
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();
            System.out.print("Eslora (en metros): ");
            double eslora = scanner.nextDouble();
            System.out.print("Año de fabricación: ");
            int anioFabricacion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            Barco barco = new Barco(matricula, eslora, anioFabricacion);

            // Solicitar datos del alquiler
            System.out.println("Por favor ingrese las fechas del alquiler:");
            System.out.print("Fecha de inicio (dd/MM/yyyy): ");
            LocalDate fechaInicio = LocalDate.parse(scanner.nextLine(), formatter);
            System.out.print("Fecha de fin (dd/MM/yyyy): ");
            LocalDate fechaFin = LocalDate.parse(scanner.nextLine(), formatter);
            System.out.print("Posición del amarre: ");
            int posicionAmarre = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            Alquiler alquiler = new Alquiler(clienteBarco, barco, fechaInicio, fechaFin, posicionAmarre);

            // Imprimir recibo
            alquiler.imprimirRecibo();

            // Preguntar si desea hacer otra consulta
            System.out.print("¿Desea realizar otra consulta? (si/no): ");
            String continuarInput = scanner.nextLine().toLowerCase();
            continuar = continuarInput.equals("si");

            System.out.println();
        }

        System.out.println("Gracias por usar el sistema de alquiler de amarres para barcos. ¡Hasta luego!");
        scanner.close();
    }
}
