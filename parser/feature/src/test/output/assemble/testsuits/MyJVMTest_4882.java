import java.io.*;
import java.util.*;

public class MyJVMTest_4882 {

    static ObjectInput in = null;

    static String a = "+c&z6Ozuz]", b = ";rDf^+UnMm", c = "2b;YLN(^P-";

    ObjectInput readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readBoolean();
        a = (String) in.readObject();
        b = (String) in.readObject();
        c = (String) in.readObject();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4882().readExternal(in);
    }
}
