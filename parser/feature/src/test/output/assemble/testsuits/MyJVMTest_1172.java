import java.util.*;

public class MyJVMTest_1172 {

    static byte[] data = { 103, 76, -90, -57, 15, -56, -72, 86, -1, 64 };

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
        new MyJVMTest_1172().dumpHexBytes(data);
    }
}
