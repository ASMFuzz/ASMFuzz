import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_3908 {

    static int classIndex = 0;

    static int nameAndTypeIndex = -1374504410;

    static String singleClassName = "rkJw#V-#c1";

    static Class singleClass = null;

    static DataOutputStream dout = null;

    static int cpoolIndex = 0;

    int writeMethodRefConst(int classIndex, int nameAndTypeIndex) throws IOException {
        dout.writeByte(10);
        dout.writeShort((short) classIndex);
        dout.writeShort((short) nameAndTypeIndex);
        return cpoolIndex++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3908().writeMethodRefConst(classIndex, nameAndTypeIndex));
    }
}
