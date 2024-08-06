public abstract class Cuenta {
    protected Cliente cliente;
    protected double saldo;
    protected String numeroCuenta;

    public Cuenta(Cliente cliente, double saldoInicial, String numeroCuenta) {
        this.cliente = cliente;
        this.saldo = saldoInicial;
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void depositar(double monto);
    public abstract void retirar(double monto, boolean esCajeroPropio);
    public abstract void cobrarMantenimiento();
    public abstract void mostrarCuenta();
}
