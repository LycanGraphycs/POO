public class CuentaAhorro extends Cuenta {
    private static final double TASA_RENDIMIENTO_ANUAL = 0.022;

    public CuentaAhorro(Cliente cliente, double saldoInicial, String numeroCuenta) {
        super(cliente, saldoInicial, numeroCuenta);
    }

    @Override
    public void depositar(double monto) {
        double comision = 0;
        if (monto >= 500000 && monto < 2000000) {
            comision = 3000 + (0.01 * monto);
        } else if (monto >= 2000000 && monto <= 10000000) {
            comision = 2000 + (0.005 * monto);
        } else if (monto > 10000000 && monto <= 100000000) {
            comision = 0.018 * monto;
        } else if (monto > 100000000) {
            comision = 0.02 * monto;
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
        double rendimiento = saldo * TASA_RENDIMIENTO_ANUAL / 12;
        saldo += rendimiento;
    }

    @Override
    public void mostrarCuenta() {
        cliente.mostrarDatos();
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Tipo de Cuenta: Ahorro");
        System.out.println("Saldo: " + saldo);
    }
}
