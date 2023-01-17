package Main;

import coding.Coding;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DAM
 */
public class Pruebas {
    
    public static void main(String[] args){
        String hola="hola";
        String adios=Coding.encrypt(hola, 55);
        
        System.out.println(adios);
        
        adios=Coding.unencrypt(adios,55);
        System.out.println(adios);
    }
    
}
