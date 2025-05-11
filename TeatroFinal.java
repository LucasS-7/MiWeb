package cl.douc.teatrofinal;
import java.util.Scanner;


public class TeatroFinal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int opcion = 5;
        MenuTeatro menu = new MenuTeatro();
        
        System.out.println("BIENVENIDO A TEATRO MORO!");
        while (opcion >=1 && opcion<=5) {
        menu.MenuPrincipal(); //MENU PRINCIPAL
        opcion = scanner.nextInt();
        
         switch (opcion){
             case 1: //OPCION 1: VENTA ENTRADA
                 System.out.println("POR FAVOR INGRESA LOS SIGUIENTES DATOS: ");
                 System.out.print("ID CLIENTE: ");
                 int idCliente = scanner.nextInt(); scanner.nextLine();
                 System.out.println("TIPO CLIENTE: (NINO / MUJER / ADULTO MAYOR / ESTUDIANTE /GENERAL");
                 String tipoCliente = scanner.nextLine();
                 System.out.println("NUMERO DE ASIENTO (DEL 0 AL 99): ");
                 int numeroAsiento = scanner.nextInt(); scanner.nextLine();
                 System.out.println("TIPO DE ENTRADA (VIP/ PALCO/ PLATEA BAJA/ PLATEA ALTA/GALERIA)");
                 String tipoEntrada = scanner.nextLine();
                 String resultado = menu.venderEntrada(idCliente, tipoCliente, numeroAsiento, tipoEntrada);
                 System.out.println(resultado);
                 System.out.println("************************************************************");
                 break;
                 
            case 2: //OPCION 2: ELIMINAR VENTA
                 System.out.println("POR FAVOR INGRESE (ID DE VENTA A ELIMINAR): ");
                 int idEliminar = scanner.nextInt();
                 if (menu.eliminarEntrada(idEliminar)){
                     System.out.println("VENTA ELIMINADA!");
                 }else {
                     System.out.println("ID DE VENTA INVALIDO, NO SE ENCONTRO LA VENTA A ELIMINAR");
                     System.out.println("********************************************************");        
                 }
                 break;
                 
            case 3: //OPCION 3: BUSCAR ENTRADA 
                
                 System.out.println("POR FAVOR INGRESE (ID DE VENTA A BUSCAR):");
                 int idBuscar = scanner.nextInt();
                 Venta venta = menu.buscarVenta(idBuscar);
                 if (venta != null){
                  System.out.println("ID VENTA:" + venta.idVenta);
                  System.out.println("ID CLIENTE: "+ venta.cliente);
                  System.out.println("DESCUENTO: "+ venta.tipoDescuento);
                  System.out.println("ASIENTO N*: "+ venta.entrada.numeroAsiento);
                  System.out.println("TIPO ENTRADA: "+ venta.entrada.tipoEntrada);
                  System.out.println("PRECIO FINAL: $"+ venta.precioFinal);
                 }else {
                 System.out.println("ID DE VENTA INVALIDO, NO SE ENCONTRO LA ENTRADA A BUSCAR");
                 System.out.println("********************************************************");
                 
                 }
                 break;
                 
            case 4: //OPCION 4: MOSTRAR RESUMEN DE VENTAS
                
                menu.mostrarResumen();
                break;
                
            case 5: //OPCION 5: SALIR 
                
                 System.out.println("SALIENDO DEL PROGRAMA... NOS VEMOS PRONTO!");
                 opcion++;
                 break;
            default:      
                System.out.println("OPCION inVALIDA!");
            }   
        } 
        scanner.close();
    }
    
}
