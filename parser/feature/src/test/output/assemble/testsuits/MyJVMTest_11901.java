import java.io.*;
import java.util.*;

public class MyJVMTest_11901 {

    static ObjectOutput out = null;

    static int x = 1;

    static int y = 1;

    static Object obj = 0;

    ObjectOutput writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(x);
        out.writeInt(y);
        out.writeObject(obj);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11901().writeExternal(out);
    }
}
