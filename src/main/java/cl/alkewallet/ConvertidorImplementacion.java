package cl.alkewallet;

import java.math.BigDecimal;
/**
 * Implementación de la interfaz Convertidor para la conversión de monedas.
 */
public class ConvertidorImplementacion implements Convertidor {

    /**
     * Convierte un monto desde una moneda origen a una moneda destino.
     */
    @Override
    public BigDecimal convertir(TipoMoneda desde, TipoMoneda hacia, BigDecimal monto) {

        if (monto == null) {
            throw new IllegalArgumentException("El monto no puede ser null");
        }
        if (desde == null || hacia == null) {
            throw new IllegalArgumentException("Las monedas no pueden ser null");
        }
        if (desde == hacia) {
            return monto;
        }

        double tasaDouble = obtenerTasaCambio(desde, hacia); // tu método actual
        BigDecimal tasa = BigDecimal.valueOf(tasaDouble);

        return monto.multiply(tasa);
    }

    /**
     * Obtiene la tasa de cambio entre dos monedas.
     * @param desde
     * @param hacia
     * @return tasa de cambio
     */
    private double obtenerTasaCambio(TipoMoneda desde, TipoMoneda hacia) {
        if (desde == TipoMoneda.CLP && hacia == TipoMoneda.USD) {
            return 0.0013;
        } else if (desde == TipoMoneda.USD && hacia == TipoMoneda.CLP) {
            return 770.0;
        } else if (desde == TipoMoneda.CLP && hacia == TipoMoneda.EUR) {
            return 0.0011;
        } else if (desde == TipoMoneda.EUR && hacia == TipoMoneda.CLP) {
            return 900.0;
        } else if (desde == TipoMoneda.USD && hacia == TipoMoneda.EUR) {
            return 0.85;
        } else if (desde == TipoMoneda.EUR && hacia == TipoMoneda.USD) {
            return 1.18;
        } else {
            throw new IllegalArgumentException("No hay tasa definida para " + desde + " -> " + hacia);
        }
    }
}

