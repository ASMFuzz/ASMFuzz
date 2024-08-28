import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_1938 {

    static int nameIndex = -1562710925;

    static String singleClassName = "m?^Cy=<?#P";

    static Class singleClass = null;

    static DataOutputStream dout = null;

    static int cpoolIndex = 2058006185;

    int writeClassConst(int nameIndex) throws IOException {
        dout.writeByte(7);
        dout.writeShort((short) nameIndex);
        return cpoolIndex++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1938().writeClassConst(nameIndex));
    }
}
