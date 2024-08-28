import java.text.*;

public class MyJVMTest_5958 {

    static long value = -9223372036854775808L;

    static int minDigits = 0;

    static int maxDigits = 8;

    static double[] nfParam1 = { Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    static String[] nfParam2 = { "gX 3kCN|v~", "I&C{![@W%!", "+kc\\}%$=mG", "TmJ;Rc+RlH", "*9y3:s_k$(", "m:P;v`;d8H", "ySTlAN'\"iC", "dI,A-s:$sG", "7[w;lqaq[+", "&4;lY@CCih" };

    static NumberFormat nf = new ChoiceFormat(nfParam1, nfParam2);

    String zeroPaddingNumber(long value, int minDigits, int maxDigits, NumberFormat nf) {
        nf.setMinimumIntegerDigits(minDigits);
        nf.setMaximumIntegerDigits(maxDigits);
        return nf.format(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5958().zeroPaddingNumber(value, minDigits, maxDigits, nf));
    }
}
