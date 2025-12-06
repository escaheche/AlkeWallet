package cl.alkewallet;

import java.math.BigDecimal;

/**
 * Interfaz para la conversión de monedas.
 */
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

    /**
     * Sobrecarga conveniente: primero monto, luego monedas.
     * Delegamos al método principal para no duplicar lógica.
     */
    default BigDecimal convertir(BigDecimal monto, TipoMoneda desde, TipoMoneda hacia) {
        return convertir(desde, hacia, monto);
    }
}
