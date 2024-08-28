import java.io.*;

public class MyJVMTest_12704 {

    static String str = "\\tU=ZB/WB8";

    static StringBuffer buf = null;

    String write(String str) {
        buf.append(str);
        return str;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12704().write(str);
    }
}
