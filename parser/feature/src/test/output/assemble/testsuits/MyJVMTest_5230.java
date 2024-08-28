import java.math.BigInteger;

public class MyJVMTest_5230 {

    static int bParam1 = 962;

    static byte[] bParam2 = { -54, -29, -100, -62, -79, -63, 3, 105, 123, 106 };

    static BigInteger b = new BigInteger(bParam1, bParam2);

    String stringify(BigInteger b) {
        String strout = "";
        byte[] data = b.toByteArray();
        for (int i = 0; i < data.length; i++) {
            strout += (String.format("%02x", data[i]) + " ");
        }
        return strout;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5230().stringify(b));
    }
}
