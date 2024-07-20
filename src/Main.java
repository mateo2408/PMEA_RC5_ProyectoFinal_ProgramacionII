import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //Llamada de Scanner
        Scanner scanner = new Scanner(System.in);

        //Impresion de mensajes
        System.out.println("Bienvenido a la calculadora de impuestos de vehículos.");

        //Impresion de mensajes y declaracion de variables
        System.out.print("Ingrese el valor del carro: ");
        double carValue = scanner.nextDouble();

        System.out.print("Ingrese el valor de descuento temprano (0.00 to 1.00): ");
        double PagoTemprano = scanner.nextDouble();

        System.out.print("Ingrese el valor de descuento por servicio publico: ");
        double ServicioPublico = scanner.nextDouble();

        System.out.print("Ingrese el valor de traslado de cuenta (0.00 to 1.00): ");
        double TrasladoCuenta = scanner.nextDouble();

        //Metodo de Try and Catch
        try {
            Negocios negocios = new Negocios(carValue, PagoTemprano, ServicioPublico, TrasladoCuenta);
            Cliente cliente = new Cliente(negocios);

            System.out.println("\nResultados de la calculadora:");
            System.out.println("Valor del carro: $" + negocios.getValorCarro());
            System.out.println("Descuento por pago temprano: $" + negocios.getPagoTemprano());
            System.out.println("Descuento por servicio publico: $" + negocios.getServicioPublico());
            System.out.println("Desciento por traslado de cuenta: $" + negocios.getTrasladoCuenta());
            System.out.println("Impuesto Total: $" + cliente.getTotalImpuesto());
        } catch (DescuentoInvalido e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Un error inesperado ha ocurrido. Por favor, intente de nuevo.");
            e.printStackTrace();
        }
    }
}