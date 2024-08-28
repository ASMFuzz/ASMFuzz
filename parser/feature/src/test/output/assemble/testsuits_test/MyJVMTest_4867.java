import java.math.BigInteger;

public class MyJVMTest_4867 {

    static boolean clearHighBit = true;

    static String str = "qC,#dJ/Y6l";

    BigInteger hexStringToBigInteger(boolean clearHighBit, String str) {
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < str.length() / 2; i++) {
            int curVal = Character.digit(str.charAt(2 * i), 16);
            curVal <<= 4;
            curVal += Character.digit(str.charAt(2 * i + 1), 16);
            if (clearHighBit && i == str.length() / 2 - 1) {
                curVal &= 0x7F;
            }
            result = result.add(BigInteger.valueOf(curVal).shiftLeft(8 * i));
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4867().hexStringToBigInteger(clearHighBit, str));
    }
}
