import java.io.*;

public class MyJVMTest_15016 {

    static ObjectInput in = null;

    static int intData = 4;

    static Object objData = new String("hello");

    ObjectInput readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        intData = in.readInt();
        objData = in.readObject();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15016().readExternal(in);
    }
}
