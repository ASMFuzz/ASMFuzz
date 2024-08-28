import java.util.*;

public class MyJVMTest_8834 {

    static byte[] data = { -51, 39, 6, -82, -52, 64, -4, -88, 81, -65 };

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
        new MyJVMTest_8834().dumpHexBytes(data);
    }
}
