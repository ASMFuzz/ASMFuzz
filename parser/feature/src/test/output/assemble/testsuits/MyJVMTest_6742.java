import java.io.IOException;
import java.io.ObjectInputStream;

public class MyJVMTest_6742 {

    static ObjectInputStream in = new ObjectInputStream();

    static Object obj = 1;

    static Object ref = 5;

    ObjectInputStream readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        SerialRef.obj = ref;
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6742().readObject(in);
    }
}
