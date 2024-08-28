import java.io.*;
import java.util.function.*;

public class MyJVMTest_17788 {

    static ObjectOutput out = null;

    ObjectOutput write(ObjectOutput out) throws IOException {
        Object res = (Predicate<String> & Serializable) ((str) -> str.length() > 3);
        out.writeObject(res);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17788().write(out);
    }
}
