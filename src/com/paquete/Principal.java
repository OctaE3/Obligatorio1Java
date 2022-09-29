package com.paquete;
import java.util.*;
import com.paquete.persona.*;


public class Principal {
    static List<Arbitro> listaArbitral = new ArrayList();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            System.out.println("┌─────────────────────┐");
            System.out.println("│      Bienvenido     │");
            System.out.println("│      Presione 1     │");
            System.out.println("└─────────────────────┘");
            byte opcion = scan.nextByte();
            switch(opcion){
                case 1:
                    partido();
                    break;
                default:
                    System.out.println("Ingrese 1 para comenzar");
                    break;
            }
    }
    static String equipo1 = "";
    static String equipo2 = "";
    public static void partido(){
        Scanner scan = new Scanner(System.in);
        boolean plantilla = false;
        boolean partido = false;
        boolean arbitral = false;
        System.out.println("┌─────────────────────┐");
        System.out.println("│       Equipo 1      │");
        System.out.println("└─────────────────────┘");
        equipo1 = scan.nextLine();
        System.out.println("┌─────────────────────┐");
        System.out.println("│       Equipo 2      │");
        System.out.println("└─────────────────────┘");
        equipo2 = scan.nextLine();
        byte fin = 1;
        while(fin !=0){
            System.out.println("┌────────────────────────────────┐");
            System.out.println("│ 1  Agregar datos del partido   │");
            System.out.println("│ 2       Agregar plantilla      │");
            System.out.println("│ 3       Agregar arbitral       │");
            System.out.println("│ 0       Iniciar partido        │");
            System.out.println("└────────────────────────────────┘");
            byte opcion = scan.nextByte();
            switch (opcion){
                case 1:
                    if(partido == false){
                        agregarDatosPartido();
                        partido = true;
                    }
                    else{
                        System.out.println("Los datos del partido ya fueron ingresados");
                    }
                    break;
                case 2:
                if(plantilla == false){
                    agregarPlantilla();
                    plantilla = true;
                }
                else{
                    System.out.println("La planilla ya fue ingresada");
                }
                break;
                case 3:
                if(arbitral == false){
                    agregarArbitral();
                    arbitral = true;
                }
                else{
                    System.out.println("El arbitral ya fue ingresado");
                }
                break;
                case 0:
                    if(plantilla == true && arbitral == true && partido == true){
                        inicioPartido();
                        fin = 0;
                    }
                    else{
                        System.out.println("Faltan datos");
                    }
                    break;
                default:
                    break;
            }
        }
    }
    public static void agregarPlantilla(){
        byte contJugador = 0;
        System.out.println("bbcitaaaaaaa");
    }
    public static void agregarDatosPartido(){
        System.out.println("bbcitaaaaaaa");
    }
    public static void agregarArbitral(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los arbitros");
        for (int i = 0; i < 3; i++)
        {
            System.out.println("Nombre");
            String nom = scan.next();
            System.out.println("Apellido");
            String ape = scan.next();
            System.out.println("Puesto");
            String puesto = scan.next();
            Arbitro arb = new Arbitro(nom,ape,puesto);
            listaArbitral.add(arb);

        }
        System.out.println(listaArbitral.toString());
    }
    public static void inicioPartido(){
        System.out.println("┌────────────────────────────────┐");
        System.out.println("│ 1       Listar encuentro       │");
        System.out.println("│ 2        Cambio jugador        │");
        System.out.println("│ 3          Marcar Gol          │");
        System.out.println("│ 0       Finalizar partido      │");
        System.out.println("└────────────────────────────────┘");
        System.out.println(listaArbitral.toString());
    }
}
