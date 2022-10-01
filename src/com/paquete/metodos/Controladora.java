package com.paquete.metodos;
import com.paquete.Principal;
import java.util.*;
import com.paquete.clases.*;
import java.util.ArrayList;

public class Controladora {

    public static List<Arbitro> agregarArbitros()
    {
        Scanner scan = new Scanner(System.in);
        List<Arbitro> arbitros = new ArrayList();
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
            arbitros.add(arb);

        }
        return arbitros;
    }

    public static List<Jugador> agregarJugadoresTitulares(String equipo)
    {
        Scanner scan = new Scanner(System.in);
        List<Jugador> lista = new ArrayList();
        System.out.println();
        System.out.println("Ingrese los jugadores titulares de " + equipo);
        for(int i = 0; i < 2; i++)
        {
            System.out.println("Ingrese el nombre del jugador");
            String nombre = scan.next();
            System.out.println("Ingrese el apellido del jugador");
            String apellido = scan.next();
            System.out.println("Ingrese la edad del jugador");
            byte edad = scan.nextByte();
            System.out.println("Ingrese el puesto del jugador");
            String puesto = scan.next();
            System.out.println("Ingrese el dorsal del jugador");
            byte dorsal = scan.nextByte();
            for(Jugador unJugador : lista)
            {
                if (unJugador.get_numero() == dorsal)
                {
                    System.out.println("Este dorsal ya esta en uso!");
                    i--;
                }
                else
                {
                    Jugador jugador = new Jugador(nombre,apellido,edad,puesto,dorsal);
                    lista.add(jugador);
                }
            }
        }
        return lista;
    }

    public static List<Jugador> agregarJugadoresSuplentes(String equipo)
    {
        Scanner scan = new Scanner(System.in);
        List<Jugador> lista = new ArrayList();
        System.out.println("Ingrese los jugadores suplentes de " + equipo);
        for(int i = 0; i < 2; i++)
        {
            System.out.println("Ingrese el nombre del jugador");
            String nombre = scan.next();
            System.out.println("Ingrese el apellido del jugador");
            String apellido = scan.next();
            System.out.println("Ingrese la edad del jugador");
            byte edad = scan.nextByte();
            System.out.println("Ingrese el puesto del jugador");
            String puesto = scan.next();
            System.out.println("Ingrese el dorsal del jugador");
            byte dorsal = scan.nextByte();
            for(Jugador unJugador : lista)
            {
                if (unJugador.get_numero() == dorsal)
                {
                    System.out.println("Este dorsal ya esta en uso!");
                    i--;
                }
                else
                {
                    Jugador jugador = new Jugador(nombre,apellido,edad,puesto,dorsal);
                    lista.add(jugador);
                }
            }
        }
        return lista;
    }

    public static DT agregarDirectorTecnico(String equipo)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los datos del director técnico de " + equipo);
        System.out.println("Ingrese el nombre del director técnico");
        String nombre = scan.next();
        System.out.println("Ingrese el apellido del director técnico");
        String apellido = scan.next();
        System.out.println("Ingrese la edad del director técnico");
        byte edad = scan.nextByte();
        DT DT = new DT(nombre,apellido,edad);
        return DT;
    }
}
