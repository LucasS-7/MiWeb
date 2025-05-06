
package cl.douc.teatrofinal;


public class Venta {
   int idVenta;
   Cliente cliente;
   Entrada entrada;
   double precioFinal;
   String tipoDescuento;
    
    public Venta(int idVenta, Cliente cliente, Entrada entrada, double precioFinal, String tipoDescuento) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.entrada = entrada;
        this.precioFinal = precioFinal;
        this.tipoDescuento = tipoDescuento;
    }
    
}
