import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.Scanner;

public class Main {


    static Connection connection = null;
    //static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ConexionJDBC();

        eliminarRegistro();

    }

    public static void ConexionJDBC(){

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                    "","root","");
            System.out.println("Conectado a la base de datos");



        }catch(SQLException | ClassNotFoundException sqlE ){
            System.out.println("No se pudo conectar a la base de datos");
            sqlE.printStackTrace();
        }
    }

    public static void eliminarRegistro(){

        String sentenciaSql = "DELETE FROM equipos WHERE id = ?";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sentenciaSql);
            System.out.println("Que id quieres borrar");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            ps.setInt(1, num);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void insertarRegistro(){

        String sentenciaSql = "INSERT INTO equipos(nombre, jugyobs) VALUES (?, ?)";
        PreparedStatement ps = null;
        try {

            PreparedStatement misentencia = connection.prepareStatement("SELECT * FROM equipos WHERE nombre = ?");
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Introduce nombre del equipo");
            String nombre = sc1.nextLine();


            misentencia.setString(1, nombre);
            ResultSet rs2 = misentencia.executeQuery();
            if (rs2.next()) {
                System.out.println("Este equipo ya existe");
            } else {
                ps = connection.prepareStatement(sentenciaSql);


                Scanner sc2 = new Scanner(System.in);



                System.out.println("Introduce observaciones del equipo y jugadores");
                String jugyobs = sc2.nextLine();


                ps.setString(1, nombre);
                ps.setString(2, jugyobs);
                ps.executeUpdate();

            }

        }catch(SQLException sqle){
            sqle.printStackTrace();
        }

    }

    public static void modificarRegistro(){
        PreparedStatement ps = null;
        String sentenciaSql = "UPDATE equipos SET nombre = ?, jugyobs = ? WHERE id = ?";


        try {

            PreparedStatement misentencia = connection.prepareStatement("SELECT * FROM equipos WHERE id = ?");


            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Que ID quieres modificar");
            int id = sc.nextInt();
            misentencia.setInt(1, id);
            ResultSet rs = misentencia.executeQuery();

            if (rs.next()){

                System.out.println("Introduce el nuevo nombre del jugador");
                String jugador = sc2.nextLine();
                System.out.println("Introduce las observaciones del jugador");
                String jugyobs = sc.next();

                ps = connection.prepareStatement(sentenciaSql);
                ps.setString(1, jugador);
                ps.setString(2, jugyobs);
                ps.setInt(3, id);
                ps.executeUpdate();

            } else System.out.println("EL ID NO HA SIDO ENCONTRADO");


        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }


    }


}
