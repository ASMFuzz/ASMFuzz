import java.math.BigDecimal;
import java.math.MathContext;

public class MyJVMTest_7301 {

    static char[] arg1Param1 = { Character.MIN_VALUE, ',', ':', Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE };

    static BigDecimal arg1 = new BigDecimal(arg1Param1);

    static String arg2Param1 = "<!%Rk>-^Is";

    static int arg2Param2Param1 = 801;

    static MathContext arg2Param2 = new MathContext(arg2Param2Param1);

    static BigDecimal arg2 = new BigDecimal(arg2Param1, arg2Param2);

    static long expectedResultParam1 = 9223372036854775807L;

    static int expectedResultParam2Param1 = 926;

    static RoundingMode expectedResultParam2Param2 = null;

    static MathContext expectedResultParam2 = new MathContext(expectedResultParam2Param1, expectedResultParam2Param2);

    static BigDecimal expectedResult = new BigDecimal(expectedResultParam1, expectedResultParam2);

    int addTest(BigDecimal arg1, BigDecimal arg2, BigDecimal expectedResult) {
        int failures = 0;
        BigDecimal result = arg1.add(arg2);
        if (!result.equals(expectedResult)) {
            System.out.println("Sum:" + arg1 + " + " + arg2 + " == " + result + "; expected  " + expectedResult);
            failures++;
        }
        result = arg2.add(arg1);
        if (!result.equals(expectedResult)) {
            System.out.println("Sum:" + arg2 + " + " + arg1 + " == " + result + "; expected  " + expectedResult);
            failures++;
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7301().addTest(arg1, arg2, expectedResult));
    }
}
