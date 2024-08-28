import java.util.*;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_6075 {

    static byte[] bytes = { -56, 116, -12, 87, -108, -60, -23, -110, -117, -125 };

    static String name = "|o2#Kta%_\\";

    static int method = 1408668721;

    static byte[] data = {113,4,1,24,-64,-64,77,-108,-55,120};

    static byte[] extra = {-5,34,66,-56,-24,33,102,-94,-49,8};

    static String comment = "gA%.%\\'<PB";

    byte[] toExtra(byte[] bytes) throws Exception {
        if (bytes == null)
            return null;
        byte[] v = new byte[bytes.length + 4];
        v[0] = (byte) 0x47;
        v[1] = (byte) 0xff;
        v[2] = (byte) bytes.length;
        v[3] = (byte) (bytes.length << 8);
        System.arraycopy(bytes, 0, v, 4, bytes.length);
        return v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6075().toExtra(bytes)));
    }
}
