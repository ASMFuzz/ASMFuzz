import java.io.IOException;
import java.io.ObjectInputStream;

public class MyJVMTest_17456 {

    static ObjectInputStream in = new ObjectInputStream();

    static Object obj = -180899287;

    @SuppressWarnings("serial")
    static Object ref = -894516352;

    ObjectInputStream readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        SerialRef.obj = ref;
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17456().readObject(in);
    }
}
