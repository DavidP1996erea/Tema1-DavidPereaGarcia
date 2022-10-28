import java.io.IOException;

public class Ejercicio3_ProcesosNOEsperan_Main {
    public static void main(String[] args) {

        /**
         * Igual que el ejercicio anterior
         */
        ProcessBuilder pb1 = new ProcessBuilder("java", "CuentaCaracteres", "a");
        ProcessBuilder pb2 = new ProcessBuilder("java", "CuentaCaracteres", "e");
        ProcessBuilder pb3 = new ProcessBuilder("java", "CuentaCaracteres", "i");
        ProcessBuilder pb4 = new ProcessBuilder("java", "CuentaCaracteres", "o");
        ProcessBuilder pb5 = new ProcessBuilder("java", "CuentaCaracteres", "u");

        pb1.inheritIO();
        pb2.inheritIO();
        pb3.inheritIO();
        pb4.inheritIO();
        pb5.inheritIO();

        try {

            /**
             * Se colocan dos variables que servirán para controlar el tiempo transcurrido entre ellas, haciendo una
             * diferencia entre las dos variables.
             */
            long comienzoProcesos = System.currentTimeMillis();
            Process pa = pb1.start();
            Process pe = pb2.start();
            Process pi = pb3.start();
            Process po=  pb4.start();
            Process pu=  pb5.start();

            long finalProcesos = System.currentTimeMillis();

            /**
             * Se muestra el tiempo final.
             */

            System.out.println((int) (finalProcesos - comienzoProcesos));

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

