import java.io.IOException;

public class Ejercicio3_ProcesosEsperan_Main {


    public static void main(String[] args) {
         int contadorProcesos=0;


        /**
         * Se crean 5 procesos, uno para cada vocal, en los parámetros de entrada se le introduce a cada uno la vocal
         * correspondiente.
         */
        ProcessBuilder pb1 = new ProcessBuilder("java", "CuentaCaracteres", "a");
        ProcessBuilder pb2 = new ProcessBuilder("java", "CuentaCaracteres", "e");
        ProcessBuilder pb3 = new ProcessBuilder("java", "CuentaCaracteres", "i");
        ProcessBuilder pb4 = new ProcessBuilder("java", "CuentaCaracteres", "o");
        ProcessBuilder pb5 = new ProcessBuilder("java", "CuentaCaracteres", "u");

        /**
         * Se redirigen las salidas y entradas de los procesos a esta clase.
         */
        pb1.inheritIO();
        pb2.inheritIO();
        pb3.inheritIO();
        pb4.inheritIO();
        pb5.inheritIO();

        try {


            /**
             * Por cada proceso, se ejecuta el método de abajo y se iguala la variable contador a este, para que en cada
             * proceso se vaya sumando el tiempo total.
             */
           Process pa = pb1.start();
           contadorProcesos = contarTiempo(pa, contadorProcesos);
           Process pe = pb2.start();
            contadorProcesos =  contarTiempo(pe, contadorProcesos);
           Process pi = pb3.start();
            contadorProcesos =  contarTiempo(pi, contadorProcesos);
           Process po=  pb4.start();
            contadorProcesos =  contarTiempo(po, contadorProcesos);
           Process pu=  pb5.start();
            contadorProcesos =   contarTiempo(pu, contadorProcesos);



            System.out.println(contadorProcesos);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    /**
     * Se crea un método que como parámetros tiene un objeto process y un contador. Mietras este proceso esté vivo
     * el contador aumentará en 1. Este método retornará este contador.
     * @param proceso
     * @param contador
     * @return
     */
    public static int contarTiempo(Process proceso, int contador){

        while (proceso.isAlive()){

            try {
                Thread.sleep(1);
                contador++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        return contador;

    }
}
