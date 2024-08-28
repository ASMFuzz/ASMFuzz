import java.io.*;
import java.util.*;

public class MyJVMTest_7946 {

    static ObjectInput in = null;

    static int x = 0;

    static int y = 0;

    static Object obj = 0;

    ObjectInput readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        x = in.readInt();
        y = in.readInt();
        obj = in.readObject();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7946().readExternal(in);
    }
}
