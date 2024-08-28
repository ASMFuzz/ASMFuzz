import java.math.BigInteger;

public class MyJVMTest_2497 {

    static int i1Param1 = 920;

    static byte[] i1Param2 = { -32, -30, -108, 107, -5, 52, -56, -80, -58, 116 };

    static BigInteger i1 = new BigInteger(i1Param1, i1Param2);

    static String i2Param1 = "NP$%Y}+z8J";

    static BigInteger i2 = new BigInteger(i2Param1);

    BigInteger m(BigInteger i1, BigInteger i2) {
        BigInteger res = BigInteger.valueOf(0);
        for (int i = 0; i < 100; i++) {
            res.add(i1.multiply(i2));
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2497().m(i1, i2));
    }
}
