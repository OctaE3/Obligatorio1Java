package com.paquete.metodos;

import com.paquete.Principal;

import java.util.*;

import com.paquete.clases.*;
import jdk.swing.interop.SwingInterOpUtils;

public class Controladora {

    //region Listas e Instancias
    private static Partido Partido = new Partido(); // Instancia Partido
    private static Equipo Equipo1 = new Equipo();   // Instancia Equipo 1
    private static Equipo Equipo2 = new Equipo();   // Instancia Equipo 2
    static List<Arbitro> listaArbitral = new ArrayList();   // Lista de los árbitros
    static List<Jugador> listaJugadoresTitularesEq1 = new ArrayList();  // Lista de los jugadores titulares del equipo 1
    static List<Jugador> listaJugadoresSuplentesEq1 = new ArrayList();  // Lista de los jugadores suplentes del equipo 1
    static List<Jugador> listaJugadoresGoleadoresEq1 = new ArrayList(); // Lista de los jugadores goleadores del equipo 1
    static List<Jugador> listaJugadoresTitularesEq2 = new ArrayList(); // Lista de los jugadores titulares del equipo 2
    static List<Jugador> listaJugadoresSuplentesEq2 = new ArrayList();  // Lista de los jugadores suplentes del equipo 2
    static List<Jugador> listaJugadoresGoleadoresEq2 = new ArrayList(); // Lista de los jugadores goleadores del equipo 2
    private static List<Jugador> listaJugadoresExpulsadosEquipo1 = new ArrayList(); // Lista de jugadores expulsados Equipo 1
    private static List<Jugador> listaJugadoresExpulsadosEquipo2 = new ArrayList(); // Lista de jugadores expulsados Equopo 2
    //endregion
    public static Partido partido() {
        return Partido;
    } // Retorna el partido
    public static Equipo equipo1() {
        return Equipo1;
    } // Retorna el Equipo 1
    public static Equipo equipo2() {
        return Equipo2;
    } // Retorna el Equipo 2
    public static List<Arbitro> agregarArbitros() {
        Scanner scan = new Scanner(System.in);
        System.out.println("┌──────────────────────┐");
        System.out.println("│ Ingrese los árbitros │"); // Solicita los datos necesarios para ingresar los 3 arbitros
        System.out.println("└──────────────────────┘");
        for (int i = 0; i < 2; i++) {
            System.out.println("** Nombre **");
            String nom = scan.next();
            System.out.println("** Apellido **");
            String ape = scan.next();
            System.out.println("** Puesto **");
            String puesto = scan.next();
            Arbitro arb = new Arbitro(nom, ape, puesto); // Instancia la clase Arbitro con los valores ingresados
            listaArbitral.add(arb); // Añade el arbitro ingresado a la lista de arbitros

        }
        return listaArbitral; // Retorna la lista de Arbitros
    }
    public static boolean ingresarEquipo1() {
        String nombre = Principal.equipo1;
        byte gol = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("** Ingrese los Datos de " + nombre +" **"); // Solicita todos los datos necesarios para ingresar un equipo 1
        System.out.println("*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*");

        System.out.println("** Ingrese los datos del Director Técnico **"); // Pide ingresar los datos del director técnico del equipo 1

        System.out.println("** Nombre del director técnico **");
        String nombreTecnico = scan.next();

        System.out.println("** Apellido del director técnico **");
        String apellidoTecnico = scan.next();

        System.out.println("** Edad del director técnico ** ");
        byte edadTecnico = scan.nextByte();

        DT TecnicoEq1 = new DT(nombreTecnico, apellidoTecnico, edadTecnico); // Instanciamos la clase DT(Director Técnico) con los valores ingresados
        System.out.println("*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*");
        System.out.println("** Ingrese los Jugadores Titulares **"); // Pide ingresar los datos de los Jugadores Titulares del equipo 1
        System.out.println("");
        for (int i = 0; i < 2; i++) {
            System.out.println("** Ingrese el nombre del jugador **");
            String nombreTitular = scan.next();

            System.out.println("** Ingrese el apellido del jugador **");
            String apellidoTitular = scan.next();

            System.out.println("** Ingrese la edad del jugador **");
            byte edadTitular = scan.nextByte();

            System.out.println("** Ingrese el puesto del jugador **");
            String puestoTitular = scan.next();

            System.out.println("** Ingrese el dorsal del jugador **");
            byte dorsalTitular = scan.nextByte();
            System.out.println("────────────────────────────────");

            if (listaJugadoresTitularesEq1.size() == 0) {
                // Instanciamos los Jugadores con los datos ingresados
                Jugador jugador = new Jugador(nombreTitular, apellidoTitular, edadTitular, puestoTitular, dorsalTitular, gol);
                listaJugadoresTitularesEq1.add(jugador); // Añade los jugadores a la lista de jugadores titulares del equipo 1
            } else {
                boolean repetido = false;
                for (Jugador unJugador : listaJugadoresTitularesEq1) { // Chequeamos que el dorsal de los jugadores no se repita
                    if (unJugador.get_numero() == dorsalTitular) {
                        System.out.println("Este dorsal ya esta en uso!");
                        i--;
                    } else {
                        repetido = true;
                    }
                }
                if (repetido == true) { // En caso de que no se repita el dorsal del jugador, los agregamos a la lista de jugadores titulares.
                    Jugador jugador = new Jugador(nombreTitular, apellidoTitular, edadTitular, puestoTitular, dorsalTitular, gol);
                    listaJugadoresTitularesEq1.add(jugador);
                }
            }
        }
        System.out.println("*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*");
        System.out.println("** Ingrese los datos de los jugadores suplentes **"); // Solicitamos los datos de los jugadores suplentes.
        System.out.println("");
        for (int i = 0; i < 1; i++) {
            System.out.println("** Ingrese el nombre del jugador **");
            String nombreSuplente = scan.next();

            System.out.println("** Ingrese el apellido del jugador **");
            String apellidoSuplente = scan.next();

            System.out.println("** Ingrese la edad del jugador **");
            byte edadSuplente = scan.nextByte();

            System.out.println("** Ingrese el puesto del jugador **");
            String puestoSuplente = scan.next();

            System.out.println("** Ingrese el dorsal del jugador **");
            byte dorsalSuplente = scan.nextByte();
            System.out.println("────────────────────────────────");
            boolean repetidoT = false;
            boolean repetidoS = false;
            for (Jugador unJugador : listaJugadoresTitularesEq1) { // Chequeamos que el dorsal del jugador suplente no este repetido
                if (unJugador.get_numero() == dorsalSuplente) {
                    repetidoT = true;
                }
            }
            for (Jugador unJugador : listaJugadoresSuplentesEq1) { // Chequeamos que el dorsal del jugador suplente no este repetido
                if (unJugador.get_numero() == dorsalSuplente) {
                    repetidoS = true;
                }
            }
            if (repetidoT == true || repetidoS == true) { // Si el dorsal está repetido, retornamos que está en uso.
                System.out.println("Este dorsal ya esta en uso!");
                i--;
            } else { // De lo Contrario lo agregamos a la lista de jugadores suplentes del equipo 1
                Jugador jugador = new Jugador(nombreSuplente, apellidoSuplente, edadSuplente, puestoSuplente, dorsalSuplente, gol);
                listaJugadoresSuplentesEq1.add(jugador);
            }
        }
        // Instanciamos la clase Equipo con los datos ingresados.
        Equipo team = new Equipo((byte) 1, nombre, listaJugadoresTitularesEq1, listaJugadoresSuplentesEq1, TecnicoEq1);
        Equipo1 = team; // Le asignamos el valor del Equipo 1 instanciado a una instancia global de la clase Equipo 1

        if (TecnicoEq1 != null && listaJugadoresTitularesEq1.size() == 2 && listaJugadoresSuplentesEq1.size() == 1) {
            // Si las listas de jugadores titulares y la de jugadores suplentes esta completa retornamos, true
            return true;
        }
        return false; // De lo contrario retornamos, false
    }
    public static boolean ingresarEquipo2() {
        String nombre = Principal.equipo2;
        Scanner scan = new Scanner(System.in);
        byte gol = 0;
        System.out.println("** Ingrese los Datos de " + nombre + " **"); // Solicita todos los datos necesarios para ingresar un equipo 2
        System.out.println("*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*");

        System.out.println("** Ingrese los datos del Director Técnico **"); // Pide ingresar los datos del director técnico del equipo 2

        System.out.println("** Nombre del director técnico **");
        String nombreTecnico = scan.next();

        System.out.println("** Apellido del director técnico **");
        String apellidoTecnico = scan.next();

        System.out.println("** Edad del director técnico **");
        byte edadTecnico = scan.nextByte();

        // Instanciamos la clase DT(Director Técnico) con los valores ingresados
        DT TecnicoEq2 = new DT(nombreTecnico, apellidoTecnico, edadTecnico);
        System.out.println("*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*");
        System.out.println("** Ingrese los Jugadores Titulares **"); // Solicita ingresar los datos de los Jugadores Titulares del equipo 2
        System.out.println("");
        for (int i = 0; i < 2; i++) {
            System.out.println("** Ingrese el nombre del jugador **");
            String nombreTitular = scan.next();

            System.out.println("** Ingrese el apellido del jugador **");
            String apellidoTitular = scan.next();

            System.out.println("** Ingrese la edad del jugador **");
            byte edadTitular = scan.nextByte();

            System.out.println("** Ingrese el puesto del jugador **");
            String puestoTitular = scan.next();

            System.out.println("** Ingrese el dorsal del jugador **");
            byte dorsalTitular = scan.nextByte();
            System.out.println("────────────────────────────────");

            if (listaJugadoresTitularesEq2.size() == 0) {
                // Instanciamos los Jugadores con los datos ingresados
                Jugador jugador = new Jugador(nombreTitular, apellidoTitular, edadTitular, puestoTitular, dorsalTitular, gol);
                listaJugadoresTitularesEq2.add(jugador); // Añade los jugadores a la lista de jugadores titulares del equipo 2
            } else {
                boolean repetido = false;
                for (Jugador unJugador : listaJugadoresTitularesEq2) { // Chequeamos que el dorsal de los jugadores no se repita
                    if (unJugador.get_numero() == dorsalTitular) {
                        System.out.println("Este dorsal ya esta en uso!");
                        i--;
                    } else {
                        repetido = true;
                    }
                }
                if (repetido == true) { // En caso de que no se repita el dorsal del jugador, los agregamos a la lista de jugadores titulares.
                    Jugador jugador = new Jugador(nombreTitular, apellidoTitular, edadTitular, puestoTitular, dorsalTitular, gol);
                    listaJugadoresTitularesEq2.add(jugador);
                }
            }
        }
        System.out.println("*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*─*");
        System.out.println("Ingrese los datos de los jugadores suplentes"); // Solicitamos los datos de los jugadores suplentes.
        System.out.println("");
        for (int i = 0; i < 1; i++) {
            System.out.println("Ingrese el nombre del jugador");
            String nombreSuplente = scan.next();

            System.out.println("Ingrese el apellido del jugador");
            String apellidoSuplente = scan.next();

            System.out.println("Ingrese la edad del jugador");
            byte edadSuplente = scan.nextByte();

            System.out.println("Ingrese el puesto del jugador");
            String puestoSuplente = scan.next();

            System.out.println("Ingrese el dorsal del jugador");
            byte dorsalSuplente = scan.nextByte();
            System.out.println("────────────────────────────────");
            boolean repetidoT = false;
            boolean repetidoS = false;
            for (Jugador unJugador : listaJugadoresTitularesEq2) { // Chequeamos que el dorsal del jugador suplente no este repetido
                if (unJugador.get_numero() == dorsalSuplente) {
                    repetidoT = true;
                }
            }
            for (Jugador unJugador : listaJugadoresSuplentesEq2) { // Chequeamos que el dorsal del jugador suplente no este repetido
                if (unJugador.get_numero() == dorsalSuplente) {
                    repetidoS = true;
                }
            }
            if (repetidoT == true || repetidoS == true) { // Si el dorsal está repetido, retornamos que está en uso.
                System.out.println("Este dorsal ya esta en uso!");
                i--;
            } else {
                Jugador jugador = new Jugador(nombreSuplente, apellidoSuplente, edadSuplente, puestoSuplente, dorsalSuplente, gol);
                listaJugadoresSuplentesEq2.add(jugador); // De lo Contrario lo agregamos a la lista de jugadores suplentes del equipo 2
            }
        }
        // Instanciamos la clase Equipo con los datos ingresados.
        Equipo team = new Equipo((byte) 1, nombre, listaJugadoresTitularesEq2, listaJugadoresSuplentesEq2, TecnicoEq2);
        Equipo2 = team; // Le asignamos el valor del Equipo 2 instanciado a una instancia global de la clase Equipo 2

        if (TecnicoEq2 != null && listaJugadoresTitularesEq2.size() == 2 && listaJugadoresSuplentesEq2.size() == 1) {
            return true; // Si las listas de jugadores titulares y la de jugadores suplentes esta completa retornamos, true
        }
        return false; // De lo contrario retornamos, false
    }
    public static boolean expulsarJugador() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el número del equipo, en el que se encuentra el jugador");
        // Pedimos ingresar el número del equipo al que el jugador pertenece
        System.out.println("1. " + equipo1().get_nombre());
        System.out.println("2. " + equipo2().get_nombre());
        byte opcion = scan.nextByte();

        System.out.println("Ingrese el dorsal del jugador"); // Solicitamos el dorsal del jugador que quiere expulsar
        byte dorsal = scan.nextByte();

        if (opcion == 1) {
            for (Jugador jugador : listaJugadoresTitularesEq1) {
                // Buscamos en la lista de jugadores titulares, el jugador que quiere expulsar
                if (jugador.get_numero() == dorsal) {
                    Equipo1.get_listaTitulares().remove(jugador); // Si el jugador se encuentra en la lista, lo removemos de la lista.
                    listaJugadoresExpulsadosEquipo1.add(jugador); // Y lo añadimos en la lista de jugadores expulsados del equipo 1.
                    return true; // Por último retornamos verdadero
                } else { // En caso de que el jugador, no se encuentre en la lista de jugadores titulares
                    for (Jugador unJugador : listaJugadoresSuplentesEq1) {
                        // Buscamos en la lista de jugadores suplentes
                        if (unJugador.get_numero() == dorsal) {
                            Equipo1.get_listaSuplentes().remove(jugador); // Si el jugador se encuentra en la lista, lo removemos de la lista
                            listaJugadoresExpulsadosEquipo1.add(jugador); // Y lo añadimos en la lista de jugadores expulsados del equipo 1.
                            return true; // Por último retornamos verdadero
                        }
                    }
                }
            }
            return false; // Si no se cumplen ninguna de las 2 condiciones retornaremos, falso
        } else if (opcion == 2) {
            for (Jugador jugador : listaJugadoresTitularesEq2) {
                // Buscamos en la lista de jugadores titulares, el jugador que quiere expulsar
                if (jugador.get_numero() == dorsal) {
                    Equipo2.get_listaTitulares().remove(jugador); // Si el jugador se encuentra en la lista, lo removemos de la lista.
                    listaJugadoresExpulsadosEquipo2.add(jugador); // Y lo añadimos en la lista de jugadores expulsados del equipo 2.
                    return true; // Por último retornamos verdadero
                } else { // En caso de que el jugador, no se encuentre en la lista de jugadores titulares
                    for (Jugador unJugador : listaJugadoresSuplentesEq2) {
                        // Buscamos en la lista de jugadores suplentes
                        if (unJugador.get_numero() == dorsal) {
                            Equipo2.get_listaSuplentes().remove(jugador); // Si el jugador se encuentra en la lista, lo removemos de la lista
                            listaJugadoresExpulsadosEquipo2.add(jugador); // Y lo añadimos en la lista de jugadores expulsados del equipo 2.
                            return true; // Por último retornamos verdadero
                        }
                    }
                }
            }
            return false; // Si no, se cumplen ninguna de las 2 condiciones retornaremos, falso
        } else { // En caso de que el equipo ingresado no exista retornaremos, falso
            System.out.println("Ese equipo no existe");
            return false;
        }
    }
    public static boolean cambiarJugador() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el número del equipo, en el que se encuentra el jugador que desea sustituir ");
        // Pedimos ingresar el número del equipo al que el jugador pertenece
        System.out.println("1. " + equipo1().get_nombre());
        System.out.println("2. " + equipo2().get_nombre());
        byte opcion = scan.nextByte();

        // Solicitamos el número del dorsal del jugador titular
        System.out.println("Ingrese el dorsal del jugador titular");
        byte dorsalTitular = scan.nextByte();

        // Solicitamos el número del dorsal del jugador suplente
        System.out.println("Ingrese el dorsal del jugador suplente");
        byte dorsalSuplente = scan.nextByte();

        Jugador jugador = new Jugador();
        Jugador jogador = new Jugador();

        boolean jgT = false;
        boolean jgS = false;

        if (opcion == 1)
        {
            for(Jugador unJugador : listaJugadoresTitularesEq1) // Buscamos si el jugador titular existe.
            {
                if(unJugador.get_numero() == dorsalTitular)
                {
                    // Si el jugador es encontrado, le asignamos los valores del jugador encontrado a una instancia de jugador.
                    jugador = unJugador;
                    jgT = true;
                }
            }
            for(Jugador unJogador : listaJugadoresSuplentesEq1) // Buscamos si el jugador suplente existe.
            {
                if (unJogador.get_numero() == dorsalSuplente)
                {
                    // Si el jugador es encontrado, le asignamos los valores del jugador encontrado a una instancia de jugador.
                    jogador = unJogador;
                    jgS = true;
                }
            }
            if (jgT == true && jgS == true) // Si el jugador titular y suplente fueron encontrados.
            {
                Equipo1.get_listaTitulares().remove(jugador); // Removemos el jugador titular de la lista de titulares
                Equipo1.get_listaTitulares().add(jogador);    // Y añadimos el jugador titular a la lista de suplentes
                Equipo1.get_listaSuplentes().remove(jogador); // Removemos el jugador suplente de la lista de suplentes
                Equipo1.get_listaSuplentes().add(jugador);    // Y añadimos el jugador suplente a la lista de titulares
                return true; // Retornamos verdadero para finalizar
            } else { // Si no encontró uno de los 2 dorsales devolverá un mensaje de error y retornara falso
                System.out.println("Uno de los dorsal no es correcto!");
                return false;
            }
        }
        else if(opcion == 2)
        {
            for(Jugador unJugador : listaJugadoresTitularesEq2) // Buscamos si el jugador titular existe.
            {
                if(unJugador.get_numero() == dorsalTitular)
                {
                    // Si el jugador es encontrado, le asignamos los valores del jugador encontrado a una instancia de jugador.
                    jugador = unJugador;
                    jgT = true;
                }
            }
            for(Jugador unJogador : listaJugadoresSuplentesEq2) // Buscamos si el jugador suplente existe.
            {
                if (unJogador.get_numero() == dorsalSuplente)
                {
                    // Si el jugador es encontrado, le asignamos los valores del jugador encontrado a una instancia de jugador.
                    jogador = unJogador;
                    jgS = true;
                }
            }
            if (jgT == true && jgS == true) // Si el jugador titular y suplente fueron encontrados.
            {
                Equipo2.get_listaTitulares().remove(jugador); // Removemos el jugador titular de la lista de titulares
                Equipo2.get_listaTitulares().add(jogador);    // Y añadimos el jugador titular a la lista de suplentes
                Equipo2.get_listaSuplentes().remove(jogador); // Removemos el jugador suplente de la lista de suplentes
                Equipo2.get_listaSuplentes().add(jugador);    // Y añadimos el jugador suplente a la lista de titulares
                return true; // Retornamos verdadero para finalizar
            } else { // Si no encontró uno de los 2 dorsales devolverá un mensaje de error y retornara falso
                System.out.println("Uno de los dorsale no es correcto!");
                return false;
            }
        }
        else // Si el número que ingreso del equipo no existe, mostrara un mensaje y retornara falso.
        {
            System.out.println("Ese equipo no existe, intente nuevamente");
            return false;
        }
    }

    public static void agregarPartido() {
        Scanner scan = new Scanner(System.in);
        System.out.println("┌───────────────────────────────┐");
        System.out.println("│ Ingrese los datos del partido │");   // Solicita los datos necesarios para ingresar un partido.
        System.out.println("└───────────────────────────────┘");
        System.out.println("** Ingrese el estadio donde se disputa el encuentro **");
        String estadio = scan.nextLine();
        System.out.println("** Ingrese el dia del encuentro **");
        String dia = scan.next();
        System.out.println("** Ingrese la hora del encuentro **");
        String hora = scan.next();
        System.out.println("** Ingrese el clima **");
        String clima = scan.next();
        String minutos = "";
        Partido partido = new Partido(estadio, dia, hora, clima, minutos);  // Instaciamos la clase "Partido" con los datos ingresados.

        Partido = partido;  // Le asignamos el partido ingresado a la instancia de partido global.
    }
    public static void listarEncuentro() {
        System.out.println("** Partido: " + equipo1().get_nombre() + " vs " + equipo2().get_nombre() + " **");
        System.out.println("** Estadio **");
        System.out.println(partido().get_estadio()); // Mostramos el nombre del estadio.
        System.out.println("─────────────────────────────────");
        System.out.println(equipo1().get_nombre());
        System.out.println("** Titulares **"); // Mostramos todos los jugadores titulares del equipo 1.
        for(Jugador unJugador : listaJugadoresTitularesEq1){
            System.out.println(unJugador.toString());
        }
        System.out.println("** Suplentes **"); // Mostramos todos los jugadores suplentes del equipo 1.
        for(Jugador unJugador : listaJugadoresSuplentesEq1){
            System.out.println(unJugador.toString());
        }
        System.out.println("** Técnico **"); // Mostramos el director técnico del equipo 1.
        System.out.println(equipo1().get_tecnico());
        System.out.println("─────────────────────────────────");
        System.out.println(equipo2().get_nombre());
        System.out.println("** Titulares **"); // Mostramos todos los jugadores titulares del equipo 2.
        for(Jugador unJugador : listaJugadoresTitularesEq2){
            System.out.println(unJugador.toString());
        }
        System.out.println("** Suplentes **"); // Mostramos todos los jugadores suplentes del equipo 2.
        for(Jugador unJugador : listaJugadoresSuplentesEq2){
            System.out.println(unJugador.toString());
        }
        System.out.println("** Técnico **"); // Mostramos el director técnico del equipo 2.
        System.out.println(equipo2().get_tecnico());
    }
    public static void marcarGol() {
        Scanner scan = new Scanner(System.in);
        Jugador jugadoraso = new Jugador();
        boolean yaGol = false;
        boolean jugadorExistente = false;
        System.out.println("** Que EQUIPO metió gol **?"); // Solicitamos que ingrese el número del equipo, que metió gol
        System.out.println("1- " + equipo1().get_nombre());
        System.out.println("2- " + equipo2().get_nombre());
        byte equip = scan.nextByte();
        System.out.println("** Que JUGADOR metió gol? (Número de la camiseta) **"); // Pedimos el dorsal del jugador que metió el gol
        byte jugadorNum = scan.nextByte();
       switch (equip){
           case 1:
               for (Jugador unJugador: listaJugadoresTitularesEq1) { // Buscamos si el jugador ingresado existe en la lista de jugadores.
                   if(unJugador.get_numero() == jugadorNum){
                       jugadorExistente = true;
                       jugadoraso = unJugador; // Le asignamos los valores del jugador encontrado a una instancia de jugador.
                       jugadoraso.set_gol(jugadoraso.get_gol() + 1); // Le sumamos el gol al jugador.
                   }
               }
               if(jugadorExistente == true){
                   if(listaJugadoresGoleadoresEq1.size() == 0){ // Chequeamos que la lista de goleadores este vacía.
                       listaJugadoresGoleadoresEq1.add(jugadoraso); // Añadimos el jugador a la lista de goleadores.
                   }
                   else{ // Si la lista no esta vacía.
                       for (Jugador Goleador : listaJugadoresGoleadoresEq1) {
                           if(Goleador.get_numero() == jugadoraso.get_numero()){ // Buscamos si el jugador ingresado ya había metido un gol
                               yaGol = true;
                           }
                       }
                       if(yaGol == true){ // Si el jugador ya tenía goles a su favor, remplazamos los goles.
                           for (Jugador Goleador : listaJugadoresGoleadoresEq1){
                               if(Goleador.get_numero() == jugadoraso.get_numero()){
                                   Goleador.set_gol(jugadoraso.get_gol());
                               }
                           }
                       }
                       else{ // De lo contrario, lo agregamos a la lista de goleadores.
                           listaJugadoresGoleadoresEq1.add(jugadoraso);
                       }
                   }
               }
               else{ // Si el jugador no es encontrado, mostraremos un mensaje de error.
                   System.out.println("No se a encontrado el jugador");
               }
               break;
           case 2:
               for (Jugador unJugador: listaJugadoresTitularesEq2) { // Buscamos si el jugador ingresado existe en la lista de jugadores.
                   if(unJugador.get_numero() == jugadorNum){
                       jugadorExistente = true;
                       jugadoraso = unJugador; // Le asignamos los valores del jugador encontrado a una instancia de jugador.
                       jugadoraso.set_gol(jugadoraso.get_gol() + 1); // Le sumamos el gol al jugador.
                   }
               }
               if(jugadorExistente == true){
                   if(listaJugadoresGoleadoresEq2.size() == 0){ // Chequeamos que la lista de goleadores este vacía.
                       listaJugadoresGoleadoresEq2.add(jugadoraso); // Añadimos el jugador a la lista de goleadores.
                   }
                   else{ // Si la lista no esta vacía.
                       for (Jugador Goleador : listaJugadoresGoleadoresEq2) {
                           if(Goleador.get_numero() == jugadoraso.get_numero()){ // Buscamos si el jugador ingresado ya había metido un gol
                               yaGol = true;
                           }
                       }
                       if(yaGol == true){ // Si el jugador ya tenía goles a su favor, remplazamos los goles.
                           for (Jugador Goleador : listaJugadoresGoleadoresEq2){
                               if(Goleador.get_numero() == jugadoraso.get_numero()){
                                   Goleador.set_gol(jugadoraso.get_gol());
                               }
                           }
                       }
                       else{ // De lo contrario, lo agregamos a la lista de goleadores.
                           listaJugadoresGoleadoresEq2.add(jugadoraso);
                       }
                   }
               }
               else{ // Si el jugador no es encontrado, mostraremos un mensaje de error.
                   System.out.println("No se a encontrado el jugador");
               }
               break;
           default:
               System.out.println("Equipo invalido");
               break;
       }
    }
    public  static void finalizarPartido(){
        Scanner scan = new Scanner(System.in);
        // Solicitamos que ingrese los minutos, jugados del partido.
        System.out.println("Ingrese los minutos que duro el partido (Formato del ingreso de minutos 00:00)");
        String minutos = scan.next();
        Partido.set_minutosJugados(minutos); // Cargamos los minutos jugados del partido.
        byte fin = - 1;
        while(fin != 0) {
            System.out.println("┌──────────────────────────┐");
            System.out.println("│ ** Partido Finalizado ** │");
            System.out.println("│    1- Listar Jugadores   │");
            System.out.println("│    2- Listar Goleadores  │");
            System.out.println("│    3-     Salir          │");
            System.out.println("└──────────────────────────┘");

            byte opcion = scan.nextByte();
            switch (opcion) {
                case 1:
                    System.out.println(equipo1().get_nombre());
                    System.out.println("** Titulares **");
                    for(Jugador unJugador : listaJugadoresTitularesEq1){ // Mostramos todos los jugadores titulares del equipo 1.
                        System.out.println(unJugador.toString());
                    }
                    System.out.println("** Suplentes **");
                    for(Jugador unJugador : listaJugadoresSuplentesEq1){ // Mostramos todos los jugadores suplentes del equipo 1.
                        System.out.println(unJugador.toString());
                    }
                    System.out.println("** Jugadores Expulsados **");
                    for (Jugador unJugador : listaJugadoresExpulsadosEquipo1) // Mostramos todos los jugadores expulsados del equipo 1.
                    {
                        System.out.println(unJugador.toString());
                    }
                    System.out.println("--------------------");
                    System.out.println(equipo2().get_nombre());
                    System.out.println("** Titulares **");
                    for(Jugador unJugador : listaJugadoresTitularesEq2){ // Mostramos todos los jugadores titulares del equipo 2.
                        System.out.println(unJugador.toString());
                    }
                    System.out.println("** Suplentes **");
                    for(Jugador unJugador : listaJugadoresSuplentesEq2){ // Mostramos todos los jugadores suplentes del equipo 2.
                        System.out.println(unJugador.toString());
                    }
                    System.out.println("** Jugadores Expulsados **");
                    for (Jugador unJugador : listaJugadoresExpulsadosEquipo2) // Mostramos todos los jugadores expulsados del equipo 2.
                    {
                        System.out.println(unJugador.toString());
                    }
                    break;
                case 2:
                    System.out.println("** Goleadores: " + equipo1().get_nombre() + " **");
                    for(Jugador unJugador : listaJugadoresGoleadoresEq1){ // Mostramos todos los jugadores que anotaron gol del equipo 1.
                        System.out.println(unJugador.Goleadores());
                    }
                    System.out.println("** Goleadores: " + equipo2().get_nombre() + " **");
                    for(Jugador unJugador : listaJugadoresGoleadoresEq2){ // Mostramos todos los jugadores que anotaron gol del equipo 2.
                        System.out.println(unJugador.Goleadores());
                    }
                    break;
                case 3:
                    fin = 0;
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }

    }
}
