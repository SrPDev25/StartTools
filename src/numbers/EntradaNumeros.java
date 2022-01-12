
package numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author casa
 */
public class EntradaNumeros{

    /**
     * Ask for a number
     * ask for the user for a number 
     * @param message choose the message for asking the number
     * @return return the number
     */
    public static int numInt(String message) {
        int numero = 0;
        Scanner entrada = new Scanner(System.in);
        boolean incorrecto = true;
        while (incorrecto) {
            try {
                System.out.print(message);
                numero = entrada.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Should be a number");
                entrada.nextLine();
            }
        }
        return numero;
    }

    /**
     * Ask for a number grater than min
     * @param message choose the message for asking the number
     * @param min choose de minimum number for the asking number
     * @return return the asked number
     */
    public static int numIntGrater(String message, int min) {
        int numero = 0;
        Scanner entrada = new Scanner(System.in);
        boolean incorrecto = true;
        while (incorrecto) {
            try {
                System.out.print(message);
                numero = entrada.nextInt();
                if (numero < min) {
                    System.out.println("it should be grater than "+min);
                } else {
                    incorrecto = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("It should be a number");
                entrada.nextLine();
            }
        }
        return numero;
    }
    
    /**
     * Ask for a number between a min and max
     * @param message choose the message for asking the number
     * @param min choose the minimum number for the asking number
     * @param max choose the maximum number for the asking number
     * @return return the asked number
     */
    public static int numIntBetween(String message, int min, int max) {
        int number = 0;
        Scanner entrada = new Scanner(System.in);
        boolean incorrect = true;
        while (incorrect) {
            try {
                System.out.print(message);
                number = entrada.nextInt();
                if (number < min || number > max) {
                    System.out.println("The numbers must be between " + min + " and " + max);
                } else {
                    incorrect = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("It should be a number");
                entrada.nextLine();
            }
        }
        return number;
    }
}
