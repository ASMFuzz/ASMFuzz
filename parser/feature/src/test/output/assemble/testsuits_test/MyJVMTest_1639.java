import java.io.*;

public class MyJVMTest_1639 {

    static byte[] utf = { -106, -64, 120, 103, 40, -21, 94, -104, -93, -61 };

    ObjectOutputStream checkConsume(byte[] utf) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(bout);
        oout.write(utf);
        oout.writeByte(0);
        oout.close();
        ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        try {
            oin.readUTF();
            throw new Error();
        } catch (UTFDataFormatException ex) {
        }
        oin.readByte();
        return oout;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1639().checkConsume(utf);
    }
}
