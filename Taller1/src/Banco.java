import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cuenta> cuentas;

    public Banco() {
        this.cuentas = new ArrayList<>();
    }

    public void abrirCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public void transferir(String numeroCuentaOrigen, String numeroCuentaDestino, double monto) {
        Cuenta cuentaOrigen = buscarCuenta(numeroCuentaOrigen);
        Cuenta cuentaDestino = buscarCuenta(numeroCuentaDestino);

        if (cuentaOrigen != null && cuentaDestino != null && cuentaOrigen.getSaldo() >= monto) {
            cuentaOrigen.retirar(monto, true);
            cuentaDestino.depositar(monto);
        } else {
            System.out.println("Transferencia fallida.");
        }
    }

    public Cuenta buscarCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    public void cerrarMes() {
        for (Cuenta cuenta : cuentas) {
            cuenta.cobrarMantenimiento();
            cuenta.mostrarCuenta();
        }
    }
}
