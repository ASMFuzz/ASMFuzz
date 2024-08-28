import java.io.*;

public class MyJVMTest_14572 {

    static byte[] inParam1Param1 = { 117, 123, -44, 112, -117, -33, 90, 14, -64, 55 };

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1);

    static ObjectInputStream in = new ObjectInputStream(inParam1);

    static Object obj = new Bar();

    ObjectInputStream readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        if (obj == null) {
            throw new Error("ClassNotFoundException masked by defaultReadObject()");
        }
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14572().readObject(in);
    }
}
