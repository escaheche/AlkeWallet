package cl.alkewallet;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 * Pruebas unitarias para la interfaz Convertidor.
 */
public class ConvertidorTest {
    
  /**
   * Prueba de conversión de USD a EUR.
   */
      @Test
    void testConversion_USD_to_EUR() {
        Convertidor convertidor = new ConvertidorImplementacion();

        BigDecimal montoUSD = new BigDecimal("100"); 
        BigDecimal montoEUR = convertidor.convertir(TipoMoneda.USD, TipoMoneda.EUR, montoUSD);

        // Suponiendo que en tu Convertidor la tasa USD → EUR = 0.85
        BigDecimal tasa = new BigDecimal("0.85");
        BigDecimal montoEsperado = montoUSD.multiply(tasa);

        // Assert para BigDecimal con margen de error
        assertEquals(0, montoEUR.compareTo(montoEsperado),
                "La conversión USD → EUR no coincide con el valor esperado");
    }
}
