package mainpackage;

import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author Bruno
 */
public class Encriptar {

    //Todos los caracters que reconoce el usuario
    private static final String KEYBOARDKEYS = "\t\r\n €!\"#$%"
            + "&'()*+,-./0123456789:;<=>@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcde"
            + "fghijklmnopqrstuvwxyz{|}~!?¡¢£¤¥¦"
            + "§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçè"
            + "éêëìíîïðñòóôõö÷øùúûüýþÿĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħĨĩ"
            + "ĪīĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽž΅";

    //Conjunto de char donde encuntra la posición del caracter a cifrar
    private static String charPosArr[];

    //Conjunto de char donde con la posición cogida del anterior array + el numero indicado se coge el caracter resultado
    private static String charCodArr[];

    /**
     * Constructor para cargar los Strings
     */
    public Encriptar() {
        chargeStrings();
    }

    /**
     * Encripta la palabra
     *
     * @param uncoded Texto sin encriptar
     * @param codingNum Número clave para la desencriptación
     * @return
     */
    private String encrypt(String uncoded, int codingNum) {
        int pos;

        String[] coding = uncoded.split("");

        if (codingNum < 0) {
            codingNum = codingNum - codingNum - codingNum;
        }

        if (codingNum >= charPosArr.length) {
            codingNum %= charPosArr.length;
        }

        for (int i = 0; i < coding.length; i++) {
            pos = takePos(coding[i], charPosArr);
            if (pos != charPosArr.length) { //check if is not a unknown character
                pos -= codingNum;
                if (pos < 0) {
                    pos = (charPosArr.length - pos * -1);
                }
            }
            coding[i] = charCodArr[pos];
        }
        return String.join("", coding);
    }

    /**
     *
     * @param uncoded
     * @return Devuelve el código encriptado y los 3 últimos caracteres son el
     * número de encriptación Si el return es "", o los carácteres no son
     * válidos o el número no es válido
     */
    public String encriptarParaTransferir(String uncoded) {
        String encryption = "";
        String numEncripted;
        int codingNum = randomBetween(KEYBOARDKEYS.length());

        if (comprobarCaracteresYNumero(uncoded)) {
            encryption = encrypt(uncoded, codingNum);
            numEncripted = encryptNumber(codingNum);
            encryption = numEncripted + encryption;
        }

        return encryption;
    }

    /**
     *
     * @param charS //letra de la que se busca la posición
     * @param charList//char con el que trabajamos
     * @return //La posicion donde se encuentra
     */
    private static int takePos(String charS, String[] charList) {
        int pos = 0;
        boolean founded = false;
        while (!founded && pos < charList.length) {

            if (charS.equals(charList[pos])) {
                founded = true;
            }
            pos++;
        }
        return pos - 1;
    }

    private static int randomBetweenSeed(int seed, int max) {
        int num;
        Random ram = new Random();
        ram.setSeed(seed);
        num = ram.nextInt(max + 1);
        return num;
    }

    private static int randomBetween(int max) {
        int num;
        long seed = System.currentTimeMillis();
        Random ram = new Random();
        ram.setSeed(seed);
        num = ram.nextInt(max + 1);
        return num;
    }

    private void chargeStrings() {
        String random1;
        String random2;
        LocalDateTime lo = java.time.LocalDateTime.now();

        int randomNumber = lo.getDayOfYear() * lo.getDayOfMonth() * lo.getMonthValue();//TODO cambiar a una operación con la fecha

        random1 = randomizeString(randomNumber);
        randomNumber = lo.getDayOfYear() * lo.getDayOfMonth() * lo.getMonthValue() * lo.getYear();
        random2 = randomizeString(randomNumber);

        charPosArr = random1.split("");
        charCodArr = random2.split("");

    }

    private static String randomizeString(int randomNumber) {
        String random = "";
        String keyboardToRandom = KEYBOARDKEYS;
        int pos = keyboardToRandom.length() - 2;
        int seed;
        char mark;
        Random ram = new Random();

        ram.setSeed(randomNumber);
        seed = randomBetweenSeed(randomNumber * pos, KEYBOARDKEYS.length());
        //Marca que indica que caractes ya ha sido usado, es el primer caracter usado
        mark = keyboardToRandom.charAt(seed);
        random += mark;
        //Se explica en el bucle
        int corrector = 3;
        while (pos != 0) {
            //Si esa posición ya ha sido cogida sigue buscando
            while (keyboardToRandom.charAt(seed) == mark) {
                //Como pos no cambia dentro de este bucle se añade el factor corrector
                seed = randomBetweenSeed(randomNumber - pos * corrector, keyboardToRandom.length() - 1);
                //Modifica el corrector para hacer más intentos
                corrector++;

            }

            //Aplica los cambios 
            corrector = 3;//Se resetea el corrector
            random += keyboardToRandom.charAt(seed);
            //Sustituye el caracter ya cogido por la marca, para que no lo vuelva a coger
            keyboardToRandom = keyboardToRandom.replace(keyboardToRandom.charAt(seed), mark);
            pos--;
        }
        return random;
    }

    private boolean comprobarCaracteresYNumero(String uncoded) {
        boolean caracteresValidos = true;
        int pos = uncoded.length() - 1;
        while (caracteresValidos && pos != 0) {
            caracteresValidos = KEYBOARDKEYS.indexOf(uncoded.charAt(pos)) != -1;
            pos--;
        }
        return caracteresValidos;
    }

    /**
     *
     * @param codingNum
     * @return
     */
    private String encryptNumber(int codingNum) {
        String encriptedNumber;

//      Como se encriptan 3 caracteres del número, se transforma en un String de 
//      3 caracteres
        if (codingNum / 10 == 0) {
            encriptedNumber = "00" + codingNum;
        } else if (codingNum / 100 == 0) {
            encriptedNumber = "0" + codingNum;
        } else {
            encriptedNumber = "" + codingNum;
        }

        encriptedNumber = encrypt(encriptedNumber, 3);
        return encriptedNumber;

    }

    public static String[] getCharPosArr() {
        return charPosArr;
    }

    public static String[] getCharCodArr() {
        return charCodArr;
    }

}
