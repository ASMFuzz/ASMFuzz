import java.io.*;
import java.util.*;

public class MyJVMTest_14604 {

    static String str = "doi,sM$EkL";

    byte[] hexToByte(String str) {
        char[] CA = str.toCharArray();
        byte[] byteArry = new byte[str.length() / 2];
        int bi = 0;
        for (int i = 0; i < CA.length; i += 2) {
            char c1 = CA[i], c2 = CA[i + 1];
            byteArry[bi++] = (byte) ((Character.digit((int) c1, 16) << 4) + Character.digit((int) c2, 16));
        }
        return byteArry;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14604().hexToByte(str)));
    }
}
