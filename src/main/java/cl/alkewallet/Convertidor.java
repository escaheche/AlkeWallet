package cl.alkewallet;

import java.math.BigDecimal;

/**
 * Interfaz para la conversión de monedas.
 */
public interface Convertidor {
    BigDecimal convertir(BigDecimal saldo, TipoMoneda desde, TipoMoneda hacia);

    
}
