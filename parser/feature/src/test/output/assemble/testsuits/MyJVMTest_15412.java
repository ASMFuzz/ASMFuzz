import java.text.*;

public class MyJVMTest_15412 {

    static long value = 9223372036854775807L;

    static int minDigits = 0;

    static int maxDigits = -832919722;

    static String nfParam1 = "??I]nN%+3k";

    static NumberFormat nf = new ChoiceFormat(nfParam1);

    String zeroPaddingNumber(long value, int minDigits, int maxDigits, NumberFormat nf) {
        nf.setMinimumIntegerDigits(minDigits);
        nf.setMaximumIntegerDigits(maxDigits);
        return nf.format(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15412().zeroPaddingNumber(value, minDigits, maxDigits, nf));
    }
}
