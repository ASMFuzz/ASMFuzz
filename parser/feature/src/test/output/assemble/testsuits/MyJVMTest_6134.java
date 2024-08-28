import java.math.BigInteger;
import java.util.Random;

public class MyJVMTest_6134 {

    static int op1Param1 = 833;

    static Random op1Param2 = new Random();

    static BigInteger op1 = new BigInteger(op1Param1, op1Param2);

    static String op2Param1 = "l<K3bZ%hjQ";

    static int op2Param2 = 668;

    static BigInteger op2 = new BigInteger(op2Param1, op2Param2);

    BigInteger new_multiply(BigInteger op1, BigInteger op2) {
        return op1.multiply(op2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6134().new_multiply(op1, op2));
    }
}
