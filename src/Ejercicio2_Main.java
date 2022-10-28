import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ejercicio2_Main {
    public static void main(String[] args) {

        /**
         * Se ejecuta en primer lugar un proceso que ejecutará un bloc de notas donde se contará las líneas.
         */
        String[] proceso1={"Notepad.exe", "C:\\ejercicio2\\numLineas.txt"};
        String[] proceso2={"java", "CuentaLineas"};

        ProcessBuilder pb1 = new ProcessBuilder(proceso1);
        ProcessBuilder pb2 = new ProcessBuilder(proceso2);

        /**
         * Se redirecciona la salida para que muestre por pantalla el sout de la clase CuentaLineas
         */
        pb1.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb2.inheritIO();



        try {
            int segundos=0;
            Process p1 = pb1.start();

            /**
             * Aquí se comprueba que si el proceso está vivo, por cada segundo el contador segundos aumenta en 1,
             * y si este contador es mayor o igual que 30 el proceso1 se destruirá y mostrará por pantalla un
             * mensaje. En caso de que sea menor de 30, se ejecutará el proceso2.
             */
            while (p1.isAlive() && segundos<30 ){

                TimeUnit.SECONDS.sleep(1);

                segundos++;
            }

            if(segundos>=30){
                p1.destroy();
                System.err.println("El proceso ha tardado más de 30 segundos");
            }else {
                Process p2 = pb2.start();
            }





        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
