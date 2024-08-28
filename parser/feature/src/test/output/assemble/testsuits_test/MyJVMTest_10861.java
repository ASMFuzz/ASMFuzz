import java.io.*;

public class MyJVMTest_10861 {

    static byte[] utf = { 108, 72, -104, 28, 62, 83, -70, -94, -41, 60 };

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
        new MyJVMTest_10861().checkConsume(utf);
    }
}
