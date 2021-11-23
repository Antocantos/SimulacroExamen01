public class Partido {

    String equipo1, equipo2, fecha;
    int res1, res2;


    public Partido(){

    }

    public Partido(String equipo1, int res1, String equipo2, int res2, String fecha){
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.res1 = res1;
        this.res2 = res2;
        this.fecha = fecha;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getRes1() {
        return res1;
    }

    public void setRes1(int res1) {
        this.res1 = res1;
    }

    public int getRes2() {
        return res2;
    }

    public void setRes2(int res2) {
        this.res2 = res2;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "equipo1='" + equipo1 + '\'' +
                ", equipo2='" + equipo2 + '\'' +
                ", fecha='" + fecha + '\'' +
                ", res1=" + res1 +
                ", res2=" + res2 +
                '}';
    }
}
