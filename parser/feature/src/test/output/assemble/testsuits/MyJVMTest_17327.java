import java.math.BigInteger;

public class MyJVMTest_17327 {

    static int op1Param1 = 966;

    static byte[] op1Param2 = { -77, -99, 52, -98, 81, -34, -30, 29, -103, -83 };

    static BigInteger op1 = new BigInteger(op1Param1, op1Param2);

    BigInteger base_multiply(BigInteger op1) {
        return op1.multiply(op1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17327().base_multiply(op1));
    }
}
