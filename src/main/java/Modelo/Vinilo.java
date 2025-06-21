package Modelo;

public class Vinilo {
    private String artista;
    private String disco;
    private String año;

    public Vinilo(String artista, String disco, String año) {
        this.artista = artista;
        this.disco = disco;
        this.año = año;
    }

    // Getters
    public String getArtista() {
        return artista;
    }

    public String getDisco() {
        return disco;
    }

    public String getAño() {
        return año;
    }

    @Override
    public String toString() {
        return artista + " - " + disco + " - " + año;
    }
}