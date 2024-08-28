import java.io.*;

public class MyJVMTest_3375 {

    static String str = "]FYXdch-CE";

    static StringBuffer buf = null;

    String write(String str) {
        buf.append(str);
        return str;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3375().write(str);
    }
}
