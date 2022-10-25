import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opc = menu();

        switch (opc) {

            case 1:
                String ruta=sc.nextLine();
                String nombreCarpeta=sc.nextLine();
                ProcessBuilder pb=new ProcessBuilder("cmd", "/C", "md", ruta+nombreCarpeta);


                try {
                    Process p = pb.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


                break;

            case 2:
                break;


            case 3:
                break;

            default:
                System.out.println("La opción introducida no es correcta");
        }



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