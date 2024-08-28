import java.math.BigInteger;

public class MyJVMTest_1373 {

    static String b1Param1 = "$P#WLXoi[/";

    static int b1Param2 = 632;

    static BigInteger b1 = new BigInteger(b1Param1, b1Param2);

    static String b2Param1 = "4UE:^mHXuZ";

    static int b2Param2 = 29;

    static BigInteger b2 = new BigInteger(b2Param1, b2Param2);

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
        System.out.println(new MyJVMTest_1373().bytecompare(b1, b2));
    }
}
