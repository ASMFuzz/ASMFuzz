import java.io.*;

public class MyJVMTest_15126 {

    static byte[] inParam1Param1 = { 10, -95, -30, -54, -56, 115, 102, 76, -77, -40 };

    static int inParam1Param2 = 176;

    static int inParam1Param3 = 226;

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1, inParam1Param2, inParam1Param3);

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
        System.out.println(new MyJVMTest_15126().skipAttributes(in));
    }
}
