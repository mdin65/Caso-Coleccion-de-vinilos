package Inicio;

import Ejecucion.ColeccionVinilos;
import Modelo.Vinilo;

public class Main {
    public static void main(String[] args) {
        ColeccionVinilos coleccion = new ColeccionVinilos();

        // Agregar vinilos
        coleccion.agregarVinilo(new Vinilo("Iron Maiden", "Iron Maiden", "1980"));
        coleccion.agregarVinilo(new Vinilo("Iron Maiden", "Killers", "1981"));
        coleccion.agregarVinilo(new Vinilo("Iron Maiden", "The number of the beast", "1982"));
        coleccion.agregarVinilo(new Vinilo("AC-DC", "Back in black", "1980"));
        coleccion.agregarVinilo(new Vinilo("AC-DC", "Highway to Hell", "1979"));
        coleccion.agregarVinilo(new Vinilo("AC-DC", "Who made who", "1986"));
        coleccion.agregarVinilo(new Vinilo("Judas Priest", "British steel", "1980"));
        coleccion.agregarVinilo(new Vinilo("Judas Priest", "Painkiller", "1990"));
        coleccion.agregarVinilo(new Vinilo("Judas Priest", "Defenders of the faith", "1984"));
        coleccion.agregarVinilo(new Vinilo("Kiss", "Destroyer", "1976"));

        System.out.println("Espacio máximo colección: " + ColeccionVinilos.CapacidadMaxima());
        System.out.println("\nHay un total de: " + coleccion.TotalVinilos() + " vinilos en la colección.");
        System.out.println("\nHay un total de: " + coleccion.EspaciosDisponibles() + " espacios disponibles en la colección.");

        String artista = "AC-DC";
        System.out.println("\nBuscar artista: " + artista);
        if (coleccion.buscarArtista(artista)) {
            System.out.println("El artista " + artista + " sí está en la colección");
        } else {
            System.out.println("El artista " + artista + " no está en la colección");
        }

        System.out.println("\nMostrando toda la colección:");
        coleccion.mostrarColeccion();
    }
}