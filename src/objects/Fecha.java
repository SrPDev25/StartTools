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
    private static final String[] MESES={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    /**
     * Constructor con una fecha ya introducida
     *
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

    public void setToday() {
        Calendar fechaE = new GregorianCalendar();
        setFecha(fechaE.get(Calendar.DATE) + "/" + fechaE.get(Calendar.MONTH) + "/" + fechaE.get(Calendar.YEAR));
        fecha[1] += 1;
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
     *
     * @param year Se intruduce in int con el año a comprobar
     * @return true=bisiesto false=no bisiesto
     */
    public boolean bisiesto(int year) {
        boolean bisiesto = false;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 != 0)) {
            bisiesto = true;
        }
        return bisiesto;
    }

    /** 
     * Metodo que calcula los enios de una fecha hasta el dia de hoy.
     * @param fechaAlta
     * @param cuantosEnio
     * @return 
     */
    public static int calcularEnios(Fecha fechaAlta, int cuantosEnio) {
        Fecha fechaHoy = new Fecha();
        fechaHoy.setToday();
        int cantidad;
        int annoCumplido = 1;
        if (fechaAlta.getMes() < fechaHoy.getMes()) {
            annoCumplido--;
        } else if (fechaAlta.getMes() == fechaHoy.getMes() && fechaAlta.getDia() <= fechaHoy.getDia()) {
            annoCumplido--;
        }
        return (fechaHoy.getAnno() - fechaAlta.getAnno() - annoCumplido) / cuantosEnio;

    }

    /**
     * Calcula el orden de la fecha
     *
     * @return retorna un Integer con el numero de orden
     */
    public int calcularOrden() {
        int orden = 0;
        int diasMesProvisional[] = diasMeses;
        if (bisiesto(fecha[2])) {
            diasMesProvisional[1] = 29;
        }
        for (int i = 0; i < fecha[1]; i++) {
            orden += diasMesProvisional[i];
        }
        orden += fecha[1];
        return orden;
    }

    /**
     * A partir de los dias faltantes para el vencimiento saca la fecha del mismo
     * @param diasVencimiento Introduce los dias para el vencimiento
     * @return retorna la fecha de vencimiento
     */
    public Fecha calcularFechaVencimiento(int diasVencimiento) {
        Fecha fechaHoy = new Fecha();
        Fecha caducidad = new Fecha();
        int diasMesProvisional[] = diasMeses;
        fechaHoy.setToday();
        int orden;
        int diasAnno = 365;
        orden = fechaHoy.calcularOrden();
        if (bisiesto(fecha[2])) {
            diasMesProvisional[1] = 29;
            diasAnno = 366;
        }
        orden += diasVencimiento;
        while (orden < diasAnno) {
            fechaHoy.fecha[2] += 1;
            orden -= diasAnno;

            if (bisiesto(fechaHoy.fecha[2])) {
                diasMesProvisional[1] = 29;
                diasAnno = 366;
            } else {
                diasMesProvisional[1] = 28;
                diasAnno = 365;
            }
        }
        caducidad.fecha[2] = fechaHoy.fecha[2];
        caducidad.fecha[1] = 1;
        while (orden < diasMesProvisional[caducidad.fecha[1] - 1]) {
            orden -= diasMesProvisional[caducidad.fecha[1] - 1];
            caducidad.fecha[1]++;
        }
        caducidad.fecha[0] += orden;

        return caducidad;
    }

    public int getMes() {
        return fecha[1];
    }

    public int getDia() {
        return fecha[0];
    }

    public int getAnno() {
        return fecha[2];
    }
}
