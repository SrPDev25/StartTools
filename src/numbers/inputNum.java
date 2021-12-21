/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package numbers;

import java.util.Scanner;

/**
 *
 * @author casa
 */
public class inputNum {

    /**
     * Ask for a number
     * ask for the user for a number 
     * @param message choose the message for asking the number
     * @return return the number
     */
    public int inputNumInt(String message) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.println(message);
        number = input.nextInt();
        return number;
    }

    /**
     * Ask for a number grater than min
     * @param message choose the message for asking the number
     * @param min choose de minimum number for the asking number
     * @return return the asked number
     */
    public int inputNumIntGrater(String message, int min) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.println(message);
        number = input.nextInt();
        while (number < min) {
            System.out.println("The numbers must be greater than " + min );
            System.out.println(message);
            number = input.nextInt();

        }
        return number;
    }
    
    /**
     * Ask for a number between a min and max
     * @param message choose the message for asking the number
     * @param min choose the minimum number for the asking number
     * @param max choose the maximum number for the asking number
     * @return return the asked number
     */
    public int inputNumIntBetween(String message, int min, int max) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.println(message);
        number = input.nextInt();
        while (number > max || number < min) {
            System.out.println("The numbers must be between " + min + " and " + max);
            System.out.println(message);
            number = input.nextInt();

        }
        return number;
    }
}
