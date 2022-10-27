package fp.dam.pmdm.actividad2;

public class Pais {

    String nombre;
    String capital;
    String continente;

    public Pais(String nombre, String capital, String continente) {
        this.nombre = nombre;
        this.capital = capital;
        this.continente = continente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCapital() {
        return capital;
    }

    public String getContinente() {
        return continente;
    }
}
