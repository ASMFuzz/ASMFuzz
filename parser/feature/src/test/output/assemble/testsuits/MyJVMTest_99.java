import java.lang.management.*;
import java.util.*;

public class MyJVMTest_99 {

    static String name = "']07J@,*Yv";

    static long value = -5686010182675847484L;

    String formatSize(String name, long value) {
        StringBuffer buf = new StringBuffer(name + " = " + value);
        if (value > 0) {
            buf.append(" (" + (value >> 10) + "K)");
        }
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_99().formatSize(name, value));
    }
}
