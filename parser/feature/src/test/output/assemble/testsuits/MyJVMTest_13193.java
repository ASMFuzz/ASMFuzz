import java.math.BigInteger;

public class MyJVMTest_13193 {

    static String op1Param1 = "%YUe@DYDui";

    static BigInteger op1 = new BigInteger(op1Param1);

    static int op2Param1 = 290;

    static byte[] op2Param2 = { 93, 48, -91, 124, 14, 122, 61, 28, -21, -13 };

    static BigInteger op2 = new BigInteger(op2Param1, op2Param2);

    BigInteger base_multiply(BigInteger op1, BigInteger op2) {
        return op1.multiply(op2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13193().base_multiply(op1, op2));
    }
}
