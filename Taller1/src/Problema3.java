//Andres Mauricio Moreno Garavito - Programación orientada a Objetos - Uniminuto
import java.util.Scanner;

public class Problema3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Apertura de Cuentas");
            System.out.println("2. Transferencias");
            System.out.println("3. Cajero Automático");
            System.out.println("4. Cierre de Mes");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    abrirCuenta(banco, scanner);
                    break;
                case 2:
                    realizarTransferencia(banco, scanner);
                    break;
                case 3:
                    usarCajero(banco, scanner);
                    break;
                case 4:
                    banco.cerrarMes();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println();
        }

        System.out.println("Gracias por usar el sistema bancario. ¡Hasta luego!");
        scanner.close();
    }

    private static void abrirCuenta(Banco banco, Scanner scanner) {
        System.out.println("Ingrese los datos del cliente:");
        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        String representante = "";
        if (edad < 18) {
            System.out.print("Nombre del representante: ");
            representante = scanner.nextLine();
        }

        Cliente cliente = new Cliente(nombres, apellidos, edad, representante);

        System.out.println("Seleccione el tipo de cuenta:");
        System.out.println("1. Ahorro");
        System.out.println("2. Corriente");
        int tipoCuenta = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Monto inicial: ");
        double montoInicial = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Número de cuenta: ");
        String numeroCuenta = scanner.nextLine();

        if (tipoCuenta == 1) {
            Cuenta cuenta = new CuentaAhorro(cliente, montoInicial, numeroCuenta);
            banco.abrirCuenta(cuenta);
        } else if (tipoCuenta == 2) {
            if (montoInicial < 200000) {
                System.out.println("El monto inicial para una cuenta corriente debe ser al menos 200,000 pesos.");
                return;
            }
            Cuenta cuenta = new CuentaCorriente(cliente, montoInicial, numeroCuenta);
            banco.abrirCuenta(cuenta);
        } else {
            System.out.println("Tipo de cuenta inválido.");
        }
    }

    private static void realizarTransferencia(Banco banco, Scanner scanner) {
        System.out.print("Número de cuenta origen: ");
        String cuentaOrigen = scanner.nextLine();
        System.out.print("Número de cuenta destino: ");
        String cuentaDestino = scanner.nextLine();
        System.out.print("Monto a transferir: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();

        banco.transferir(cuentaOrigen, cuentaDestino, monto);
    }

    private static void usarCajero(Banco banco, Scanner scanner) {
        System.out.print("Número de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        System.out.print("Monto a retirar: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("¿El cajero es propio del banco? (si/no): ");
        boolean esCajeroPropio = scanner.nextLine().equalsIgnoreCase("si");

        Cuenta cuenta = banco.buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            cuenta.retirar(monto, esCajeroPropio);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }
}
