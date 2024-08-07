public class Negocios {
    private double ValorCarro;
    private double PagoTemprano;
    private double ServicioPublico;
    private double TrasladoCuenta;

    //Constructor
    public Negocios(double ValorCarro, double PagoTemprano, double ServicioPublico, double TrasladoCuenta) throws DescuentoInvalido {
        validarDescuento(PagoTemprano, TrasladoCuenta);

        this.ValorCarro = ValorCarro;
        this.PagoTemprano = PagoTemprano;
        this.ServicioPublico = ServicioPublico;
        this.TrasladoCuenta = TrasladoCuenta;
    }

    //Validaciones de descuentos
    private void validarDescuento(double PagoTemprano, double TrasladoCuenta) throws DescuentoInvalido {
        if (PagoTemprano < 0.00 || PagoTemprano > 1.00) {
            throw new DescuentoInvalido("El descuento por pago temprano debe ser entre 0.00 y 1.00.");
        }

        if (TrasladoCuenta < 0.00 || TrasladoCuenta > 1.00) {
            throw new DescuentoInvalido("El descuento por traslado de cuenta debe ser entre 0.00 y 1.00.");
        }

        if (PagoTemprano >= TrasladoCuenta) {
            throw new DescuentoInvalido("El descuento por Traslado de cuenta debe ser mayor que el descuento por Pago Temprano.");
        }
    }

    //Valor del carro
    public double getValorCarro() {
        return ValorCarro;
    }

    //Pago Temprano
    public double getPagoTemprano() {
        return ValorCarro * PagoTemprano;
    }

    //Servicio Publico
    public double getServicioPublico() {
        return ServicioPublico;
    }

    //Traslado de Cuenta
    public double getTrasladoCuenta() {
        double discountedValue = ValorCarro - getPagoTemprano();
        return discountedValue * TrasladoCuenta;
    }
}