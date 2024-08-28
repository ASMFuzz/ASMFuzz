import java.math.BigInteger;
import java.util.Random;

public class MyJVMTest_7539 {

    static int op1Param1 = 124;

    static int op1Param2 = 388;

    static Random op1Param3 = new Random();

    static BigInteger op1 = new BigInteger(op1Param1, op1Param2, op1Param3);

    BigInteger new_multiply(BigInteger op1) {
        return op1.multiply(op1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7539().new_multiply(op1));
    }
}
