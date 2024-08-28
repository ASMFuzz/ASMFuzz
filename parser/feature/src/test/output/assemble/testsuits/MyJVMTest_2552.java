import java.io.*;
import java.util.*;

public class MyJVMTest_2552 {

    static ObjectOutput out = null;

    static String a = "Xa8/Z'kN`3", b = "vLL=*je=}I", c = "5V$`_Tk%Y]";

    ObjectOutput writeExternal(ObjectOutput out) throws IOException {
        out.writeBoolean(false);
        out.writeObject(a);
        out.writeObject(b);
        out.writeObject(c);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2552().writeExternal(out);
    }
}
