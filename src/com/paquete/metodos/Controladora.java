package com.paquete.metodos;

import com.paquete.Principal;

import java.util.*;

import com.paquete.clases.*;

public class Controladora {

    private static Partido Partido = new Partido();
    private static Equipo Equipo1 = new Equipo();
    static List<Jugador> listaJugadoresTitularesEq1 = new ArrayList();
    static List<Jugador> listaJugadoresSuplentesEq1 = new ArrayList();
    private static Equipo Equipo2 = new Equipo();
    static List<Jugador> listaJugadoresTitularesEq2 = new ArrayList();
    static List<Jugador> listaJugadoresSuplentesEq2 = new ArrayList();
    static List<Arbitro> listaArbitral = new ArrayList();
    private static List<Jugador> listaJugadoresExpulsados = new ArrayList();

    public static Partido partido() {
        return Partido;
    }

    public static Equipo equipo1() {
        return Equipo1;
    }

    public static Equipo equipo2() {
        return Equipo2;
    }

    public static List<Jugador> listarJugadoresExpulsados() {
        return listaJugadoresExpulsados;
    }

    public static List<Arbitro> agregarArbitros() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los arbitros");
        for (int i = 0; i < 2; i++) {
            System.out.println("Nombre");
            String nom = scan.next();
            System.out.println("Apellido");
            String ape = scan.next();
            System.out.println("Puesto");
            String puesto = scan.next();
            Arbitro arb = new Arbitro(nom, ape, puesto);
            listaArbitral.add(arb);

        }
        return listaArbitral;
    }

    public static boolean ingresarEquipo1() {
        String nombre = Principal.equipo1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los Datos de " + nombre);
        System.out.println("");

        System.out.println("Ingrese los datos del Director Técnico");

        System.out.println("Nombre del director técnico");
        String nombreTecnico = scan.next();

        System.out.println("Apellido del director técnico");
        String apellidoTecnico = scan.next();

        System.out.println("Edad del director técnico");
        byte edadTecnico = scan.nextByte();

        DT TecnicoEq1 = new DT(nombreTecnico, apellidoTecnico, edadTecnico);

        System.out.println("Ingrese los Jugadores Titulares");
        System.out.println("");
        for (int i = 0; i < 2; i++) {
            System.out.println("Ingrese el nombre del jugador");
            String nombreTitular = scan.next();

            System.out.println("Ingrese el apellido del jugador");
            String apellidoTitular = scan.next();

            System.out.println("Ingrese la edad del jugador");
            byte edadTitular = scan.nextByte();

            System.out.println("Ingrese el puesto del jugador");
            String puestoTitular = scan.next();

            System.out.println("Ingrese el dorsal del jugador");
            byte dorsalTitular = scan.nextByte();

            if (listaJugadoresTitularesEq1.size() == 0) {
                Jugador jugador = new Jugador(nombreTitular, apellidoTitular, edadTitular, puestoTitular, dorsalTitular);
                listaJugadoresTitularesEq1.add(jugador);
            } else {
                boolean repetido = false;
                for (Jugador unJugador : listaJugadoresTitularesEq1) {
                    if (unJugador.get_numero() == dorsalTitular) {
                        System.out.println("Este dorsal ya esta en uso!");
                        i--;
                    } else {
                        repetido = true;
                    }
                }
                if (repetido == true) {
                    Jugador jugador = new Jugador(nombreTitular, apellidoTitular, edadTitular, puestoTitular, dorsalTitular);
                    listaJugadoresTitularesEq1.add(jugador);
                }
            }
        }
        System.out.println("Ingrese los datos de los jugadores suplentes");
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

            boolean repetidoT = false;
            boolean repetidoS = false;
            for (Jugador unJugador : listaJugadoresTitularesEq1) {
                if (unJugador.get_numero() == dorsalSuplente) {
                    repetidoT = true;
                }
            }
            for (Jugador unJugador : listaJugadoresSuplentesEq1) {
                if (unJugador.get_numero() == dorsalSuplente) {
                    repetidoS = true;
                }
            }
            if (repetidoT == true || repetidoS == true) {
                System.out.println("Este dorsal ya esta en uso!");
                i--;
            } else {
                Jugador jugador = new Jugador(nombreSuplente, apellidoSuplente, edadSuplente, puestoSuplente, dorsalSuplente);
                listaJugadoresSuplentesEq1.add(jugador);
            }
        }
        Equipo team = new Equipo((byte) 1, nombre, listaJugadoresTitularesEq1, listaJugadoresSuplentesEq1, TecnicoEq1);
        Equipo1 = team;

        if (TecnicoEq1 != null && listaJugadoresTitularesEq1.size() == 2 && listaJugadoresSuplentesEq1.size() == 1) {
            return true;
        }
        return false;
    }

    public static boolean ingresarEquipo2() {
        String nombre = Principal.equipo2;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los Datos de " + nombre);
        System.out.println("");

        System.out.println("Ingrese los datos del Director Técnico");

        System.out.println("Nombre del director técnico");
        String nombreTecnico = scan.next();

        System.out.println("Apellido del director técnico");
        String apellidoTecnico = scan.next();

        System.out.println("Edad del director técnico");
        byte edadTecnico = scan.nextByte();

        DT TecnicoEq2 = new DT(nombreTecnico, apellidoTecnico, edadTecnico);

        System.out.println("Ingrese los Jugadores Titulares");
        System.out.println("");
        for (int i = 0; i < 2; i++) {
            System.out.println("Ingrese el nombre del jugador");
            String nombreTitular = scan.next();

            System.out.println("Ingrese el apellido del jugador");
            String apellidoTitular = scan.next();

            System.out.println("Ingrese la edad del jugador");
            byte edadTitular = scan.nextByte();

            System.out.println("Ingrese el puesto del jugador");
            String puestoTitular = scan.next();

            System.out.println("Ingrese el dorsal del jugador");
            byte dorsalTitular = scan.nextByte();

            if (listaJugadoresTitularesEq2.size() == 0) {
                Jugador jugador = new Jugador(nombreTitular, apellidoTitular, edadTitular, puestoTitular, dorsalTitular);
                listaJugadoresTitularesEq2.add(jugador);
            } else {
                boolean repetido = false;
                for (Jugador unJugador : listaJugadoresTitularesEq2) {
                    if (unJugador.get_numero() == dorsalTitular) {
                        System.out.println("Este dorsal ya esta en uso!");
                        i--;
                    } else {
                        repetido = true;
                    }
                }
                if (repetido == true) {
                    Jugador jugador = new Jugador(nombreTitular, apellidoTitular, edadTitular, puestoTitular, dorsalTitular);
                    listaJugadoresTitularesEq2.add(jugador);
                }
            }
        }
        System.out.println("Ingrese los datos de los jugadores suplentes");
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

            boolean repetidoT = false;
            boolean repetidoS = false;
            for (Jugador unJugador : listaJugadoresTitularesEq2) {
                if (unJugador.get_numero() == dorsalSuplente) {
                    repetidoT = true;
                }
            }
            for (Jugador unJugador : listaJugadoresSuplentesEq2) {
                if (unJugador.get_numero() == dorsalSuplente) {
                    repetidoS = true;
                }
            }
            if (repetidoT == true || repetidoS == true) {
                System.out.println("Este dorsal ya esta en uso!");
                i--;
            } else {
                Jugador jugador = new Jugador(nombreSuplente, apellidoSuplente, edadSuplente, puestoSuplente, dorsalSuplente);
                listaJugadoresSuplentesEq2.add(jugador);
            }
        }
        Equipo team = new Equipo((byte) 1, nombre, listaJugadoresTitularesEq2, listaJugadoresSuplentesEq2, TecnicoEq2);
        Equipo2 = team;

        if (TecnicoEq2 != null && listaJugadoresTitularesEq2.size() == 2 && listaJugadoresSuplentesEq2.size() == 1) {
            return true;
        }
        return false;
    }

    public static boolean expulsarJugador() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el numero del equipo, en el que se encuentra el jugador");
        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│1. " + equipo1().get_nombre() + "│");
        System.out.println("│2. " + equipo1().get_nombre() + "│");
        System.out.println("└─────────────────────────────────┘");
        byte opcion = scan.nextByte();

        System.out.println("Ingrese el dorsal del jugador");
        byte dorsal = scan.nextByte();

        if (opcion == 1) {
            for (Jugador jugador : listaJugadoresTitularesEq1) {
                if (jugador.get_numero() == dorsal) {
                    Equipo1.get_listaTitulares().remove(jugador);
                    listaJugadoresExpulsados.add(jugador);
                    return true;
                } else {
                    for (Jugador unJugador : listaJugadoresSuplentesEq1) {
                        if (unJugador.get_numero() == dorsal) {
                            Equipo1.get_listaSuplentes().remove(jugador);
                            listaJugadoresExpulsados.add(jugador);
                            return true;
                        }
                    }
                }
            }
            return false;
        } else if (opcion == 2) {
            for (Jugador jugador : listaJugadoresTitularesEq2) {
                if (jugador.get_numero() == dorsal) {
                    Equipo2.get_listaTitulares().remove(jugador);
                    listaJugadoresExpulsados.add(jugador);
                    return true;
                } else {
                    for (Jugador unJugador : listaJugadoresSuplentesEq2) {
                        if (unJugador.get_numero() == dorsal) {
                            Equipo2.get_listaSuplentes().remove(jugador);
                            listaJugadoresExpulsados.add(jugador);
                            return true;
                        }
                    }
                }
            }
            return false;
        } else {
            System.out.println("Ese equipo no existe");
            return false;
        }
    }

    public static void agregarPartido() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los datos del partido");
        System.out.println("");
        System.out.println("Ingrese el estadio donde se disputa el encuentro");
        String estadio = scan.next();
        System.out.println("Ingrese el dia del encuentro");
        String dia = scan.next();
        System.out.println("Ingrese la hora del encuentro");
        String hora = scan.next();
        System.out.println("Ingrese el clima");
        String clima = scan.next();
        String minutos = "";
        Partido partido = new Partido(estadio, dia, hora, clima, minutos);
        Partido = partido;
    }

    public static void listarEncuentro() {
        System.out.println(equipo1().get_nombre());
        System.out.println("Titulares");
        System.out.println(listaJugadoresTitularesEq1);
        System.out.println("Suplentes");
        System.out.println(listaJugadoresSuplentesEq1);
        System.out.println("Técnico");
        System.out.println(equipo1().get_tecnico());
        System.out.println("─────────────────────────────────");
        System.out.println(equipo2().get_nombre());
        System.out.println("Titulares");
        System.out.println(listaJugadoresTitularesEq2);
        System.out.println("Suplentes");
        System.out.println(listaJugadoresSuplentesEq2);
        System.out.println("Técnico");
        System.out.println(equipo2().get_tecnico());
    }


}
