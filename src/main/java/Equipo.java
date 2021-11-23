public class Equipo {

    String nombre, jugyobs;
    int id;

    public Equipo(){

    }

    public Equipo(String nombre, String jugyobs){

        this.nombre = nombre;
        this.jugyobs = jugyobs;


    }

    public String getJugyobs() {
        return jugyobs;
    }

    public void setJugyobs(String jugyobs) {
        this.jugyobs = jugyobs;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
