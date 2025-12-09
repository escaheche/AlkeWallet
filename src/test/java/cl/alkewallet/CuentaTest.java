package cl.alkewallet;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
/**
 * Pruebas unitarias para la clase Cuenta.
 */
public class CuentaTest {


    /**
     * Prueba de creación de cuenta.
     */
    @Test
    public void testcrearCuenta() {
        // Implementar pruebas para la creación de cuentas

        String titular = "Juan Perez";
        TipoMoneda moneda = TipoMoneda.USD;

        //Acción
        Cuenta cuenta = new Cuenta(titular, moneda);
        //Verificación
        assertNotNull(cuenta,"La cuenta no debe ser null");
        assertEquals(titular, cuenta.getTitular(),"El titular no coincide");
        assertEquals(moneda, cuenta.getMoneda(),"La moneda no coincide");

        // El saldo inicial debe ser cero
        assertEquals(BigDecimal.ZERO, cuenta.getSaldo(), "El saldo inicial debe ser cero");


    }

    /**
     * Prueba de depositar y retirar dinero.
     */
    @Test
    public void testDepositarRetirar() {

        // Implementar pruebas para depositar y retirar dinero
        String titular = "Maria Lopez";
        TipoMoneda moneda = TipoMoneda.CLP;
        Cuenta cuenta = new Cuenta(titular, moneda);

        // Depositar dinero
        BigDecimal montoDeposito = new BigDecimal("800");
        cuenta.depositar(montoDeposito);
        assertEquals(montoDeposito, cuenta.getSaldo(), "El saldo después del depósito no coincide");

        // Retirar dinero
        BigDecimal montoRetiro = new BigDecimal("500.25");
        cuenta.retirar(montoRetiro);
        BigDecimal saldoEsperado = montoDeposito.subtract(montoRetiro);
        assertEquals(saldoEsperado, cuenta.getSaldo(), "El saldo después del retiro no coincide");
    }
}
