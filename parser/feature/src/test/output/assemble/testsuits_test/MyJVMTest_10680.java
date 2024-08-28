import java.io.*;
import java.util.*;

public class MyJVMTest_10680 {

    static String classFileName = "TST99!Z97B";

    static String hexString = "blM)-*3fcb";

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

    File writeHexFile(String classFileName, String hexString) throws IOException {
        File f = new File(classFileName);
        FileOutputStream output = new FileOutputStream(f);
        output.write(hexToByte(hexString));
        output.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10680().writeHexFile(classFileName, hexString));
    }
}
