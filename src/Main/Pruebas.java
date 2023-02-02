package Main;

import coding.EncriptTwo;
import java.lang.Math;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DAM
 */
public class Pruebas {

    public static void main(String[] args) {
        
        
        System.out.println(EncriptTwo.randomizeString(25));
        
        
//        String hola = "hola paco";
//        String ascii = " !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
//        String asciiToRandom=ascii;
//        String random1 ="";
//        String random2 = "";
//        char asdf = ' ';
//        // !"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~
//        System.out.println(ascii);
//        
//        int randomNumber = 3;
//        int seed = 0;
//        int pos = asciiToRandom.length()-1;
//
//        Random ram = new Random();
//        ram.setSeed(randomNumber);
//        seed = Coding.randomBetween(randomNumber * pos, 0, asciiToRandom.length());
//        char mark = asciiToRandom.charAt(seed);
//        random1+=(char)seed;
//        int corrector=3;
//        String prueba1;
//        while (pos != 0) {
//            //Si esa posición ya ha sido cogida sigue buscando
//            while (asciiToRandom.charAt(seed) == mark) {
//                seed = Coding.randomBetween(randomNumber * (pos*corrector), 0, asciiToRandom.length()-1);
//                corrector++;
//            }
//            //Aplica los cambios 
//            corrector=3;
//            random1+=asciiToRandom.charAt(seed);
//            asciiToRandom=asciiToRandom.replace(asciiToRandom.charAt(seed), mark );
//            pos--;
//        }
//
//        System.out.println(random1);
//        System.out.println(random1.indexOf(" "));
//        String adios = Coding.encrypt(hola, 55);

//        System.out.println(adios );
//        
//        adios=Coding.unencrypt(adios,55);
//        System.out.println(adios);
    }

}
