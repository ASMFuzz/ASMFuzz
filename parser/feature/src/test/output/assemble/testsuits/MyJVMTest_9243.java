import java.lang.management.*;
import java.util.*;

public class MyJVMTest_9243 {

    static String name = "{(]Ong!R,`";

    static long value = 9223372036854775807L;

    String formatSize(String name, long value) {
        StringBuffer buf = new StringBuffer(name + " = " + value);
        if (value > 0) {
            buf.append(" (" + (value >> 10) + "K)");
        }
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9243().formatSize(name, value));
    }
}
