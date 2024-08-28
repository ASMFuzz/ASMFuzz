import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_13252 {

    static int classIndex = 1;

    static int nameAndTypeIndex = 0;

    static String singleClassName = "Qw2HoL ]q*";

    static Class singleClass = null;

    static DataOutputStream dout = null;

    static int cpoolIndex = 6;

    int writeMethodRefConst(int classIndex, int nameAndTypeIndex) throws IOException {
        dout.writeByte(10);
        dout.writeShort((short) classIndex);
        dout.writeShort((short) nameAndTypeIndex);
        return cpoolIndex++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13252().writeMethodRefConst(classIndex, nameAndTypeIndex));
    }
}
