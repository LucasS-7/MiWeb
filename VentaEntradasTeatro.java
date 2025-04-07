package com.mycompany.ventaentradasteatro;

import java.util.Scanner;

public class VentaEntradasTeatro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion, cantidadAsientosVip=20,cantidadAsientosBaja=35,cantidadAsientosAlta=50;
        int zonaAsientos = 3,valorEntrada=0,edad;
        double descuento, valorTotal;
        String zonaEntrada = "";
        
        
        System.out.println("BIENVENIDO A TEATRO MORO");
        //MENÚ INICIO:
        for (opcion=1;opcion <=2;opcion++){
          System.out.println("Por favor ingrese una opcion: ");
          System.out.println("1- Comprar entrada");
          System.out.println("2- Salir");
          opcion = scanner.nextInt();
              
       
        //MENÚ ZONA DE ASIENTOS.(Muestra el Valor de Entrada y Asientos Disponibles respectivamente).
         if(opcion==1){ 
         System.out.println("A CONTINUACION TE MUESTRO LA CANTIDAD DE ASIENTOS DISPONIBLES POR ZONA:");
         System.out.println("1- ENTRADA VIP || VALOR $15.000 || ASIENTOS DISPONIBLES:"+cantidadAsientosVip);
         System.out.println("2- PLATEA BAJA || VALOR $12.000 || ASIENTOS DISPONIBLES:"+cantidadAsientosBaja);
         System.out.println("3- PLATEA ALTA || VALOR $10.000 || ASIENTOS DISPONIBLES:"+cantidadAsientosAlta);
         System.out.println("POR FAVOR INGRESE LA ZONA DE LA ENTRADA QUE DESEA COMPRAR:"); 
         zonaAsientos = scanner.nextInt();
        
        
        // VALOR DE ENTRADA SEGUN ZONA DE ASIENTO
         switch (zonaAsientos){
         case 1: valorEntrada=15000;
         cantidadAsientosVip = cantidadAsientosVip - 1;
         zonaEntrada="VIP";
         break;
         case 2: valorEntrada=12000;
         cantidadAsientosBaja = cantidadAsientosBaja - 1;
         zonaEntrada="PLATEA BAJA";
         break;
         case 3: valorEntrada=10000;
         cantidadAsientosAlta = cantidadAsientosAlta - 1;
         zonaEntrada="PLATEA ALTA";
         break;
         default:
         System.out.println("Por favor, ingrese una opcion valida");return;
        }
        
        /*METODO DESCUENTO SEGUN EDAD(Si es mayor de 65 años es adulto mayor)
                                     (Si tiene desde 9 a  hasta 25 años de edad, se considera estudiante)*/
        System.out.print("Por favor ingrese su edad: ");
        edad = scanner.nextInt();
        if(edad>=65){System.out.println("Eres adulto mayor, tienes un 15% de Dcto.");descuento = 0.15;}                            
        else if (edad>9  && edad<26){System.out.println ("Eres estudiante, tienes un 10% de Dcto.");descuento=0.10;}
        else {System.out.println("Lo siento, no tienes descuentos aplicables");descuento=0;}
        
        //DESGLOCE DE RESUMEN DE COMPRA
        valorTotal = valorEntrada-(valorEntrada*descuento);
        System.out.println("***************************************");
        System.out.println("Su asiento se encuentra en la Zona: "+zonaEntrada);
        System.out.println("Precio Base Entrada: $"+valorEntrada);
        System.out.println("Descuento aplicado de: %"+(int)(100*descuento));
        System.out.println("Precio final a pagar: $"+ (int)valorTotal);
        System.out.println("***************************************");
        
        //CONSULTA DE OTRA COMPRA
        System.out.println("Desea realizar otra compra? OPCION 1-SI/2-NO:"); 
        int otraCompra = scanner.nextInt();
        if (otraCompra ==1);
        else if (otraCompra!=1){System.out.println("Saliendo del Programa... Nos vemos Pronto ");return;}
        
       // OPCION 2: SALIDA DEL PROGRAMA 
       }else if (opcion==2){
        System.out.println("Saliendo del Programa... Nos vemos Pronto ");
        
       }else{ 
        System.out.println("Por favor, ingrese una opcion valida");
      }
    }  
    scanner.close();    
  }      
}
