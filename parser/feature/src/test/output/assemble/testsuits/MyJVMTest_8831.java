import java.io.*;
import java.net.URI;

public class MyJVMTest_8831 {

    static String fParam1Param1 = "3G%n+Hd! Z";

    static String fParam1Param2 = "8@X]Xf5_Uw";

    static String fParam1Param3 = "~_!\\jD[6#F";

    static URI fParam1 = new URI(fParam1Param1, fParam1Param2, fParam1Param3);

    static File f = new File(fParam1);

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

    int skipAttributes(DataInputStream in) throws IOException {
        int attributes_count = in.readUnsignedShort();
        for (int i = 0; i < attributes_count; i++) {
            in.skipBytes(2);
            int length = in.readInt();
            in.skipBytes(length);
        }
        return attributes_count;
    }

    DataInputStream modifyClassFile(File f) throws IOException {
        String newAttributeName = "NonstandardAttribute";
        byte[] newAttributeData = { 0, 1, 2, 127, (byte) 128, (byte) 129, (byte) 254, (byte) 255 };
        DataInputStream in = new DataInputStream(new FileInputStream(f));
        byte[] data = new byte[(int) f.length()];
        in.readFully(data);
        in.close();
        in = new DataInputStream(new ByteArrayInputStream(data));
        in.skipBytes(4);
        in.skipBytes(2);
        in.skipBytes(2);
        int constantPoolPos = data.length - in.available();
        int constant_pool_count = skipConstantPool(in);
        int flagsPos = data.length - in.available();
        in.skipBytes(2);
        in.skipBytes(2);
        in.skipBytes(2);
        int interfaces_count = in.readUnsignedShort();
        in.skipBytes(interfaces_count * 2);
        int field_count = in.readUnsignedShort();
        for (int i = 0; i < field_count; i++) {
            in.skipBytes(6);
            skipAttributes(in);
        }
        int method_count = in.readUnsignedShort();
        for (int i = 0; i < method_count; i++) {
            in.skipBytes(6);
            skipAttributes(in);
        }
        int classAttributesPos = data.length - in.available();
        int attributes_count = in.readUnsignedShort();
        f.renameTo(new File(f.getPath() + ".BAK"));
        DataOutputStream out = new DataOutputStream(new FileOutputStream(f));
        out.write(data, 0, constantPoolPos);
        out.writeShort(constant_pool_count + 1);
        out.write(data, constantPoolPos + 2, flagsPos - constantPoolPos - 2);
        out.write(1);
        out.writeUTF(newAttributeName);
        out.write(data, flagsPos, classAttributesPos - flagsPos);
        out.writeShort(attributes_count + 1);
        out.write(data, classAttributesPos + 2, data.length - classAttributesPos - 2);
        out.writeShort(constant_pool_count);
        out.writeInt(newAttributeData.length);
        out.write(newAttributeData);
        out.close();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8831().modifyClassFile(f);
    }
}
