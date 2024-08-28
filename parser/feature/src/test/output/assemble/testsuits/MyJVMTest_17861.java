import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_17861 {

    static String s = ",_8ho^hgA$";

    static String singleClassName = "m<Kfh[KPXi";

    static Class singleClass = null;

    static DataOutputStream dout = null;

    static int cpoolIndex = 0;

    int writeUTFConst(String s) throws IOException {
        dout.writeByte(1);
        dout.writeUTF(s);
        return cpoolIndex++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17861().writeUTFConst(s));
    }
}
