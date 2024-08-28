import java.math.BigInteger;

public class MyJVMTest_14650 {

    static String bParam1 = "r>](\"0lA[A";

    static int bParam2 = 965;

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
        System.out.println(new MyJVMTest_14650().stringify(b));
    }
}
