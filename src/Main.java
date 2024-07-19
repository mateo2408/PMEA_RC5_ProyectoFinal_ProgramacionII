import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la calculadora de impuestos de vehículos.");

        System.out.print("Ingrese el valor del carro: ");
        double carValue = scanner.nextDouble();

        System.out.print("Ingrese el valor de descuento temprano (0.00 to 1.00): ");
        double earlyPaymentDiscountPercentage = scanner.nextDouble();

        System.out.print("Ingrese el valor de descuento por servicio publico: ");
        double publicServiceDiscountAmount = scanner.nextDouble();

        System.out.print("Ingrese el valor de traslado de cuenta (0.00 to 1.00): ");
        double accountTransferDiscountPercentage = scanner.nextDouble();

        try {
            Negocios negocios = new Negocios(carValue, earlyPaymentDiscountPercentage, publicServiceDiscountAmount, accountTransferDiscountPercentage);
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