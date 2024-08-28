import java.io.*;

public class MyJVMTest_4611 {

    static Object obj = 6;

    ObjectOutputStream test(Object obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(bout);
        oout.useProtocolVersion(ObjectStreamConstants.PROTOCOL_VERSION_2);
        oout.writeObject(obj);
        oout.close();
        ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        try {
            oin.readObject();
            throw new Error();
        } catch (ClassNotFoundException ex) {
        }
        return oout;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4611().test(obj);
    }
}
