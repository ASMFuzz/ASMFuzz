import java.io.*;
import java.util.*;

public class MyJVMTest_2620 {

    static ObjectOutput out = null;

    static int x = 1414362708;

    static int y = 894834759;

    static Object obj = 8;

    ObjectOutput writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(x);
        out.writeInt(y);
        out.writeObject(obj);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2620().writeExternal(out);
    }
}
