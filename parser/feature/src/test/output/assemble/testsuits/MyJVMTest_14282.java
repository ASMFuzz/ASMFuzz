import java.io.*;
import java.util.*;

public class MyJVMTest_14282 {

    static ObjectInput in = null;

    static String a = "IOcHy^k\\]a", b = "]ECH2>^!F%", c = "\"48Q<=uY~'";

    ObjectInput readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readBoolean();
        a = (String) in.readObject();
        b = (String) in.readObject();
        c = (String) in.readObject();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14282().readExternal(in);
    }
}
