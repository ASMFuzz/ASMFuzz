import java.io.*;
import java.util.*;

public class MyJVMTest_12300 {

    static String fParam1Param1 = "Qn\"\"K5*#vR";

    static String fParam1Param2 = "5v6a2*_oe$";

    static File fParam1 = new File(fParam1Param1, fParam1Param2);

    static String fParam2 = "#$Ld%bEjE/";

    static File f = new File(fParam1, fParam2);

    static int major = 0;

    byte[] setMajorVersion(File f, int major) throws IOException {
        int len = (int) f.length();
        byte[] data = new byte[len];
        try (DataInputStream in = new DataInputStream(new FileInputStream(f))) {
            in.readFully(data);
        }
        data[6] = (byte) (major >> 8);
        data[7] = (byte) (major & 0xff);
        try (FileOutputStream out = new FileOutputStream(f)) {
            out.write(data);
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12300().setMajorVersion(f, major);
    }
}
