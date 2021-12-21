/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Numbers;

import java.util.Scanner;

/**
 *
 * @author casa
 */
public class inputNum {

    public int inputNumInt(String message) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.println(message);
        number = input.nextInt();
        return number;
    }

    public int inputNumIntPos(String message, int min) {
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
    public int inputNumIntPos(String message, int min, int max) {
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
