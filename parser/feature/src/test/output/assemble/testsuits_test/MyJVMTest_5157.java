import java.io.*;

public class MyJVMTest_5157 {

    static byte[] inParam1Param1 = { -12, -21, -127, -69, 125, 120, -86, -26, 89, 54 };

    static int inParam1Param2 = 964;

    static int inParam1Param3 = 678;

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1, inParam1Param2, inParam1Param3);

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
        new MyJVMTest_5157().readObject(in);
    }
}
