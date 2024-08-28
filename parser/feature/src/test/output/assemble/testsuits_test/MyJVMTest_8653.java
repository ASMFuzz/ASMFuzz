import java.io.*;

public class MyJVMTest_8653 {

    static byte[] inParam1Param1 = { -70, -73, -33, -90, -90, -31, 22, -36, -16, -16 };

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1);

    static DataInputStream in = new DataInputStream(inParam1);

    int skipAttributes(DataInputStream in) throws IOException {
        int attributes_count = in.readUnsignedShort();
        for (int i = 0; i < attributes_count; i++) {
            in.skipBytes(2);
            int length = in.readInt();
            in.skipBytes(length);
        }
        return attributes_count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8653().skipAttributes(in));
    }
}
