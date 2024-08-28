import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_12176 {

    static byte[] inParam1Param1 = { 72, 19, -17, 37, -26, -41, 71, -44, -20, -70 };

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1);

    static DataInputStream in = new DataInputStream(inParam1);

    byte[] readRawBytes(DataInputStream in, int size) throws IOException {
        byte[] bytes = new byte[size];
        int nr = in.read(bytes);
        if (nr != size)
            throw new InternalError("wrong size: " + nr);
        return bytes;
    }

    static short name = 5206;

    static int size = -1;

    static Object item = 37081997;

    DataInputStream readFrom(DataInputStream in) throws IOException {
        name = in.readShort();
        size = in.readInt();
        item = readRawBytes(in, size);
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12176().readFrom(in);
    }
}
