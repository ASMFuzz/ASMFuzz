import java.util.*;

public class MyJVMTest_10370 {

    static byte[] data = { 11, 99, 116, -126, 70, -12, -24, -32, 25, -10 };

    byte[] dumpHexBytes(byte[] data) {
        if (data != null) {
            for (int i = 0; i < data.length; i++) {
                if (i % 16 == 0 && i != 0) {
                    System.out.print("\n");
                }
                System.out.print(String.format("%02X ", data[i]));
            }
            System.out.print("\n");
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10370().dumpHexBytes(data);
    }
}
