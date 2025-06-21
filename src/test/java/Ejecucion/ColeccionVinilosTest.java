package Ejecucion;

import Modelo.Vinilo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColeccionVinilosTest {
    private ColeccionVinilos coleccion;
    private Vinilo vinilo1;
    private Vinilo vinilo2;

    @BeforeEach
    public void setUp() {
        coleccion = new ColeccionVinilos();
        vinilo1 = new Vinilo("Iron Maiden", "The Number of the Beast", "1982");
        vinilo2 = new Vinilo("AC-DC", "Back in Black", "1980");
    }

    @Test
    public void testAgregarVinilo() {
        // Agregar un vinilo cuando hay espacio
        assertTrue(coleccion.agregarVinilo(vinilo1));
        assertEquals(1, coleccion.TotalVinilos());

        // Intentar agregar más allá de la capacidad máxima
        for (int i = 1; i < ColeccionVinilos.CapacidadMaxima(); i++) {
            coleccion.agregarVinilo(new Vinilo("Artista " + i, "Disco " + i, "200" + i));
        }
        assertFalse(coleccion.agregarVinilo(vinilo2));
    }

    @Test
    public void testBuscarArtista() {
        coleccion.agregarVinilo(vinilo1);
        coleccion.agregarVinilo(vinilo2);

        // Artista que existe (case insensitive)
        assertTrue(coleccion.buscarArtista("iron maiden"));
        assertTrue(coleccion.buscarArtista("IRON MAIDEN"));

        // Artista que no existe
        assertFalse(coleccion.buscarArtista("Metallica"));
    }

    @Test
    public void testGetTotalVinilos() {
        assertEquals(0, coleccion.TotalVinilos());
        coleccion.agregarVinilo(vinilo1);
        assertEquals(1, coleccion.TotalVinilos());
        coleccion.agregarVinilo(vinilo2);
        assertEquals(2, coleccion.TotalVinilos());
    }

    @Test
    public void testGetEspaciosDisponibles() {
        int capacidad = ColeccionVinilos.CapacidadMaxima();
        assertEquals(capacidad, coleccion.EspaciosDisponibles());

        coleccion.agregarVinilo(vinilo1);
        assertEquals(capacidad - 1, coleccion.EspaciosDisponibles());

        coleccion.agregarVinilo(vinilo2);
        assertEquals(capacidad - 2, coleccion.EspaciosDisponibles());
    }

    @Test
    public void testMostrarColeccion() {
        // Este test verifica que no hay excepciones al mostrar
        coleccion.agregarVinilo(vinilo1);
        coleccion.agregarVinilo(vinilo2);

        // Simplemente verificamos que no lance excepciones
        assertDoesNotThrow(() -> coleccion.mostrarColeccion());
    }

    @Test
    public void testMostrarVinilosDeArtista() {
        coleccion.agregarVinilo(vinilo1);
        coleccion.agregarVinilo(vinilo2);
        coleccion.agregarVinilo(new Vinilo("Iron Maiden", "Killers", "1981"));

        // Verificar que no lance excepciones para artista existente
        assertDoesNotThrow(() -> coleccion.mostrarVinilosDeArtista("iron maiden"));

        // Verificar que no lance excepciones para artista no existente
        assertDoesNotThrow(() -> coleccion.mostrarVinilosDeArtista("Metallica"));
    }

    @Test
    public void testGetCapacidadMaxima() {
        assertEquals(100, ColeccionVinilos.CapacidadMaxima());
    }
}