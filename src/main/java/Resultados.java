import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Resultados {

    public static void main(String[] args) throws JAXBException {
        escribirXML();
    }

    public static void escribirResultados(){
        Scanner scanner = new Scanner(System.in);
        FileWriter writer = null;
        PrintWriter pw = null;


        try{

            writer = new FileWriter("src/resultados.csv", true);
            pw = new PrintWriter(writer);

            System.out.println("Introduce resultados: Equpo1;puntosConseguidos1; Equipo2;puntosConseguidos2;fecha");
            String escribir = scanner.nextLine();

            pw.write(escribir + "\n");
            System.out.println("Datos introducidos");
            writer.close();



        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void leerCSV(){

        FileReader file =  null;
        BufferedReader br = null;

        try{

         file = new FileReader("src/resultados.csv");
         br = new BufferedReader(file);

         String linea = br.readLine();

               while(linea!=null){

                   String[] datos = linea.split(";");
                   System.out.println(Arrays.toString(datos));
                   linea = br.readLine();
               }

               br.close();
               file.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void escribirXML() throws JAXBException {
        Partido partido = new Partido("Patato", 12, "Petata", 23, "24-5-2000");
        Partido partido2 = new Partido("Patato", 12, "Petata", 23, "24-5-2000");

        Partidos partidos = new Partidos();

        partidos.getPartidos().add(partido);
        partidos.getPartidos().add(partido2);

        JAXBContext jaxbContext = JAXBContext.newInstance(Partidos.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(partidos, System.out);
        jaxbMarshaller.marshal(partidos, new File("equipos.xml"));
    }


}
