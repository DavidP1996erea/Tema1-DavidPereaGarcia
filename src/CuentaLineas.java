import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CuentaLineas {
    public static void main(String[] args) {


        BufferedReader br = null;
        int numeroLineas=0;

        try {


            /**
             * Se lee el fichero de numLineas.txt, con el bucle se comprueba que exista otro línea que leer,
             * y mientras exista el contador de lineas aumentará en 1.
             */
            br = new BufferedReader(new FileReader("C:\\ejercicio2\\numLineas.txt"));
            Scanner sc = new Scanner(br);
            String palabras="";
            while (sc.hasNext()){
                palabras=sc.next();

                numeroLineas++;

            }

            /**
             * Aquí se mostrará por pantalla el contador para poder redireccionar la salida en la otra clase.
             */

            System.out.println(numeroLineas);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);


        }finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
