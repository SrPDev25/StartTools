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
       EncryptionTwo en=new EncryptionTwo();
       String texto="hola";
        System.out.println(texto);
        texto=en.encriptarParaTransferir(texto);
        System.out.println(texto);
        texto=en.desencriptarTransferido(texto);
        System.out.println(texto);
    }

}
