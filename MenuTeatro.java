package cl.douc.teatrofinal;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuTeatro {
    
    Venta[] ventas = new Venta[100];
    int contadorVentas = 0;
    ArrayList<Integer>asientosOcupados = new ArrayList<>();
    
    public double calcularPrecio (String tipoEntrada) {
       switch (tipoEntrada.toUpperCase()) {
         case "VIP": return 20000.0;
         case "PALCO": return 18000.0;
         case "PLATEA BAJA": return 15000.0;
         case "PLATEA ALTA": return 13000.0;
         case "GALERIA": return 10000.0;
         default: return 0.0;
    
      }
    }
    
    public String aplicarDescuento (String tipoCliente){
    if (tipoCliente.equalsIgnoreCase("NINO"))return "10%";
    if (tipoCliente.equalsIgnoreCase("MUJER"))return "20%";
    if (tipoCliente.equalsIgnoreCase("ESTUDIANTE"))return "15%";
    if (tipoCliente.equalsIgnoreCase("ADULTO MAYOR"))return "25%";
    return "0%";
    }
    
    public double calcularDescuento (String tipoCliente){
    
    if (tipoCliente.equalsIgnoreCase("NINO")) return 0.10;
    if (tipoCliente.equalsIgnoreCase("MUJER")) return 0.20;
    if (tipoCliente.equalsIgnoreCase("ESTUDIANTE")) return 0.15;
    if (tipoCliente.equalsIgnoreCase("ADULTO MAYOR")) return 0.25;
    else return 0.0;
    }
    
    public String venderEntrada (int idCliente, String tipoCliente,int numeroAsiento, String tipoEntrada){
    if (asientosOcupados.contains(numeroAsiento)){
    return "ASIENTO OCUPADO!";
    }
    
    double precioBase = calcularPrecio(tipoEntrada);
    double descuento = calcularDescuento(tipoCliente);
    double precioFinal = precioBase * (1- descuento);
    
    Cliente cliente = new Cliente (idCliente,tipoCliente);
    Entrada entrada = new Entrada (numeroAsiento, tipoEntrada);
    String tipoDescuento = aplicarDescuento(tipoCliente);
    Venta venta = new Venta (contadorVentas + 1, cliente, entrada, precioFinal, tipoDescuento);
    
    ventas[contadorVentas++]= venta;
    asientosOcupados.add(numeroAsiento);
    System.out.println();
    return "VENTA REALIZADA! ID VENTA: " + venta.idVenta + ", DESCUENTO APLICADO %"+(int)(descuento*100)+", PRECIO FINAL: $"+precioFinal;
    } 
    
    public boolean eliminarEntrada (int idVenta){
    for (int i=0; i < contadorVentas; i++){
        if (ventas[i] != null && ventas[i].idVenta== idVenta){
        asientosOcupados.remove((Integer) ventas[i].entrada.numeroAsiento);
        ventas[i] = null;
        return true;
       }
     }
     return false;
    }
    
    public Venta buscarVenta(int idVenta){
       for (int i=0; i<contadorVentas; i++){
          if (ventas[i] != null && ventas[i].idVenta == idVenta){
           return ventas[i];
         }
      } 
     return null;
     }
    
    
    public void mostrarResumen(){
    System.out.println("*** RESUMEN DE VENTAS ***");
    for (int i = 0; i < contadorVentas; i++){
       if (ventas[i] != null){
           Venta venta = ventas[i];
       System.out.println("ID VENTA:" + venta.idVenta);
       System.out.println("ID CLIENTE: "+ venta.cliente.idCliente);
       System.out.println("DESCUENTO: "+ venta.tipoDescuento);
       System.out.println("ASIENTO N*: "+ venta.entrada.numeroAsiento);
       System.out.println("TIPO ENTRADA: "+ venta.entrada.tipoEntrada);
       System.out.println("PRECIO FINAL: $"+ venta.precioFinal);
       System.out.println("**************************");
       } 
     }
    }
      
    public void MenuPrincipal(){
     Scanner scanner = new Scanner(System.in);   
    System.out.println("**** MENU ****");
    System.out.println("POR FAVOR INGRESE UNA OPCION: ");
    System.out.println("1. VENDER ENTRADA");
    System.out.println("2. ELIMINAR ENTRADA");
    System.out.println("3. MOSTRAR ENTRADA POR ID");
    System.out.println("4. MOSTRAR RESUMEN");
    System.out.println("5. SALIR");
    }
    
    
    
}
