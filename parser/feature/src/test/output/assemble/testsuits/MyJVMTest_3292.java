import java.math.*;

public class MyJVMTest_3292 {

    static String goodString = "J)a)#R^QN5";

    static long value = 5980378629862515062L;

    long constructWithoutError(String goodString, long value) {
        BigInteger bi = new BigInteger(goodString);
        if (bi.longValue() != value) {
            System.err.printf("From ``%s'' expected %d, got %s.\n", goodString, value, bi);
            throw new RuntimeException();
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3292().constructWithoutError(goodString, value);
    }
}
