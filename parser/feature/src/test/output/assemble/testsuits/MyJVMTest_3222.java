import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_3222 {

    static int nameIndex = 0;

    static int typeIndex = 0;

    static String singleClassName = "ll\\U$ tO~]";

    static Class singleClass = null;

    static DataOutputStream dout = null;

    static int cpoolIndex = 1;

    int writeNameAndTypeConst(int nameIndex, int typeIndex) throws IOException {
        dout.writeByte(12);
        dout.writeShort((short) nameIndex);
        dout.writeShort((short) typeIndex);
        return cpoolIndex++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3222().writeNameAndTypeConst(nameIndex, typeIndex));
    }
}
