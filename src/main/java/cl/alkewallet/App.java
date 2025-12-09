package cl.alkewallet;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Clase principal de la aplicación Alke Wallet.
 */
public class App 
{
    public static void main( String[] args ){

        /**
         * Menú interactivo para la gestión de cuentas y conversiones de moneda.
         */
    Scanner sc = new Scanner(System.in);
        Convertidor converter = new ConvertidorImplementacion();
        Cuenta cuenta = null;

        int opcion = -1;
        /**
         * Bucle principal del menú.
         */
        while (opcion != 0) {
            System.out.println("================================");
            System.out.println("        ALKE WALLET ");
            System.out.println("================================");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Ver saldo");
            System.out.println("3. Ingresar dinero");
            System.out.println("4. Retirar dinero");
            System.out.println("5. Convertir saldo a otra moneda");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            
            if (!sc.hasNextInt()) {
                System.out.println("Opción inválida.\n");
                sc.nextLine(); // limpiar
                continue;
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar salto de línea
        /**
         * Procesa la opción seleccionada por el usuario.
         */
            try {
                /**
                 * Switch para manejar las opciones del menú.
                 */
                switch (opcion) {
                    case 1:// Crear cuenta
                        if (cuenta != null) {
                            System.out.println("Ya existe una cuenta creada para " + cuenta.getTitular());
                            break;
                        }
                        System.out.print("Ingrese nombre del titular: ");
                        String nombre = sc.nextLine();

                        System.out.println("Moneda inicial (1=CLP, 2=USD, 3=EUR): ");
                        int opMoneda = sc.nextInt();
                        sc.nextLine();

                        TipoMoneda monedaInicial = elegirMoneda(opMoneda);
                        cuenta = new Cuenta(nombre, monedaInicial);
                        System.out.println("Cuenta creada correctamente para " + nombre + " en " + monedaInicial);
                        break;

                    case 2:// Ver saldo
                        validarCuenta(cuenta);
                        System.out.println("Titular: " + cuenta.getTitular());
                        System.out.println("Saldo: " + cuenta.getSaldo() + " " + cuenta.getMoneda());
                        break;

                    case 3:// Ingresar dinero
                        validarCuenta(cuenta);
                        System.out.print("Monto a ingresar: ");
                        BigDecimal montoIngreso = leerBigDecimal(sc);
                        cuenta.depositar(montoIngreso);
                        System.out.println("Depósito realizado. Nuevo saldo: "
                                + cuenta.getSaldo() + " " + cuenta.getMoneda());
                        break;

                    case 4:// Retirar dinero
                        validarCuenta(cuenta);
                        System.out.print("Monto a retirar: ");
                        BigDecimal montoRetiro = leerBigDecimal(sc);
                        cuenta.retirar(montoRetiro);
                        System.out.println("Retiro realizado. Nuevo saldo: "
                                + cuenta.getSaldo() + " " + cuenta.getMoneda());
                        break;

                    case 5:// Convertir saldo
                        validarCuenta(cuenta);
                        System.out.println("Convertir a (1=CLP, 2=USD, 3=EUR): ");
                        int opConv = sc.nextInt();
                        sc.nextLine();
                        TipoMoneda nuevaMoneda = elegirMoneda(opConv);
                        cuenta.convertirSaldo(nuevaMoneda, converter);
                        System.out.println("Saldo convertido. Nuevo saldo: "
                                + cuenta.getSaldo() + " " + cuenta.getMoneda());
                        break;

                    case 0:// Salir
                        System.out.println("Saliendo de Alke Wallet. ¡Hasta luego!");
                        break;

                    default:// Opción inválida
                        System.out.println("Opción no válida.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println(); // línea en blanco
        }

        sc.close();
    }

    /**
     * Valida si la cuenta existe.
     * @param cuenta
     */
    private static void validarCuenta(Cuenta cuenta) {
        if (cuenta == null) {
            throw new IllegalArgumentException("Primero debe crear una cuenta (opción 1).");
        }
    }

    /**
     * Elige el tipo de moneda según la opción ingresada.
     * @param opcion
     * @return
     */
    private static TipoMoneda elegirMoneda(int opcion) {
        return switch (opcion) {
            case 1 -> TipoMoneda.CLP;
            case 2 -> TipoMoneda.USD;
            case 3 -> TipoMoneda.EUR;
            default -> throw new IllegalArgumentException("Opción de moneda inválida");
        };
    }

    /**
     * Lee un BigDecimal desde la entrada estándar.
     * @param sc
     * @return
     */
    private static BigDecimal leerBigDecimal(Scanner sc) {
        String input = sc.nextLine().replace(",", "."); // por si usan coma
        return new BigDecimal(input);
    }
}
