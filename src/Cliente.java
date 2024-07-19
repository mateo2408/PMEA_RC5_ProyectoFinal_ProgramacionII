public class Cliente {
    
    private Negocios negocios;

    public Cliente(Negocios negocios) {
        this.negocios = negocios;
    }

    public double getTotalImpuesto() {
        double ValorDescuento = negocios.getValorCarro() - negocios.getPagoTemprano();
        ValorDescuento -= negocios.getServicioPublico();
        ValorDescuento -= negocios.getTrasladoCuenta();

        return ValorDescuento * 0.10; // Assuming a 10% tax rate
    }
}

class DescuentoInvalido extends Exception {
    public DescuentoInvalido(String mensaje) {
        super(mensaje);
    }
}

