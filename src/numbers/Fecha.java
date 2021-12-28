package numbers;

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
        if (!setFecha(inputFecha)) {
            System.out.println("Estan mal intoducidos los datos del constructor");
        }
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
        GregorianCalendar fechaE=new GregorianCalendar();
        setFecha(fechaE.get(GregorianCalendar.MONTH)+"/"+ fechaE.get(GregorianCalendar.DAY_OF_MONTH)+"/"+fechaE.get(GregorianCalendar.YEAR));
    }
    /**
     * Introduce en la variable fecha la fecha desde un String
     *
     * @param inputFecha String con una estructura dd/mm/yyyy
     * @return retorna un boolean para que en los otros métodos muestre un
     * respectivo error
     */
    private boolean setFecha(String inputFecha) {
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
                if (fecha[1] == 2 && fecha[2] % 4 == 0) {
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
                } else {
                    comprobacion = false;
                }
            }
        } catch (ArrayIndexOutOfBoundsException lessLenghtError) {//Error cuando faltan datos
            comprobacion = false;
        }catch (NumberFormatException notNumberError){
            comprobacion=false;
        }
        return comprobacion;

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
