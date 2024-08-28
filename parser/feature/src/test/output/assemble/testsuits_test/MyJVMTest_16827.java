import java.math.BigDecimal;
import java.math.MathContext;

public class MyJVMTest_16827 {

    static String arg1Param1 = "A!]wnhk %u";

    static int arg1Param2Param1 = 525;

    static MathContext arg1Param2 = new MathContext(arg1Param2Param1);

    static BigDecimal arg1 = new BigDecimal(arg1Param1, arg1Param2);

    static char[] arg2Param1 = { 'N', 'n', Character.MAX_VALUE, 'S', Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0' };

    static int arg2Param2 = 939;

    static int arg2Param3 = 531;

    static int arg2Param4Param1 = 412;

    static RoundingMode arg2Param4Param2 = null;

    static MathContext arg2Param4 = new MathContext(arg2Param4Param1, arg2Param4Param2);

    static BigDecimal arg2 = new BigDecimal(arg2Param1, arg2Param2, arg2Param3, arg2Param4);

    static char[] expectedResultParam1 = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, '0', 'p', Character.MIN_VALUE };

    static int expectedResultParam2 = 182;

    static int expectedResultParam3 = 789;

    static BigDecimal expectedResult = new BigDecimal(expectedResultParam1, expectedResultParam2, expectedResultParam3);

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
        System.out.println(new MyJVMTest_16827().addTest(arg1, arg2, expectedResult));
    }
}
