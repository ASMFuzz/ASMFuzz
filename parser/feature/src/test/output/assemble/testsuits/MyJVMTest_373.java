import java.io.*;

public class MyJVMTest_373 {

    static ObjectOutput s = null;

    static byte l = 80;

    ObjectOutput writeExternal(ObjectOutput s) throws IOException {
        s.writeByte(l);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_373().writeExternal(s);
    }
}
