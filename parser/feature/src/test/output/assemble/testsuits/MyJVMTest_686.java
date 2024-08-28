import java.io.*;

public class MyJVMTest_686 {

    static ObjectInput s = null;

    static byte l = 0;

    ObjectInput readExternal(ObjectInput s) throws IOException, ClassNotFoundException {
        l = s.readByte();
        System.out.println("readExternal read " + l);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_686().readExternal(s);
    }
}
