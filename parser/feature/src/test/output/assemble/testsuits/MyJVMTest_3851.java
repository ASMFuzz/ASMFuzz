import java.math.BigInteger;
import java.util.Random;

public class MyJVMTest_3851 {

    static int op1Param1 = 163;

    static int op1Param2 = 749;

    static Random op1Param3 = new Random();

    static BigInteger op1 = new BigInteger(op1Param1, op1Param2, op1Param3);

    static int op2Param1 = 874;

    static int op2Param2 = 361;

    static Random op2Param3 = new Random();

    static BigInteger op2 = new BigInteger(op2Param1, op2Param2, op2Param3);

    BigInteger base_multiply(BigInteger op1, BigInteger op2) {
        return op1.multiply(op2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3851().base_multiply(op1, op2));
    }
}
