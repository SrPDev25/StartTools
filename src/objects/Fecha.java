package objects;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author casa
 */
public class Fecha {

    private int fecha[] = new int[3];
    private static int diasMeses[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//static ya que pertenece la misma lista a todas las fechas

    /**
     * Constructor con una fecha ya introducida
     * @param inputFecha String de una fecha con formato dd/mm/aaaa
     */
    public Fecha(String inputFecha) {
        setFecha(inputFecha);
    }

    /**
     * 
     */
    public Fecha() {
    }

    
    /**
     * Método para pedir que se introduzca la fecha
     */
    public void inputFecha() {
     Scanner input = new Scanner(System.in);
        String fechaProvisional;
        System.out.print("Introduce la fecha (dd/mm/aaaa): ");
        fechaProvisional = input.nextLine();
        while (!setFecha(fechaProvisional)) {
            System.out.println("Error: Se introdujo mal la fecha");
            System.out.print("Introduce la fecha (dd/mm/aaaa): ");
            fechaProvisional = input.nextLine();
        }   
    }

    
    
    public void setToday(){
        Calendar fechaE=new GregorianCalendar();
        setFecha(fechaE.get(Calendar.MONTH+1)+"/"+ fechaE.get(Calendar.DATE)+"/"+fechaE.get(Calendar.YEAR));
    }
    /**
     * Introduce en la variable fecha la fecha desde un String
     *
     * @param inputFecha String con una estructura dd/mm/yyyy
     * @return retorna un boolean para que en los otros métodos muestre un
     * respectivo error
     */
    public boolean setFecha(String inputFecha) {
        boolean comprobacion = true;
        int diaMax;//Dias maximos del més para comparar
        String[] convert;
        convert = inputFecha.split("/");

        try {
            //Introduce los datos en fecha
            for (int pos = 0; pos < fecha.length; pos++) {
                fecha[pos] = Integer.parseInt(convert[pos]);
            }

            if (convert.length <= 3) {//Comprueba si se introducen más datos de los nocesarios

                //Comprobación de bisiesto
                if (fecha[1] == 2 && bisiesto(fecha[2])) {
                    diaMax = 29;
                } else {
                    diaMax = diasMeses[fecha[1] - 1];
                }

                //Comprobación de fecha
                if (fecha[2] < 1) {//Comprobacion de año
                    comprobacion = false;
                } else if (fecha[1] > 12 || fecha[1] < 1) {//Comprobación de mes
                    comprobacion = false;
                } else if (fecha[0] > diaMax || fecha[0] < 1) {//Comprobación de año
                    comprobacion = false;
                }

                //Si comprobación==false se hacen nula la fecha
                if (!comprobacion) {
                    for (int pos = 0; pos < fecha.length; pos++) {
                        fecha[pos] = 0;
                    }
                } 
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException lessLenghtError) {//Error cuando faltan datos
            comprobacion = false;
        }
        return comprobacion;

    }
    

    
    
    /**
     * Comprueba si un año es bisiesto
     * @param year Se intruduce in int con el año a comprobar
     * @return true=bisiesto    false=no bisiesto
     */
    public boolean bisiesto(int year){
        boolean bisiesto=false;
        if((year%4==0&&year%100!=0)||(year%100==0&&year%400!=0)){
            bisiesto=true;
        }
        return bisiesto;
    }
    
    public int getMes(){
        return fecha[1];
    }
    public int getDia(){
        return fecha[0];
    }
    public int getAnno(){
        return fecha[2];
    }
}