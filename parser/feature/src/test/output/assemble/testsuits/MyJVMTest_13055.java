import java.math.BigInteger;
import java.util.Random;

public class MyJVMTest_13055 {

    static int valueParam1 = 543;

    static int valueParam2 = 289;

    static long valueParam3Param1 = -9223372036854775808L;

    static Random valueParam3 = new Random(valueParam3Param1);

    static BigInteger value = new BigInteger(valueParam1, valueParam2, valueParam3);

    boolean inLongRange(BigInteger value) {
        return value.bitLength() <= 63;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13055().inLongRange(value));
    }
}
