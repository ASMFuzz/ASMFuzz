import java.util.concurrent.*;
import java.lang.reflect.*;

public class MyJVMTest_7966 {

    static String string = "/x q'nfz?@";

    static Field valueField = null;

    static String s = ",`oA\"P7X}\\";

    static Object value = 2;

    static long valuePointer = -9223372036854775808L;

    Object getValue(String string) {
        try {
            return valueField.get(string);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7966().getValue(string));
    }
}
