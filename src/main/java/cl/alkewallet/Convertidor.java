package cl.alkewallet;

import java.math.BigDecimal;

/**
 * Interfaz para la conversión de monedas.
 */
@FunctionalInterface
public interface Convertidor {

    /**
     * Convierte un monto desde una moneda origen a una moneda destino.
     *
     * @param desde moneda origen
     * @param hacia moneda destino
     * @param monto monto a convertir
     * @return monto convertido
     */
    BigDecimal convertir(TipoMoneda desde, TipoMoneda hacia, BigDecimal monto);

  
}
