public class Cliente {
    
    private Negocios negocios;

    //Constructor
    public Cliente(Negocios negocios) {
        this.negocios = negocios;
    }

    //Calculamos el total de impuestos
    public double getTotalImpuesto() {
        double ValorDescuento = negocios.getValorCarro() - negocios.getPagoTemprano();
        ValorDescuento -= negocios.getServicioPublico();
        ValorDescuento -= negocios.getTrasladoCuenta();

        return ValorDescuento * 0.10; // Assuming a 10% tax rate
    }
}

//Control de errores
class DescuentoInvalido extends Exception {
    public DescuentoInvalido(String mensaje) {
        super(mensaje);
    }
}

