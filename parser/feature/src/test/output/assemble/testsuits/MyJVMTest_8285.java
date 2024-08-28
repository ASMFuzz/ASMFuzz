import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_8285 {

    static String s = "t}af[0xJp(";

    static String singleClassName = "IMoTmI;h[W";

    static Class singleClass = null;

    static DataOutputStream dout = null;

    static int cpoolIndex = 2;

    int writeUTFConst(String s) throws IOException {
        dout.writeByte(1);
        dout.writeUTF(s);
        return cpoolIndex++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8285().writeUTFConst(s));
    }
}
