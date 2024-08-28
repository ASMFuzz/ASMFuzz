import java.io.*;
import java.util.*;

public class MyJVMTest_11828 {

    static ObjectOutput out = null;

    static String a = "FF*D+*UC\"h", b = "gT;_;\\?M\"D", c = "{Y-f\"0nczI";

    ObjectOutput writeExternal(ObjectOutput out) throws IOException {
        out.writeBoolean(false);
        out.writeObject(a);
        out.writeObject(b);
        out.writeObject(c);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11828().writeExternal(out);
    }
}
