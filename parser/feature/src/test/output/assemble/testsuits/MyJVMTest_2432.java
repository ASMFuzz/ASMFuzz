import java.io.*;

public class MyJVMTest_2432 {

    static ObjectOutput out = null;

    static int intData = 4;

    static Object objData = new String("hello");

    ObjectOutput writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(intData);
        out.writeObject(objData);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2432().writeExternal(out);
    }
}
