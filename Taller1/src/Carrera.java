// Definimos la clase Carreras para gestionar el nombre uniendolo con el numero de semestres que asignemos
public class Carrera {
    private String nombre;
    private int semestres;

    public Carrera(String nombre, int semestres) {
        this.nombre = nombre;
        this.semestres = semestres;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSemestres() {
        return semestres;
    }
}