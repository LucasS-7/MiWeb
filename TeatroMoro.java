package com.mycompany.teatromoro;
import java.util.Scanner;


public class TeatroMoro {
    static int filas=8,contadorReserva=0,contadorCompra=0;
    static int columnas=7;
    static int opcion =5;
    static char [][] asientos = new char [filas] [columnas];
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("****BIENVENIDO A TEATRO MORO****");
         
        while(opcion>=1 && opcion<=5 ){
            //MOSTRAR MENU
            TeatroMoro.menuPrincipal();
          switch (opcion){  
              
              case 1:
                  TeatroMoro.mostrarAsientos();
                  TeatroMoro.seleccionarAsiento();
                  
                  break;
                  
              case 2:
                  
                  TeatroMoro.realizarCompra();
                  
                  break;
              case 3:
                  TeatroMoro.modificarCompra();
                  
                  break;
              case 4:
                  
                  TeatroMoro.imprimirBoleta();
                  break;
              case 5:
                  
                  System.out.println("SALIENDO DEL PROGRAMA... NOS VEMOS PRONTO");
                  opcion++;
                  break;
            
              default:
                  System.out.println("LO SIENTO, DEBE INGRESAR UNA OPCION VALIDA");
                    
          }
        } 
        
    }
    
    
    public static void menuPrincipal(){
       Scanner scanner = new Scanner(System.in);
        
    System.out.println("POR FAVOR INGRESE UNA OPCION: ");
    System.out.println("1-RESERVAR ENTRADA");
    System.out.println("2-COMPRAR ENTRADA");
    System.out.println("3-MODIFICAR UNA VENTA EXISTENTE");
    System.out.println("4-IMPRIMIR BOLETA");
    System.out.println("5-SALIR DEL PROGRAMA");
    opcion = scanner.nextInt();
    }
    public static void inicializarAsientos(){
        
    //MATRIZ PARA CREAR ASIENTOS
        for (int filas=0; filas<8;filas++){
         for( int columnas=0; columnas<7; columnas++){
            asientos [filas][columnas]= ' ';}      
        }
    }
    public static void mostrarAsientos(){
    
    //MOSTRAR ASIENTOS DISPONIBLES
    System.out.println("******* UBICACION TOTAL ASIENTOS DEL TEATRO**********");
    System.out.println("[ ]--> ASIENTO DISPONIBLE // [X] --> ASIENTO OCUPADO ");
    System.out.println("            [ ESCENARIO ]          ");
    for (int filas=0; filas<8;filas++){
        System.out.print("Fila "+ filas+": ");
        for( int columnas=0; columnas<7; columnas++){
            System.out.print(" ");  
            if (asientos [filas][columnas]=='X'){ System.out.print("[X]");}
            else System.out.print("[ ]");
            }
    System.out.println();
       }
    }
    public static void seleccionarAsiento(){
        Scanner scanner = new Scanner(System.in);
        while(filas>=0 && filas>=7){
        System.out.println("POR FAVOR INGRESE FILA (DE 0 A 7)");
        filas = scanner.nextInt();}
        while(columnas>=0 && columnas>=7){
        System.out.println("POR FAVOR INGRESE COLUMNA (DE 0 A 6)");
        columnas = scanner.nextInt();}
        System.out.println("SU RESERVA EN FILA:"+filas+", COLUMNA:"+columnas+" A SIDO REGISTRADA");
        System.out.println("************************************************************");
        contadorReserva++;
    }
    
    public static boolean reservarAsiento(int filas, int columnas){
    if (asientos [filas][columnas]== 'X'){ return false;}
    else {asientos [filas][columnas] = 'X';  return true;}
    
    }
    
    public static void realizarCompra(){
        Scanner scanner = new Scanner(System.in);
        if (contadorReserva>=1){
        System.out.println("DESEA REALIZAR LA COMPRA DE SU RESERVA? (1-SI/2-NO)");
        int comprar = scanner.nextInt();
        if (comprar==1){System.out.println("COMPRA REALIZADA, DISFRUTE LA FUNCION!");
                     System.out.println("*********************");
        contadorCompra++;
        }else if (comprar!=1){System.out.println("OK, COMPRA NO REALIZADA");
        System.out.println("*********************");
            }
        }else {
        System.out.println("PARA ESTA OPCION PRIMERO DEBE TENER UNA RESERVA ASIGNADA");
        System.out.println("*********************************************");
        }
    }
    
    public static void modificarCompra(){
        Scanner scanner = new Scanner(System.in);
        if (contadorCompra>=1){
            System.out.println("********************************");
            System.out.println("COMPRA N*:"+contadorCompra);
            System.out.println("DESEA MODIFICAR SU COMPRA DE FILA:"+filas+", COLUMNA:"+columnas+" ?");
            System.out.println("1-SI / 2-NO");
            opcion = scanner.nextInt();
            if (opcion==1){
            contadorReserva--;
            System.out.println("POR FAVOR INGRESE FILA (DE 0 A 7)");
            filas = scanner.nextInt();
            System.out.println("POR FAVOR INGRESE COLUMNA (DE 0 A 6)");
            columnas = scanner.nextInt();
            System.out.println("SU COMPRA EN FILA:"+filas+", COLUMNA:"+columnas+" A SIDO MODIFICADA");
            System.out.println("************************************************************");
            contadorReserva++;
            }else{
            System.out.println("OK, COMPRA CONSERVADA");
            }
        }else{
        System.out.println("PARA ESTA OPCION PRIMERO DEBE TENER UNA COMPRA REALIZADA");
        System.out.println("*********************************************");
        }
    }
    
    public static void imprimirBoleta(){
    
    if(contadorCompra>=1){    
    System.out.println("*****************************");
    System.out.println("     BOLETA TEATRO MORO      ");
    System.out.println("-----------------------------");
    System.out.println();
    System.out.println("UBICACION DE SU ASIENTO:");
    System.out.println("FILA: "+filas);
    System.out.println("COLUMNA: "+ columnas);
    System.out.println("-----------------------------");
    System.out.println("VALOR DE LA ENTRADA: $10.000");
    System.out.println();
    System.out.println("*****************************");
    }else{
    System.out.println("PARA ESTA OPCION PRIMERO DEBE TENER UNA COMPRA REALIZADA");
    System.out.println("*********************************************");
    }
    
    }
    
    
    
}