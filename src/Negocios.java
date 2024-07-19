public class Negocios {
    private double ValorCarro;
    private double PagoTemprano;
    private double ServicioPublico;
    private double TrasladoCuenta;

    public Negocios(double ValorCarro, double PagoTemprano, double ServicioPublico, double TrasladoCuenta) throws DescuentoInvalido {
        validarDescuento(PagoTemprano, TrasladoCuenta);

        this.ValorCarro = ValorCarro;
        this.PagoTemprano = PagoTemprano;
        this.ServicioPublico = ServicioPublico;
        this.TrasladoCuenta = TrasladoCuenta;
    }

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

    public double getValorCarro() {
        return ValorCarro;
    }

    public double getPagoTemprano() {
        return ValorCarro * PagoTemprano;
    }

    public double getServicioPublico() {
        return ServicioPublico;
    }

    public double getTrasladoCuenta() {
        double discountedValue = ValorCarro - getPagoTemprano();
        return discountedValue * TrasladoCuenta;
    }
}