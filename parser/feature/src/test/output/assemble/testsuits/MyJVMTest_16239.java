import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class MyJVMTest_16239 {

    static byte[] inParam1Param1 = { -114, -64, -19, -32, 59, -107, -106, -100, 84, -21 };

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1);

    static ObjectInputStream in = new ObjectInputStream(inParam1);

    static Object obj = 7;

    static Object ref = 9;

    ObjectInputStream readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        SerialRef.obj = ref;
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16239().readObject(in);
    }
}
