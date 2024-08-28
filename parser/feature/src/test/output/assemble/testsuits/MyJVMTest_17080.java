import java.math.BigInteger;

public class MyJVMTest_17080 {

    static int op1Param1 = 603;

    static byte[] op1Param2 = { -9, -18, -70, -102, -65, -54, 119, 117, -37, 61 };

    static BigInteger op1 = new BigInteger(op1Param1, op1Param2);

    BigInteger new_multiply(BigInteger op1) {
        return op1.multiply(op1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17080().new_multiply(op1));
    }
}
