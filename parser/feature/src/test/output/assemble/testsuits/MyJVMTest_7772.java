import java.math.BigInteger;

public class MyJVMTest_7772 {

    static int op1Param1 = 233;

    static byte[] op1Param2 = { 100, 28, -33, -5, 0, 42, -13, 92, 112, 8 };

    static BigInteger op1 = new BigInteger(op1Param1, op1Param2);

    BigInteger base_multiply(BigInteger op1) {
        return op1.multiply(op1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7772().base_multiply(op1));
    }
}
