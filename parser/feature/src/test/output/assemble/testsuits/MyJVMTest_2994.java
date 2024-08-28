import java.io.*;
import java.util.*;
import java.net.URI;

public class MyJVMTest_2994 {

    static String fParam1Param1 = "o3|PJHjO*]";

    static String fParam1Param2 = "%6p%zbX9KK";

    static String fParam1Param3 = "l\"{9n|!DJi";

    static String fParam1Param4 = "aSJ*XnMC1 ";

    static String fParam1Param5 = "C*$:Q>%Cc/";

    static URI fParam1 = new URI(fParam1Param1, fParam1Param2, fParam1Param3, fParam1Param4, fParam1Param5);

    static File f = new File(fParam1);

    static int major = 2;

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
        new MyJVMTest_2994().setMajorVersion(f, major);
    }
}
