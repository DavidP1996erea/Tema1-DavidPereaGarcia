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
            br = new BufferedReader(new FileReader("C:\\ejercicio2\\numLineas.txt"));
            Scanner sc = new Scanner(br);
            String palabras="";
            while (sc.hasNext()){
                palabras=sc.next();

                numeroLineas++;

            }


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
