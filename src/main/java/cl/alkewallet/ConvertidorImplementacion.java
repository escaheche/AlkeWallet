package cl.alkewallet;

import java.math.BigDecimal;


/**
 * Implementación de la interfaz Convertidor para la conversión de monedas.
 */
public class ConvertidorImplementacion implements Convertidor {

   
    
   
/**
 * Obtiene la tasa de cambio entre dos monedas.
 * @param desde
 * @param hacia
 * @return
 */
    private double obtenerTasaCambio(TipoMoneda desde, TipoMoneda hacia) {
        // Ejemplo de tasas de cambio fijas
        if (desde == TipoMoneda.CLP && hacia == TipoMoneda.USD) {
            return 0.0013; // 1 CLP = 0.0013 USD
        } else if (desde == TipoMoneda.USD && hacia == TipoMoneda.CLP) {
            return 770.0; // 1 USD = 770 CLP
        } else if (desde == TipoMoneda.CLP && hacia == TipoMoneda.EUR) {
            return 0.0011; // 1 CLP = 0.0011 EUR
        } else if (desde == TipoMoneda.EUR && hacia == TipoMoneda.CLP) {
            return 900.0; // 1 EUR = 900 CLP
        } else if (desde == TipoMoneda.USD && hacia == TipoMoneda.EUR) {
            return 0.85; // 1 USD = 0.85 EUR
        } else if (desde == TipoMoneda.EUR && hacia == TipoMoneda.USD) {
            return 1.18; // 1 EUR = 1.18 USD
        } else {
            throw new IllegalArgumentException("No hay tasa definida para " + desde + " -> " + hacia);
        }
        
    }

    /**
     * Convierte un saldo de una moneda a otra.
    */
    @Override
    public BigDecimal convertir(BigDecimal saldo, TipoMoneda desde, TipoMoneda hacia) {
        if (desde == hacia) {
            return saldo; // No se necesita conversión
        }else{
            double tasaCambio = obtenerTasaCambio(desde, hacia);
      return saldo.multiply(BigDecimal.valueOf(tasaCambio));


        }
    }

  

   
    
}
