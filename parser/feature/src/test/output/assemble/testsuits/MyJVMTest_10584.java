import java.math.BigInteger;

public class MyJVMTest_10584 {

    static int b1Param1 = 403;

    static byte[] b1Param2 = { 21, -81, -19, -14, 72, -31, 7, 123, -49, -23 };

    static BigInteger b1 = new BigInteger(b1Param1, b1Param2);

    static String b2Param1 = ",41=FSIm$Y";

    static BigInteger b2 = new BigInteger(b2Param1);

    boolean bytecompare(BigInteger b1, BigInteger b2) {
        byte[] data1 = b1.toByteArray();
        byte[] data2 = b2.toByteArray();
        if (data1.length != data2.length)
            return false;
        for (int i = 0; i < data1.length; i++) {
            if (data1[i] != data2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10584().bytecompare(b1, b2));
    }
}
