import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_11174 {

    static int nameIndex = 3;

    static String singleClassName = "W&u4}$!KK|";

    static Class singleClass = null;

    static DataOutputStream dout = null;

    static int cpoolIndex = 3;

    int writeClassConst(int nameIndex) throws IOException {
        dout.writeByte(7);
        dout.writeShort((short) nameIndex);
        return cpoolIndex++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11174().writeClassConst(nameIndex));
    }
}
