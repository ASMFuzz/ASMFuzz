import java.util.prefs.*;
import java.io.*;

public class MyJVMTest_15692 {

    static Object o = 0;

    ObjectOutputStream test(Object o) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(o);
        out.flush();
        out.close();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15692().test(o);
    }
}
