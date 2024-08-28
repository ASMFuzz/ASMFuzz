import java.util.prefs.*;
import java.io.*;

public class MyJVMTest_6219 {

    static Object o = 1359319485;

    ObjectOutputStream test(Object o) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(o);
        out.flush();
        out.close();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6219().test(o);
    }
}
