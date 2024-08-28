import java.nio.CharBuffer;

public class MyJVMTest_13217 {

    static String unicodeCNS1 = "P=pi~HEU7r";

    static String unicodeCNS2 = "5TF<st|baO";

    static String unicodeCNS3 = "g.(:Cfp2}h";

    static String unicodeCNS4 = "@Rcf59S'`P";

    static String unicodeCNS5 = "TI2 QA&%$S";

    static String unicodeCNS6 = "6;N$!`\\S9;";

    static String unicodeCNS7 = "{/}-wL~k2R";

    static String unicodeCNS15 = "9U/Ndi3j&Z";

    String historicalName() {
        return "EUC_TW_OLD";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13217().historicalName());
    }
}
