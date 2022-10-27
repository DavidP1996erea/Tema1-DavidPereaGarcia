import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ejercicio2_Main {
    public static void main(String[] args) {


        String[] proceso1={"Notepad.exe", "C:\\ejercicio2\\numLineas.txt"};
        String[] proceso2={"java", "CuentaLineas"};

        ProcessBuilder pb1 = new ProcessBuilder(proceso1);
        ProcessBuilder pb2 = new ProcessBuilder(proceso2);

        pb1.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb2.inheritIO();



        try {
            int segundos=0;
            Process p1 = pb1.start();

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
