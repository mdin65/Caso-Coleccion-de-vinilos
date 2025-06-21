package Ejecucion;

import Modelo.Vinilo;


public class ColeccionVinilos {
    private static final int CAPACIDAD_MAXIMA = 100;
    private Vinilo[] vinilos;
    private int cantidad;

    public ColeccionVinilos() {
        vinilos = new Vinilo[CAPACIDAD_MAXIMA];
        cantidad = 0;
    }

    public boolean agregarVinilo(Vinilo vinilo) {
        if (cantidad < CAPACIDAD_MAXIMA) {
            vinilos[cantidad] = vinilo;
            cantidad++;
            return true;
        }
        return false;
    }

    public boolean buscarArtista(String artista) {
        for (int i = 0; i < cantidad; i++) {
            if (vinilos[i].getArtista().equalsIgnoreCase(artista)) {
                return true;
            }
        }
        return false;
    }

    public int TotalVinilos() {
        return cantidad;
    }

    public int EspaciosDisponibles() {
        return CAPACIDAD_MAXIMA - cantidad;
    }

    public void mostrarColeccion() {
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Fila " + (i+1) + ": " + vinilos[i].toString());
        }
    }

    public void mostrarVinilosDeArtista(String artista) {
        boolean encontrado = false;
        for (int i = 0; i < cantidad; i++) {
            if (vinilos[i].getArtista().equalsIgnoreCase(artista)) {
                System.out.println("Fila " + (i+1) + ": " + vinilos[i].toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron vinilos del artista " + artista);
        }

    }
    public static int CapacidadMaxima() {
        return CAPACIDAD_MAXIMA;
    }
}