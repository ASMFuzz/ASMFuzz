import java.io.*;

public class MyJVMTest_12679 {

    static byte[] inParam1Param1 = { -24, 82, 18, 1, 60, 116, -36, -105, -101, -7 };

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1);

    static ObjectInputStream in = new ObjectInputStream(inParam1);

    ObjectInputStream readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        throw new ClassNotFoundException();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12679().readObject(in);
    }
}
