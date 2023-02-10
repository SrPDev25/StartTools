package Main;

import coding.EncryptionTwo;
import java.time.LocalDateTime;
import java.util.Calendar;

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
//        int pos =7000;
//        while(pos!=20000){
//        System.out.print((char) pos);
//        pos++;
//        }
//        System.out.println("");

        EncryptionTwo en=new EncryptionTwo();
        String texto="Buenas tardes paco";
        System.out.println(texto);
        texto=en.encriptarParaTransferir(texto);
        System.out.println(texto);
        texto=en.desencriptarTransferido(texto);
        System.out.println(texto);
        System.out.println((int)'€');
    }

}
