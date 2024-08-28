import java.math.BigInteger;
import java.util.Random;

public class MyJVMTest_15603 {

    static int op1Param1 = 293;

    static int op1Param2 = 831;

    static Random op1Param3 = new Random();

    static BigInteger op1 = new BigInteger(op1Param1, op1Param2, op1Param3);

    static int op2Param1 = 729;

    static long op2Param2Param1 = -9223372036854775808L;

    static Random op2Param2 = new Random(op2Param2Param1);

    static BigInteger op2 = new BigInteger(op2Param1, op2Param2);

    BigInteger new_multiply(BigInteger op1, BigInteger op2) {
        return op1.multiply(op2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15603().new_multiply(op1, op2));
    }
}
