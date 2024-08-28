import java.io.*;

public class MyJVMTest_12852 {

    static byte[] data = { 87, 66, 52, -109, -8, 27, -68, 33, 71, -79 };

    static char[] hexCode = "0123456789ABCDEF".toCharArray();

    String printHexBinary(byte[] data) {
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12852().printHexBinary(data));
    }
}
