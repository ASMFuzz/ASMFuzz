import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class MyJVMTest_7894 {

    static byte[] inParam1Param1 = { -92, -27, -35, 121, 35, -106, 10, -82, -9, -97 };

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1);

    static ObjectInputStream in = new ObjectInputStream(inParam1);

    static Object obj = -136442270;

    @SuppressWarnings("serial")
    static Object ref = 1782990666;

    ObjectInputStream readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        SerialRef.obj = ref;
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7894().readObject(in);
    }
}
