import java.math.*;

public class MyJVMTest_12617 {

    static String goodString = "P-lza#]+OP";

    static long value = 9223372036854775807L;

    long constructWithoutError(String goodString, long value) {
        BigInteger bi = new BigInteger(goodString);
        if (bi.longValue() != value) {
            System.err.printf("From ``%s'' expected %d, got %s.\n", goodString, value, bi);
            throw new RuntimeException();
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12617().constructWithoutError(goodString, value);
    }
}
