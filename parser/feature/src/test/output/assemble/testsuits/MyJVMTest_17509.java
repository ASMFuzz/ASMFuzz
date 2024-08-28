import java.io.*;
import java.util.*;

public class MyJVMTest_17509 {

    static ObjectInput in = null;

    static int x = 0;

    static int y = 6;

    static Object obj = 831412656;

    ObjectInput readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        x = in.readInt();
        y = in.readInt();
        obj = in.readObject();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17509().readExternal(in);
    }
}
