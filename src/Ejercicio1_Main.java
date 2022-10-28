import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1_Main {
    public static void main(String[] args) {

        String [] comando;


        int opc = menu();

        switch (opc) {

            case 1:

                /**
                 * Se crea el array con el comando y la ruta usando el método de abajo, luego este String
                 * se usa como parámetro para el siguiente método que lo ejecutará.
                 */
                comando= new String[]{"cmd", "/C", "md", devolverRutaYArchivo()};
                ejecutarComando(comando);

                break;

            case 2:

                /**
                 * Lo mismo que el anterior.
                 */
                comando= new String[]{"cmd", "/C", "type", "nul",">", devolverRutaYArchivo()};
                ejecutarComando(comando);

                break;


            case 3:
                /**
                 * Una vez que ejecutamos el comando, se redirige la salida para que se muestre por pantalla.
                 */
                comando= new String[]{"cmd","/C", "dir", devolverRutaYArchivo() };
                ProcessBuilder pb = new ProcessBuilder(comando);

                pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);


                try {
                    Process p = pb.start();

                    System.out.println("Comando ejecutado con éxito");
                } catch (IOException e) {

                    System.err.println("Fallo en la ejecución del comando");
                }
                break;

            default:
                System.out.println("La opción introducida no es correcta");
        }



    }

    /**
     * Se crea un método para ejecutar los comandos, ya que se repite en el ejercicio. Toma como parámetro un array
     * de String que contendrá el comando a ejecutar.
     * @param comando
     */
    public static void ejecutarComando(String[] comando){

        ProcessBuilder pb = new ProcessBuilder(comando);

        try {
            Process p = pb.start();

            System.out.println("Comando ejecutado con éxito");
        } catch (IOException e) {

            System.err.println("Fallo en la ejecución del comando");
        }

    }

    /**
     * Este método retorna un String con la ruta y el nombre del archivo/carpeta que necesitamos para cada uno de
     * los ejercicios. Se le pedirá al usuario dos entrys y se retornará juntas.
     * @return
     */
    public static String devolverRutaYArchivo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la ruta");
        String ruta=sc.nextLine();
        System.out.println("Introduzca el nombre de la carpeta o archivo");
        String  nombre=sc.nextLine();


        return ruta+nombre;

    }



    public static int menu() {
        // En opc guardaremos la opciÃ³n seleccionada por el usuario
        int opc;
        Scanner sc = new Scanner(System.in);

        // Imprimimos el menÃº con las diversas opciones
        System.out.println("Elija cuál comando desea ejecutar:");
        System.out.println("1. Crear carpeta");
        System.out.println("2. Crear fichero");
        System.out.println("3. Mostrar contenido del directorio");

        // Leemos la opciÃ³n de teclado
        opc = sc.nextInt();


        return opc;
    }
}