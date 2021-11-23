import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class PartidoH {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        HibernateUtil.inicia();

        insertar();
    }

    public static void insertar(){

        System.out.println("Introduce nombre del Equipo");
        String equipo = sc.nextLine();
        System.out.println("Introduce observaciones y jugadores");
        String jugyobs = sc.nextLine();
        Session s=HibernateUtil.openSession();
        s.beginTransaction();
        Equipo miEquipo=new Equipo(equipo, jugyobs);
        s.save(miEquipo);
        s.getTransaction().commit();
        s.close();
        System.out.println("El id es " + miEquipo.getId());
    }

    public static void modificar(){
        int id;
        String equipo, jugyobs;

        Session s=HibernateUtil.openSession();
        s.beginTransaction();
        Equipo miEquipo= new Equipo();
        System.out.println("Que ID quiere modificar?");
        miEquipo.setId(id = sc.nextInt());
        System.out.println("Introduzca el nuevo nombre del equipo");
        equipo = sc.next();
        miEquipo.setNombre(equipo);
        System.out.println("Introduzca las nuevas observaciones y jugadores");
        jugyobs = sc.next();
        miEquipo.setNombre(jugyobs);
        s.update(miEquipo);
        s.getTransaction().commit();
        s.close();
    }

    public static void eliminar(){
        //Eliminar un registro en la tabla

        Equipo otroEquipo=new Equipo();
        System.out.println("Que ID desea eliminar");
        int id = sc.nextInt();
        //Para borrar solo necesito el id

        if(existeID(id)) {
            Session s = HibernateUtil.openSession();
            s.beginTransaction();
            otroEquipo.setId(id);
            s.delete(otroEquipo);
            s.getTransaction().commit();
            s.close();
        }else System.out.println("No existe");
    }

    public static boolean existeID(int id){
        Session s=HibernateUtil.openSession();
        s=HibernateUtil.openSession();
        s.beginTransaction();
        List<Equipo> lista = (List<Equipo>) s.createQuery("FROM Equipos e WHERE e.id = :id").setParameter("id", id).list();
        s.getTransaction().commit();
        s.close();
        return (lista.size()>0);

    }

}
