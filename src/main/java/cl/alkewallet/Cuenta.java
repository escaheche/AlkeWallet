package cl.alkewallet;

import java.math.BigDecimal;


/**
 * Representa una cuenta bancaria con titular, saldo y tipo de moneda.
 */
public class Cuenta {
    private String titular;
    private BigDecimal  saldo;
    private TipoMoneda moneda;
    
/**
 * Constructor de la clase Cuenta.
 * @param titular
 * @param moneda
 */
    public Cuenta(String titular, TipoMoneda moneda) {

        if(titular==null || titular.trim().isEmpty())
            {
            throw new IllegalArgumentException("El titular no puede ser vacio");
        }
        if(moneda==null)
        {
            throw new IllegalArgumentException("La moneda no puede ser null");
        }

        this.titular = titular;
        this.saldo = BigDecimal.ZERO;
        this.moneda = moneda;
        
    }

    public String getTitular() {
        return titular;
    }

    public BigDecimal  getSaldo() {
        return saldo;
    }

    public TipoMoneda getMoneda() {
        return moneda;
    }

    /**
     * Deposita un monto al saldo de la cuenta.
     * @param monto
     */
    public void depositar(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        saldo = saldo.add(monto);
    }


    /**
     * Retira un monto del saldo de la cuenta.
     * @param monto
     */
    public void retirar(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        if (saldo.compareTo(monto) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        saldo = saldo.subtract(monto);
    }

    /**
     * Convierte el saldo de la cuenta a una nueva moneda.
     * @param nuevaMoneda
     * @param converter
     */
    public void convertirSaldo(TipoMoneda nuevaMoneda, Convertidor converter) {
        BigDecimal convertido = converter.convertir(this.saldo, this.moneda, nuevaMoneda);
        this.moneda = nuevaMoneda;
        this.saldo = convertido;
    }

    /**
     * Actualiza el saldo y la moneda de la cuenta.
     * @param nuevo
     * @param nuevaMoneda
     */
     public void actualizarSaldo(BigDecimal nuevo, TipoMoneda nuevaMoneda) {
        this.saldo = nuevo;
        this.moneda = nuevaMoneda;
    }

}
