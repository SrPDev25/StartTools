package coding;

/**
 *
 * @author SrPollo
 */
public class Coding {

    
    public static String coding1(String uncoded, int codingNum) {
        String charPos = "Mp0,HGF?VC.ñKJNS¿UIO8nju7bhy6vg¡WQZPBlo9mkiXDEt5cfr4xd!e3zRTYsw2a q1AÑL*";
        String charCod = "kiXSp0,Hn!ju7b9m5ZPD?2a q6v4xdeC.ñK¿JhyGUIFVBzRTYswÑLlo¡NQcfrgWO8Et1A3M*";
        String[] charPosArr = charPos.split("");
        String[] charCodArr = charCod.split("");
        int pos;
        String[] coding = uncoded.split("");
        if(codingNum>=charPosArr.length){
            codingNum%=charPosArr.length;
        }
        for (int i = 0; i < coding.length; i++) {
            pos = takePos(coding[i], charPosArr);
            if (pos != charPosArr.length) { //check if is not a unknown character
                pos -= codingNum;
                if (pos < 0) {
                    pos = (charPosArr.length - pos * -1)-1;
                }
            }
            coding[i] = charCodArr[pos];
        }
        return String.join("", coding);
    }

    public static String uncoding1(String uncoded, int codingNum) {
        String charPos = "Mp0,HGF?VC.ñKJNS¿UIO8nju7bhy6vg¡WQZPBlo9mkiXDEt5cfr4xd!e3zRTYsw2a q1AÑL";
        String charCod = "kiXSp0,Hn!ju7b9m5ZPD?2a q6v4xdeC.ñK¿JhyGUIFVBzRTYswÑLlo¡NQcfrgWO8Et1A3M";
        String[] charPosArr = charPos.split("");
        String[] charCodArr = charCod.split("");
        int pos;
        String[] coding = uncoded.split("");
        if(codingNum>=charPosArr.length){
            codingNum%=charPosArr.length;
        }
        for (int i = 0; i < coding.length; i++) {
            pos = takePos(coding[i], charCodArr);
            if (pos != charPosArr.length) { //check if is not a unknown character
                pos += codingNum;
                if (pos >= charPosArr.length) {
                    pos = pos - charPosArr.length;
                }
            }
            coding[i] = charPosArr[pos];
        }
        return String.join("", coding);
    }

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

}
