import java.math.*;
import java.text.*;

public class MyJVMTest_14658 {

    static RoundingMode rm = null;

    static String[] expected = { "B<)((6_p+s", "@Om~cdd{*X", "ZfZ4:(J DD", "gU\"So>}kRY", "q|)]E!rO2Z", "+)o\\'xF~_]", "c&*;m-V19)", "gCA$;>tVGP", ".F/vv<y_e&", ";x3.&><0d%" };

    static String AE = "ArithmeticException";

    static double[] src = { 5.5, 2.5, 1.6, 1.1, 1.0, -1.0, -1.1, -1.6, -2.5, -5.5, 5.501, -5.501, 5.500, -5.500, 1.001, -1.001, 4.501, -4.501, 4.500, -4.500 };

    RoundingMode roundTest(RoundingMode rm, String[] expected) {
        NumberFormat nf = NumberFormat.getIntegerInstance();
        nf.setRoundingMode(rm);
        if (nf.getRoundingMode() != rm) {
            throw new RuntimeException("set rounding mode is not returned by get method");
        }
        for (int i = 0; i < src.length; i++) {
            String result = null;
            try {
                result = nf.parse(nf.format(src[i])).toString();
                if (!result.equals(expected[i])) {
                    throw new RuntimeException("rounding test #" + i + " failed. mode: " + rm + " src: " + src[i] + " expected: " + expected[i] + " result: " + result);
                }
            } catch (ArithmeticException ae) {
                if (expected[i].equals(AE)) {
                    continue;
                } else {
                    result = AE;
                    throw new RuntimeException("rounding test #" + i + " failed. mode: " + rm + " src: " + src[i] + " expected: " + expected[i] + " result: " + result);
                }
            } catch (ParseException pe) {
                throw new RuntimeException("ParseException ocurred.", pe);
            }
        }
        return rm;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14658().roundTest(rm, expected);
    }
}
