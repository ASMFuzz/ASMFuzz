import java.io.*;

public class MyJVMTest_9858 {

    static ObjectInput s = null;

    static byte l = 127;

    ObjectInput readExternal(ObjectInput s) throws IOException, ClassNotFoundException {
        l = s.readByte();
        System.out.println("readExternal read " + l);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9858().readExternal(s);
    }
}
