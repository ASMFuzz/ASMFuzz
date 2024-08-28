import java.math.BigInteger;

public class MyJVMTest_3718 {

    static String valueParam1 = "focEmg\"`oB";

    static int valueParam2 = 523;

    static BigInteger value = new BigInteger(valueParam1, valueParam2);

    boolean inLongRange(BigInteger value) {
        return value.bitLength() <= 63;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3718().inLongRange(value));
    }
}
