package inputs;

import java.util.Scanner;
import objects.Fecha;

/**
 *
 * @author casa
 */
public class EntradaTextos {

    /**
     * Request user for a String value, then checks if was data entered
     *
     * @param message Input the message for the request
     * @return return checked value
     */
    public static String inputString(String message) {
        Scanner entrada = new Scanner(System.in);
        String name;
        System.out.print(message);
        name = entrada.nextLine();
        while (name.equalsIgnoreCase("")) {
            System.out.println("No data entered");
            System.out.print(message);
            name = entrada.nextLine();
        }
        return name;
    }
    
    /**
     * Request for a String with a limit size in the string
     * @param message message for the request
     * @param lengthLimit max limit of the string
     * @return 
     */
    public static String inputStringLength(String message, int lengthLimit) {
        Scanner entrada = new Scanner(System.in);
        String name;
        System.out.print(message);
        name = entrada.nextLine();
        while (name.equalsIgnoreCase("") || name.length()>lengthLimit) {
            System.out.println("No data entered");
            System.out.print(message);
            name = entrada.nextLine();
        }
        return name;
    }

    /**
     * Request for a 1 character string
     * @param message
     * @return 
     */
    public static String inputStringChar(String message) {
        Scanner input = new Scanner(System.in);
        String character;
        String[] check;
        System.out.print(message);
        character = input.nextLine();
        check = character.split("");
        while (check.length != 1) {
            System.out.println("It's not a character");
            System.out.print(message);
            character = input.nextLine();
            check = character.split("");
        }
        return character;
    }

    /**
     * Pide al usuario una fecha pasada al dia actual
     *
     * @param message Introduce un mensaje para pedir la fecha
     * @return Retorna un valor Fecha comprobado
     */
    public static Fecha inputFechaPasada(String message) {
        Fecha inputFecha;
        Fecha fechaHoy = new Fecha();

        fechaHoy.setToday();
        inputFecha = inputFecha(message);
        while (inputFecha.compareFechaCon(fechaHoy) == 1) {
            System.out.println("No es una fecha pasada");
            inputFecha = inputFecha(message);
        }
        return inputFecha;
    }

    /**
     * Pide una fecha y la comprueba
     *
     * @param message Introduce el mensaje que muestra al usuario
     * @return
     */
    public static Fecha inputFecha(String message) {
        Fecha inputFecha = new Fecha();
        Scanner input = new Scanner(System.in);
        String fechaProvisional;
        System.out.print(message);
        fechaProvisional = input.nextLine();
        while (!inputFecha.setFecha(fechaProvisional)) {
            System.out.println("Error: Se introdujo mal la fecha (formato: dd/mm/aaaa)");
            System.out.print(message);
            fechaProvisional = input.nextLine();
        }
        return inputFecha;
    }

}
