public class CuentaCorriente extends Cuenta {
    private static final double MANTENIMIENTO_MENSUAL = 0.015;
    private static final double MONTO_MINIMO_APERTURA = 200000;

    public CuentaCorriente(Cliente cliente, double saldoInicial, String numeroCuenta) {
        super(cliente, saldoInicial, numeroCuenta);
        if (saldoInicial < MONTO_MINIMO_APERTURA) {
            throw new IllegalArgumentException("El monto inicial debe ser al menos " + MONTO_MINIMO_APERTURA);
        }
    }

    @Override
    public void depositar(double monto) {
        double comision = 0;
        if (monto < 500000) {
            comision = 7000;
        } else if (monto >= 500000 && monto < 2000000) {
            comision = 5000 + (0.02 * monto);
        } else if (monto >= 2000000 && monto <= 10000000) {
            comision = 4000 + (0.02 * monto);
        } else if (monto > 10000000) {
            comision = 0.033 * monto;
        }
        saldo += (monto - comision);
    }

    @Override
    public void retirar(double monto, boolean esCajeroPropio) {
        if (!esCajeroPropio) {
            monto += 4500;
        }
        if (saldo >= monto) {
            saldo -= monto;
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }

    @Override
    public void cobrarMantenimiento() {
        double mantenimiento = saldo * MANTENIMIENTO_MENSUAL;
        saldo -= mantenimiento;
    }

    @Override
    public void mostrarCuenta() {
        cliente.mostrarDatos();
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Tipo de Cuenta: Corriente");
        System.out.println("Saldo: " + saldo);
    }
}
