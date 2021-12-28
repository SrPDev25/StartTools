
package string;

import java.util.Scanner;

/**
 *
 * @author casa
 */
public class CharacthersString {
    
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
}
