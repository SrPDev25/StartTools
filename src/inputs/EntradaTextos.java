
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
    
    public static Fecha inputFecha(String message){
        Fecha inputFecha=new Fecha();
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
