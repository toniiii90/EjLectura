package OtroEjercicio;

public class Jugador {
    protected String ranking;
    protected String nombre;

    public Jugador(String ranking, String nombre) {
        this.ranking = ranking;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return ranking + " --> " + nombre;
    }
}
