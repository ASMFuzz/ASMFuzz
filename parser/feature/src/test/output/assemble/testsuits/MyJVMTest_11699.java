import java.io.*;

public class MyJVMTest_11699 {

    static ObjectOutput out = null;

    static int intData = 4;

    static Object objData = new String("hello");

    ObjectOutput writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(intData);
        out.writeObject(objData);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11699().writeExternal(out);
    }
}
