import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_12541 {

    static int nameIndex = -1107159854;

    static int typeIndex = 1;

    static String singleClassName = "#L-G?-OS&3";

    static Class singleClass = null;

    static DataOutputStream dout = null;

    static int cpoolIndex = 0;

    int writeNameAndTypeConst(int nameIndex, int typeIndex) throws IOException {
        dout.writeByte(12);
        dout.writeShort((short) nameIndex);
        dout.writeShort((short) typeIndex);
        return cpoolIndex++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12541().writeNameAndTypeConst(nameIndex, typeIndex));
    }
}
