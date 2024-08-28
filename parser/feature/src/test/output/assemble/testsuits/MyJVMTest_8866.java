import java.io.*;

public class MyJVMTest_8866 {

    static byte[] inParam1Param1 = { -128, -102, -99, -100, -98, 6, 8, 13, -128, 15 };

    static int inParam1Param2 = 328;

    static int inParam1Param3 = 427;

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1, inParam1Param2, inParam1Param3);

    static DataInputStream in = new DataInputStream(inParam1);

    int skipConstantPool(DataInputStream in) throws IOException {
        int constant_pool_count = in.readUnsignedShort();
        for (int i = 1; i < constant_pool_count; i++) {
            int tag = in.readUnsignedByte();
            switch(tag) {
                case 1:
                    int length = in.readUnsignedShort();
                    in.skipBytes(length);
                    break;
                case 3:
                case 4:
                    in.skipBytes(4);
                    break;
                case 5:
                case 6:
                    in.skipBytes(8);
                    break;
                case 7:
                    in.skipBytes(2);
                    break;
                case 8:
                    in.skipBytes(2);
                    break;
                case 9:
                case 10:
                case 11:
                    in.skipBytes(4);
                    break;
                case 12:
                    in.skipBytes(4);
                    break;
                default:
                    throw new Error("constant pool tag: " + tag);
            }
        }
        return constant_pool_count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8866().skipConstantPool(in));
    }
}
