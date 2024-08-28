import java.io.*;

public class MyJVMTest_9530 {

    static ObjectOutput s = null;

    static byte l = -128;

    ObjectOutput writeExternal(ObjectOutput s) throws IOException {
        s.writeByte(l);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9530().writeExternal(s);
    }
}
