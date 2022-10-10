package com.paquete;

import java.util.*;

import com.paquete.clases.*;
import com.paquete.metodos.Controladora;

public class Principal {
    static List<Arbitro> listaArbitral = new ArrayList();
    static Equipo Equipo1 = new Equipo();
    static Equipo Equipo2 = new Equipo();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("┌────────────────────────┐");
        System.out.println("│      Bienvenido!!!     │");
        System.out.println("└────────────────────────┘");
        partido();
    }
    public static String equipo1 = "";
    public static String equipo2 = "";

    public static void partido() {
        Scanner scan = new Scanner(System.in);
        boolean plantilla = false;
        boolean partido = false;
        boolean arbitral = false;
        System.out.println("┌────────────────────────────┐");
        System.out.println("│      Por favor ingrese     │");
        System.out.println("│           Equipo 1         │");
        System.out.println("└────────────────────────────┘");
        equipo1 = scan.nextLine();
        System.out.println("┌────────────────────────────┐");
        System.out.println("│      Por favor ingrese     │");
        System.out.println("│           Equipo 2         │");
        System.out.println("└────────────────────────────┘");
        equipo2 = scan.nextLine();
        byte fin = 1;
        while (fin != 0) {
            System.out.println("┌────────────────────────────────┐");
            System.out.println("│ 1  Agregar datos del partido   │");
            System.out.println("│ 2       Agregar plantilla      │");
            System.out.println("│ 3       Agregar arbitral       │");
            System.out.println("│ 0       Iniciar partido        │");
            System.out.println("└────────────────────────────────┘");
            byte opcion = scan.nextByte();
            switch (opcion) {
                case 1:
                    if (partido == false) {
                        Controladora.agregarPartido();
                        partido = true;
                    } else {
                        System.out.println("Los datos del partido ya fueron ingresados");
                    }
                    break;
                case 2:
                    if (plantilla == false) {
                        boolean eq1 = Controladora.ingresarEquipo1();
                        boolean eq2 = Controladora.ingresarEquipo2();
                        Equipo1 = Controladora.equipo1();
                        Equipo2 = Controladora.equipo2();
                        if (eq1 == true && eq2 == true)
                            plantilla = true;
                    } else {
                        System.out.println("La planilla ya fue ingresada");
                    }
                    break;
                case 3:
                    if (arbitral == false) {
                        listaArbitral = Controladora.agregarArbitros();
                        arbitral = true;
                    } else {
                        System.out.println("El arbitral ya fue ingresado");
                    }
                    break;
                case 0:
                    if (plantilla == true && arbitral == true && partido == true) {
                        inicioPartido();
                        fin = 0;
                    } else {
                        System.out.println("Faltan datos");
                    }
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }
    }

    public static void inicioPartido() {
        Scanner scan = new Scanner(System.in);
        byte fin = -1;
        while (fin != 0) {
            System.out.println("┌────────────────────────────────┐");
            System.out.println("│ 1       Listar encuentro       │");
            System.out.println("│ 2        Cambio jugador        │");
            System.out.println("│ 3       Expulsar jugador       │");
            System.out.println("│ 4          Marcar Gol          │");
            System.out.println("│ 0       Finalizar partido      │");
            System.out.println("└────────────────────────────────┘");
            byte opcion = scan.nextByte();
            switch (opcion) {
                case 1:
                    Controladora.listarEncuentro();
                    break;
                case 2:
                    Controladora.cambiarJugador();
                    break;
                case 3:
                    Controladora.expulsarJugador();
                    break;
                case 4:
                    Controladora.marcarGol();
                    break;
                case 0:
                    fin = 0;
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }
        Controladora.finalizarPartido();
    }
}
