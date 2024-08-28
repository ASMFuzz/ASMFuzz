import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_9055 {

    static byte[] inParam1Param1 = { -121, -60, -93, 109, 5, 91, 101, 14, 80, 59 };

    static int inParam1Param2 = 801;

    static int inParam1Param3 = 577;

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1, inParam1Param2, inParam1Param3);

    static DataInputStream in = new DataInputStream(inParam1);

    byte[] readRawBytes(DataInputStream in, int size) throws IOException {
        byte[] bytes = new byte[size];
        int nr = in.read(bytes);
        if (nr != size)
            throw new InternalError("wrong size: " + nr);
        return bytes;
    }

    static short name = -32768;

    static int size = -1;

    static Object item = 3;

    DataInputStream readFrom(DataInputStream in) throws IOException {
        name = in.readShort();
        size = in.readInt();
        item = readRawBytes(in, size);
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9055().readFrom(in);
    }
}
